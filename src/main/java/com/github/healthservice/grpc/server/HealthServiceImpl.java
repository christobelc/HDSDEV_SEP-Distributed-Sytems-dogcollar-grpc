package com.github.healthservice.grpc.server;

import com.github.healthservice.grpc.*;
import io.grpc.stub.StreamObserver;


public class HealthServiceImpl extends HealthServiceGrpc.HealthServiceImplBase {
    @Override
    public void checkTemperature(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {
        String currentTemp = request.getCurrentTempRequest();
        //whats the body temperature of the dog?
        System.out.println(currentTemp);
        //The collars Thermometer takes a reading of the dogs temperature
        currentTemp = "37";

        String result = "The dogs current body temperature is: " + currentTemp + "c. ";
        TemperatureResponse temperatureResponse = TemperatureResponse.newBuilder()
                .setResult(result)
                .build();

        // send the response back to the responseObserver obj
        responseObserver.onNext(temperatureResponse);

        //complete the grpc call
        responseObserver.onCompleted();
    }

    @Override
    public void stepCounter(PedometerRequest request, StreamObserver<PedometerResponse> responseObserver) {
        //get the pedometer active flag from the collar
        boolean isActive = request.getPedometerStatus().getIsActive();

        // the dog owner wishes to continue the step count from previous tracking
        int currentCount = request.getPedometerStatus().getPreviousCount();

        //Calculation is done on the average speed, here we dont have real sensor data so we hardcode
        double avgSpeed = 3.9;


        //if the collar is on properly and the pedometer is ready and active
        //if(isActive)
            try{
                //begin the counting each second
                for (int i = 0; i < 120; i+=4){
                    String result = "Current Steps: " + (currentCount + i);
                    //calc avg speed
                    avgSpeed += 0.01;
                    PedometerResponse pedometerResponse = PedometerResponse.newBuilder()
                            .setResult(result)
                            .setAvgSpeed(avgSpeed)
                            .build();
                    responseObserver.onNext(pedometerResponse);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally {
                responseObserver.onCompleted();
            }

    }

    @Override
    public void bpmCounter(HeartBeatSensorRequest request, StreamObserver<HeartBeatSensorResponse> responseObserver) {
        //checks if the sensor is ready and available to use
        boolean isActive = request.getHeartBeatSensorStatus().getIsActive();
        //shows how much time the sensor has been uploading data,
        double previousUsageTime = request.getHeartBeatSensorStatus().getPreviousUsageTime();
        int bpm;
        try{
            //lets read the bpm in real time, hardcoded values for demo purposes
            for (int i = 0; i < 30; i++){
                if (i%2 == 0){
                    bpm = 69;
                }else{
                    bpm = 68;
                }
                String result = "Current bpm: " + bpm;
                HeartBeatSensorResponse heartBeatSensorResponse = HeartBeatSensorResponse.newBuilder()
                        .setResult(result)
                        .build();
                responseObserver.onNext(heartBeatSensorResponse);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            responseObserver.onCompleted();
        }
    }
}
