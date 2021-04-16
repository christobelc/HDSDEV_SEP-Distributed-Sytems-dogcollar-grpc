package com.github.collarservice.grpc.client;

import com.github.collarservice.grpc.*;

import com.github.greet.grpc.GreetServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CollarServiceClient {

    public static void main(String[] args) {
        System.out.println("Hello I'm a gRPC client");

        CollarServiceClient main = new CollarServiceClient();
        main.run();

        System.out.println("Making Stub");
    }

    public void run(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        //doServerStreamingCall(channel);
        doClientStreamingCall(channel);

        System.out.print("The Channel is shutting down!");
        channel.shutdown();
    }

    private void doServerStreamingCall(ManagedChannel channel){
        // created a service client (Synchronous - Blocking)
        CollarServiceGrpc.CollarServiceBlockingStub collarService = CollarServiceGrpc.newBlockingStub(channel);

        //---------------Server Streaming led light reader---------------

        //build request
        LedLightRequest ledLightRequest = LedLightRequest.newBuilder()
                .setLedLightStatus(LedLightStatus.newBuilder().setTurnOn(false))
                .setLedLightStatus(LedLightStatus.newBuilder().setBattery(50))
                .build();

        //Stream in a blocking way!
        collarService.collarLight(ledLightRequest)
                .forEachRemaining(ledLightResponse -> {
                    System.out.println(ledLightResponse.getResult());
                });
    }

    private void doClientStreamingCall(ManagedChannel channel){
        // make a client stub
        CollarServiceGrpc.CollarServiceBlockingStub collarService = CollarServiceGrpc.newBlockingStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        CollarServiceGrpc.CollarServiceStub asyncClient = CollarServiceGrpc.newStub(channel);
        StreamObserver<StreamVoiceRequest> requestObserver = asyncClient.streamVoice(new StreamObserver<StreamVoiceResponse>() {
            @Override
            public void onNext(StreamVoiceResponse value) {
                //we get a response from the server
                System.out.println("Received a response from the server ");
                System.out.println(value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                // we get an error from the server
            }

            @Override
            public void onCompleted() {
                // the server finished sending data
                //onCompleted will be called right after onNext()
                System.out.println("Server has completed sending us something ");
                latch.countDown();
            }
        });

        // 1st message
        requestObserver.onNext(StreamVoiceRequest.newBuilder()
                    .setVoiceMessages(VoiceMessages.newBuilder()
                            .setMessage1("Come Home Fido")
                            .build())
                    .build());
        System.out.println("Sent Message 1:");

        // 2nd message
        requestObserver.onNext(StreamVoiceRequest.newBuilder()
                .setVoiceMessages(VoiceMessages.newBuilder()
                        .setMessage2("Dinner is ready")
                        .build())
                .build());
        System.out.println("Sent Message 2:");

        // 3rd message
        requestObserver.onNext(StreamVoiceRequest.newBuilder()
                .setVoiceMessages(VoiceMessages.newBuilder()
                        .setMessage3("Quickly Come Home Fido")
                        .build())
                .build());
        System.out.println("Sent Message 3:");

        // after all the messages are sent we tell the server that sending data is finished
        requestObserver.onCompleted();

        //latch is required to give time for server response
        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
