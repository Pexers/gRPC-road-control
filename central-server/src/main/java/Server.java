/*
 * Copyright (c) 21/8/2021, Pexers (https://github.com/Pexers)
 */

import centralservice.Contract.*;
import centralservice.CentralServiceGrpc.*;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Scanner;

public class Server extends CentralServiceImplBase {

    private static int svcPort = 7500;
    private static final float[][] tariffs = {
            {0, 2.5f, 3, 8, 10},
            {2.5f, 0, 3.5f, 4, 4},
            {3, 3.5f, 0, 2, 4},
            {8, 4, 2, 0, 4},
            {10, 4, 4, 4, 0}
    };

    public static void main(String[] args) {
        try {
            if (args.length > 0) svcPort = Integer.parseInt(args[0]);
            io.grpc.Server svc = ServerBuilder
                    .forPort(svcPort)
                    .addService(new Server())
                    .build();

            svc.start();
            System.out.println("Server started, listening on " + svcPort);
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            svc.shutdown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void payment(Track request, StreamObserver responseObserver) {
        int inPoint = request.getInPoint(), outPoint = request.getOutPoint();
        if (inPoint >= tariffs.length || outPoint >= tariffs[0].length) {
            responseObserver.onNext(Tariff.newBuilder()
                    .setValue(-1)
                    .build());
            responseObserver.onCompleted();
            return;
        }
        float tariff = tariffs[inPoint][outPoint];
        responseObserver.onNext(Tariff.newBuilder()
                .setValue(tariffs[inPoint][outPoint])
                .build());
        responseObserver.onCompleted();
        System.out.println("Sent a tariff of " + tariff);
    }

}
