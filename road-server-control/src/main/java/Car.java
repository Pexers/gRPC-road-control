/*
 * Copyright (c) 21/8/2021, Pexers (https://github.com/Pexers)
 */

import roadservice.Contract.WarnMsg;
import io.grpc.stub.StreamObserver;

public class Car {
    public final int inPoint;
    public final StreamObserver<WarnMsg> responseObserver;

    public Car(int inPoint, StreamObserver<WarnMsg> responseObserver) {
        this.inPoint = inPoint;
        this.responseObserver = responseObserver;
    }
}
