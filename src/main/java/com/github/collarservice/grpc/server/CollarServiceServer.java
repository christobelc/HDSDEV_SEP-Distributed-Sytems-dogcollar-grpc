package com.github.collarservice.grpc.server;

import com.github.healthservice.grpc.server.HealthServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CollarServiceServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("This is the gRPC server");

        Server server = ServerBuilder.forPort(50052)
                .addService(new CollarServiceImpl())
                .build();

        server.start();
        System.out.println("Server has started!");

        Runtime.getRuntime().addShutdownHook(new Thread( () ->{
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the server");

        }));
        server.awaitTermination();
    }
}
