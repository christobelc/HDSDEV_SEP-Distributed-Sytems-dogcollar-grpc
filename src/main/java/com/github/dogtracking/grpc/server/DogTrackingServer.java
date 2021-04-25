package com.github.dogtracking.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.jmdns.JmDNS;
import java.io.IOException;

public class DogTrackingServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("This is the gRPC server");

//        int port = 50052;
        //Can make up the name
//        String service_type = "_grpc2.tcp.local.";
        //Can make this up too
//        String service_name = "GrpcServer2";
//        SimpleServiceRegistration ssr2 = new SimpleServiceRegistration();
//        ssr2.run(port, service_type, service_name);



        Server server = ServerBuilder.forPort(50055)
                .addService(new DogTrackingImpl())
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