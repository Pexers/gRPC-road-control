/*
 * Copyright (c) 21/8/2021, Pexers (https://github.com/Pexers)
 */

import roadservice.Contract.Void;
import roadservice.Contract.*;
import roadservice.RoadServiceGrpc.*;
import roadservice.RoadServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Scanner;

public class Client {

    private static String svcIP = "localhost";
    private static int svcPort = 8000;
    private static RoadServiceBlockingStub blockingStub;
    private static RoadServiceStub noBlockStub;
    private static final WarningStreamObserver req = new WarningStreamObserver();
    private static StreamObserver<WarnMsg> rpy;
    private static String carID;

    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                svcIP = args[0];
                svcPort = Integer.parseInt(args[1]);
            }
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress(svcIP, svcPort).usePlaintext().build();
            blockingStub = RoadServiceGrpc.newBlockingStub(channel);
            noBlockStub = RoadServiceGrpc.newStub(channel);
            int option = -1;
            while (option != 99) {
                option = getClientOption();
                Scanner scan = new Scanner(System.in);
                if (carID == null) {
                    if (option == 0) {
                        enter(scan);
                    }
                } else {
                    switch (option) {
                        case 0: {
                            enableWarnings();
                            break;
                        }
                        case 1: {
                            sendWarning(scan);
                            break;
                        }
                        case 2: {
                            leave(scan);
                            break;
                        }
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void enter(Scanner scan) {
        System.out.println("What's your carID?");
        carID = scan.nextLine();
        System.out.println("What's the entry point?");
        int inPoint = Integer.parseInt(scan.nextLine());
        Void enterResult = blockingStub.enter(EntryPoint.newBuilder()
                .setCarID(carID)
                .setInPoint(inPoint)
                .build());
    }

    private static void enableWarnings() {
        WarnMsg wm = WarnMsg.newBuilder()
                .setCarID(carID)
                .setMessage("")
                .build();
        // Checking if we already sent any warnings
        if (rpy == null)
            rpy = noBlockStub.enableWarnings(req);
        rpy.onNext(wm);
    }

    private static void sendWarning(Scanner scan) {
        if (rpy == null) {
            System.out.println("You need to enable warnings first.");
            return;
        }
        System.out.println("What's the warning message?");
        String warn = scan.nextLine();
        WarnMsg wm = WarnMsg.newBuilder()
                .setCarID(carID)
                .setMessage(warn)
                .build();
        rpy.onNext(wm);
    }

    private static void leave(Scanner scan) {
        System.out.println("What's the out point?");
        int outPoint = Integer.parseInt(scan.nextLine());
        Payment payment = blockingStub.leave(FinalPoint.newBuilder().
                setCarID(carID)
                .setOutPoint(outPoint)
                .build());
        // If the client didn't send any warnings, the instance of server observer doesn't exist
        if (rpy != null)
            rpy.onCompleted();
        rpy = null;
        carID = null;
        System.out.println("Received a payment of " + payment.getValue());
    }

    private static int getClientOption() {
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            if (carID == null) {
                System.out.println(" 0: Enter road");
            } else {
                System.out.println(" 0: Enable warnings");
                System.out.println(" 1: Send warning");
                System.out.println(" 2: Leave road");
            }
            System.out.println("..........");
            System.out.println("99: Exit");
            System.out.print("Enter an Option:");
            option = scan.nextInt();
        } while (!((option >= 0 && option <= 2) || option == 99));
        return option;
    }

}
