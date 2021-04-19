package com.github.dogtracking.grpc.client;


import com.github.dogtracking.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.List;


public class DogTrackingClient {

    public static void main(String[] args) {
        System.out.println("Hello I'm a gRPC client");

        DogTrackingClient main = new DogTrackingClient();
        main.run();

        System.out.println("Making Stub");

    }

    private void run(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        //unary grpc method
//        doWearingCollar(channel);

        //server streaming grpc method
//        doUpdateLocation(channel);

        //bidirectional grpc method
        doFindTheDog(channel);

        // do something
        System.out.println("Channel Shutdown!");
        channel.shutdown();

    }

    //unary grpc method
    private void doWearingCollar(ManagedChannel channel){

        // created a service client (Synchronous - Blocking)
        DogTrackingGrpc.DogTrackingBlockingStub dogTracker = DogTrackingGrpc.newBlockingStub(channel);
        //----------------unary method-----------------------
        // make the protocol buffer current status message
        CurrentStatus currentStatus = CurrentStatus.newBuilder()
                .setWearing(true)
                .setHeartBeatSensorBPM(40)
                .setThermometerBodyTemp(36.8)
                .build();

        // Get request message
        WearingCollarRequest wearingCollarRequest = WearingCollarRequest.newBuilder()
                .setCurrentStatus(currentStatus)
                .build();

        //pass the request message, call the gRPC method
        WearingCollarResponse wearingCollarResponse = dogTracker.wearingCollar(wearingCollarRequest);

        System.out.println(wearingCollarResponse.getResult());
    }

    //server streaming
    private void doUpdateLocation(ManagedChannel channel){
        // created a service client (Synchronous - Blocking)
        DogTrackingGrpc.DogTrackingBlockingStub dogTracker = DogTrackingGrpc.newBlockingStub(channel);

        //pass the data from the messages, prepare the request
        SafetyZoneRequest safetyZoneRequest = SafetyZoneRequest.newBuilder()
                .setSafeZoneCoordinates1(SafeZoneCoordinates.newBuilder().setLatitude(49.09))
                .setSafeZoneCoordinates1(SafeZoneCoordinates.newBuilder().setLongitude(49.12))
                .setSafeZoneCoordinates2(SafeZoneCoordinates.newBuilder().setLatitude(48.08))
                .setSafeZoneCoordinates2(SafeZoneCoordinates.newBuilder().setLongitude(48.00))
                .setSafeZoneCoordinates3(SafeZoneCoordinates.newBuilder().setLatitude(47.09))
                .setSafeZoneCoordinates3(SafeZoneCoordinates.newBuilder().setLongitude(47.12))
                .setSafeZoneCoordinates4(SafeZoneCoordinates.newBuilder().setLatitude(46.08))
                .setSafeZoneCoordinates4(SafeZoneCoordinates.newBuilder().setLongitude(46.00))
                .build();

        //stream the responses in blocking
        dogTracker.outOfBoundsLocation(safetyZoneRequest).forEachRemaining(updateLocationResponse -> {
            System.out.println(updateLocationResponse.getResult());
        });
    }

    private void doFindTheDog(ManagedChannel channel) {

        //Asynchronous Stub
        DogTrackingGrpc.DogTrackingStub asyncClient = DogTrackingGrpc.newStub(channel);

         StreamObserver<OwnerLocationRequest> requestObserver = asyncClient.findTheDog(new StreamObserver<DogLocationResponse>() {
            @Override
            public void onNext(DogLocationResponse value) {
                System.out.println("Response from server: " + value.getDogCoordinates());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
            System.out.println("System is done sending data");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

         List<String> list = Arrays.asList("54.000000N 52.000000W", "54.010000N 52.0200000W","54.000000N 52.000000W",
                 "54.000000N 52.000000W", "54.010000N 52.0200000W","54.000000N 52.000000W");

            for (String coordinates: list) {
                System.out.println("The dog's current coordinates: " + coordinates);
                requestObserver.onNext(OwnerLocationRequest.newBuilder()
                    .setOwnerCoordinates(coordinates)
                    .build());
                try {
                    Thread.sleep(200);
                    System.out.println("Waiting 2 seconds......");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            requestObserver.onCompleted();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
