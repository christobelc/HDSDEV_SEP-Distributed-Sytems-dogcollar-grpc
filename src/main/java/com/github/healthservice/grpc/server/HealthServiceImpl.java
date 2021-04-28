package com.github.healthservice.grpc.server;

import com.github.healthservice.grpc.*;
import io.grpc.stub.StreamObserver;


public class HealthServiceImpl extends HealthServiceGrpc.HealthServiceImplBase {
    @Override
    public void checkTemperature(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {
        int currentTemp = request.getCurrentTempRequest();
        //whats the body temperature of the dog?
        System.out.println(currentTemp);
        //The collars Thermometer takes a reading of the dogs temperature

//        fahrenheit calc
        double fahrenheitCalc = ((double)currentTemp)* (9/(double)5)+32;

        String result = "The dogs current body temperature is: " + currentTemp + "c or " + fahrenheitCalc + "f.";
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
        String result;

        System.out.println("Pedometer Active: " + isActive);
        //if the collar is on properly and the pedometer is ready and active
//        if(isActive){
            try{
                //begin the counting each second
                for (int i = 0; i < 30; i+=4){
                    result = "Current Steps: " + (currentCount + i);
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
//        }else{
//            result = "There is no response from the pedometer!";
//            PedometerResponse pedometerResponse = PedometerResponse.newBuilder()
//                    .setResult(result)
//                    .setAvgSpeed(0.0)
//                    .build();
//            responseObserver.onNext(pedometerResponse);
//            responseObserver.onCompleted();
//        }
    }

    @Override
    public void bpmCounter(HeartBeatSensorRequest request, StreamObserver<HeartBeatSensorResponse> responseObserver) {
        //checks if the sensor is ready and available to use
        boolean isActive = request.getHeartBeatSensorStatus().getIsActive();
        //shows how much time the sensor has been uploading data,
        double previousUsageTime = request.getHeartBeatSensorStatus().getPreviousUsageTime();
        int bpm;
        try{
            //lets read the bpm in real time, hardcoded fake values for demo purposes
            for (int i = 0; i < 10; i++){
                if (i%2 == 0){
                    bpm = 69;
                }else{
                    bpm = 68;
                }
                //get the passed values from client for previous usage time
                String hrsMinsSecs = String.valueOf(previousUsageTime);
                //split into hrs and minutes
                String [] values = hrsMinsSecs.split("\\.",2);
                int hrs = Integer.parseInt(values[0]);
                int mins = Integer.parseInt(values[1]);
                //build the string of results
                String result = "Current bpm: " + bpm + " | Total usage time:: "+ hrs +" hours - "  +  mins +" minutes - " + i + " seconds";
                //build the response
                HeartBeatSensorResponse heartBeatSensorResponse = HeartBeatSensorResponse.newBuilder()
                        .setResult(result)
                        .build();
                responseObserver.onNext(heartBeatSensorResponse);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            //complete the gRPC call
            responseObserver.onCompleted();
        }
    }
}
