package com.github.dogtracking.grpc.client;

import com.github.dogtracking.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DogTrackingClient {
    public static void main(String[] args) {
        System.out.println("Hello I'm a gRPC client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Making Stub");

        // created a service client (Synchronous - Blocking)
        DogTrackingGrpc.DogTrackingBlockingStub dogTracker = DogTrackingGrpc.newBlockingStub(channel);

        //----------------unary method-----------------------
//        // make the protocol buffer current status message
//        CurrentStatus currentStatus = CurrentStatus.newBuilder()
//                .setWearing(true)
//                .setHeartBeatSensorBPM(40)
//                .setThermometerBodyTemp(36.8)
//                .build();
//
//        // Get request message
//        WearingCollarRequest wearingCollarRequest = WearingCollarRequest.newBuilder()
//                .setCurrentStatus(currentStatus)
//                .build();
//
//        //pass the request message, call the gRPC method
//        WearingCollarResponse wearingCollarResponse = dogTracker.wearingCollar(wearingCollarRequest);
//
//        System.out.println(wearingCollarResponse.getResult());


        //----------------Server Streaming ------------------
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

        // do something
        System.out.println("Channel Shutdown!");
        channel.shutdown();
    }
}
