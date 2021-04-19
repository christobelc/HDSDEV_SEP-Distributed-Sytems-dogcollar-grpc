package com.github.collarservice.grpc.server;

import com.github.collarservice.grpc.*;
import com.github.healthservice.grpc.PedometerResponse;
import io.grpc.stub.StreamObserver;

public class CollarServiceImpl extends CollarServiceGrpc.CollarServiceImplBase {
    @Override
    public void collarLight(LedLightRequest request, StreamObserver<LedLightResponse> responseObserver) {
        //read the current state of the light, on/off
        boolean active = request.getLedLightStatus().getTurnOn();
        //read the current battery percentage left
        int battery = request.getLedLightStatus().getBattery();

        //take the reading for illuminance from the light sensor, hard code the value for demo purposes
        double luxValue = 50;

        // if the lux value of the light falls below a certain point
        //while(luxValue < 100)
            //turn on the light
            //if(!active)
            active = true;
        try{
            //lets read the lux value of the light in real time, hardcoded values for demo purposes
            for (int i = 0; i < 30; i++){
                if (i%2 == 0){
                    luxValue = 51;
                }else{
                    luxValue = 50;
                }
                //prepare result
                String result = "Current brightness(lux) outside: " + luxValue
                        + " | Led light: on | Battery: " + battery +"%";

                //build response
                LedLightResponse ledLightResponse = LedLightResponse.newBuilder()
                        .setResult(result)
                        .build();

                //pass response
                responseObserver.onNext(ledLightResponse);
                Thread.sleep(1500);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            //complete the response
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<StreamVoiceRequest> streamVoice(StreamObserver<StreamVoiceResponse> responseObserver) {
        StreamObserver<StreamVoiceRequest> requestObserver = new StreamObserver<StreamVoiceRequest>() {

            String result = "";

            @Override
            public void onNext(StreamVoiceRequest value) {
                //client sends a messages for demo purposes sent one string with all the messages
                result += "........." + value.getVoiceMessages().getMessage1()
                        + "........." + value.getVoiceMessages().getMessage2()
                        + "........." + value.getVoiceMessages().getMessage3();
            }

            @Override
            public void onError(Throwable t) {
                //client sends an error
            }

            @Override
            public void onCompleted() {
                // client is finished sending
                responseObserver.onNext(
                        StreamVoiceResponse.newBuilder()
                        .setResult(result)
                        .build()
                );
                responseObserver.onCompleted();
                // this is when we want to return a response using responseObserver
            }
        };
        return requestObserver;
    }
}
