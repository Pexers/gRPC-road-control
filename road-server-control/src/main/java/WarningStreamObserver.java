/*
 * Copyright (c) 21/8/2021, Pexers (https://github.com/Pexers)
 */

import roadservice.Contract.WarnMsg;
import io.grpc.stub.StreamObserver;

public class WarningStreamObserver implements StreamObserver<WarnMsg> {

    StreamObserver<WarnMsg> sender;

    public WarningStreamObserver(StreamObserver<WarnMsg> sender) {
        this.sender = sender;
    }

    @Override
    public void onNext(WarnMsg warnMsg) {
        String senderID = warnMsg.getCarID();
        // If the car is not on the road, we ignore his warnings
        if (!Server.map.containsKey(senderID))
            return;
        Car senderCar = Server.map.get(senderID);
        if (senderCar.responseObserver == null) { // If true, client is enabling warnings
            Server.map.put(senderID, new Car(senderCar.inPoint, sender));
            System.out.println("Car with ID '" + senderID + " is enabled for warnings");
            return;
        }
        WarnMsg serverWarnMsg = WarnMsg.newBuilder()
                .setCarID(senderID)
                .setMessage("[WARNING]: " + warnMsg.getMessage())
                .build();
        Server.map.forEach((carID, carInstance) -> {
            if (!senderID.equals(carID) && carInstance.responseObserver != null) {
                try {
                    carInstance.responseObserver.onNext(serverWarnMsg);
                } catch (Exception e) {
                    // If the car "disappears" from the road, the server removes him.
                    Server.map.remove(carID);
                    System.out.println("Car with ID '" + carID + "' was removed from the road.");
                }
            }
        });
        System.out.println("Car with ID '" + senderID + "' sent the following warning: '" + warnMsg.getMessage() + "'");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Something went wrong");
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        sender.onCompleted();
    }

}
