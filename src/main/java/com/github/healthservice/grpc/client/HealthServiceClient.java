package com.github.healthservice.grpc.client;

import com.github.healthservice.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HealthServiceClient {
    public static void main(String[] args) {
        System.out.println("Hello I'm a gRPC client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Making Stub");

        // created a service client (Synchronous - Blocking)
        HealthServiceGrpc.HealthServiceBlockingStub healthService = HealthServiceGrpc.newBlockingStub(channel);

        //---------------Unary Temperature Checking method-------------------
//        //Request
//        TemperatureRequest temperatureRequest = TemperatureRequest.newBuilder()
//                .setCurrentTempRequest("Temperature request")
//                .build();
//
//        //Response
//        TemperatureResponse temperatureResponse = healthService.checkTemperature(temperatureRequest);
//        System.out.println(temperatureResponse.getResult());

        //---------------Server Streaming step counter method ---------------

//        PedometerRequest pedometerRequest = PedometerRequest.newBuilder()
//                .setPedometerStatus(PedometerStatus.newBuilder().setIsActive(true))
//                .setPedometerStatus(PedometerStatus.newBuilder().setPreviousCount(3500))
//                .build();
//        System.out.println("We are here!");
//
//        //Stream in a blocking way
//        healthService.stepCounter(pedometerRequest)
//                .forEachRemaining(pedometerResponse -> {
//                    System.out.println(pedometerResponse.getResult());
//                    System.out.println("The avg speed KPH is: "+pedometerResponse.getAvgSpeed());
//                });

        //---------------Heartbeat sensor streaming method ---------------

        HeartBeatSensorRequest heartBeatSensorRequest = HeartBeatSensorRequest.newBuilder()
                .setHeartBeatSensorStatus(HeartBeatSensorStatus.newBuilder().setIsActive(true))
                .setHeartBeatSensorStatus(HeartBeatSensorStatus.newBuilder().setPreviousUsageTime(3.00))
                .build();

        //Stream in a blocking way!
        healthService.bpmCounter(heartBeatSensorRequest)
                .forEachRemaining(heartBeatSensorResponse -> {
                    System.out.println(heartBeatSensorResponse.getResult());
                });


        //do something
        System.out.println("Channel Shutdown");
        channel.shutdown();
    }
}
