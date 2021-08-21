
import centralservice.Contract.*;
import centralservice.CentralServiceGrpc.*;
import centralservice.CentralServiceGrpc;
import roadservice.Contract.Void;
import roadservice.Contract.*;
import roadservice.RoadServiceGrpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Server extends RoadServiceImplBase {

    private static int svcPort = 8000;
    private static String svcCentralIP = "localhost";
    private static int svcCentralPort = 7500;
    private static CentralServiceBlockingStub blockingStub;
    public static final ConcurrentHashMap<String, Car> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try {
            if (args.length > 0) svcPort = Integer.parseInt(args[0]);
            io.grpc.Server svc = ServerBuilder
                    .forPort(svcPort)
                    .addService(new Server())
                    .build();
            svc.start();

            if (args.length == 2) {
                svcCentralIP = args[0];
                svcCentralPort = Integer.parseInt(args[1]);
            }
            // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
            // needing certificates.
            ManagedChannel channel = ManagedChannelBuilder.forAddress(svcCentralIP, svcCentralPort)
                    .usePlaintext()
                    .build();
            blockingStub = CentralServiceGrpc.newBlockingStub(channel);

            System.out.println("Server started, listening on " + svcPort);
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            svc.shutdown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void enter(EntryPoint request, StreamObserver responseObserver) {
        String carID = request.getCarID();
        int carInPoint = request.getInPoint();

        if (map.containsKey(carID)) {
            // The car already entered the road
            responseObserver.onNext(Void.newBuilder().build());
            responseObserver.onCompleted();
            return;
        }
        if (carInPoint < 1 || carInPoint > 5) {
            // The road doesn't exist
            responseObserver.onNext(Void.newBuilder().build());
            responseObserver.onCompleted();
            return;
        }
        map.put(carID, new Car(carInPoint, null));
        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
        System.out.println("Car with ID '" + carID + "' entered the road.");
    }

    @Override
    public StreamObserver<WarnMsg> enableWarnings(StreamObserver<WarnMsg> responseObserver) {
        return new WarningStreamObserver(responseObserver);
    }

    @Override
    public void leave(FinalPoint request, StreamObserver<Payment> responseObserver) {
        String carId = request.getCarID();
        int carOutPoint = request.getOutPoint();

        // If the car is not on the road, the payment is zero
        if (!map.containsKey(carId)) {
            responseObserver.onNext(Payment.newBuilder()
                    .setValue(0)
                    .build());
            responseObserver.onCompleted();
            return;
        }
        if (carOutPoint < 1 || carOutPoint > 5) {
            responseObserver.onNext(Payment.newBuilder()
                    .setValue(0)
                    .build());
            responseObserver.onCompleted();
            return;
        }
        Car roadCar = map.get(carId);
        map.remove(carId);

        Tariff tar = blockingStub.payment(Track.newBuilder()
                .setInPoint(roadCar.inPoint)
                .setOutPoint(carOutPoint)
                .build());
        responseObserver.onNext(Payment.newBuilder()
                .setValue(tar.getValue())
                .build());
        responseObserver.onCompleted();
        System.out.println("Car with ID '" + carId + "' left the road with a payment of " + tar.getValue());
    }

}
