package com.github.collarservice.grpc.server;


import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

public class CollarServiceServerJmDNS {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("This is the gRPC server");

        CollarServiceServerJmDNS collarServiceServerJmDNS = new CollarServiceServerJmDNS();

        Properties properties = collarServiceServerJmDNS.getProperties();

        collarServiceServerJmDNS.registerService(properties);

        int port = Integer.parseInt(properties.getProperty("service_port"));

        try{
            Server server = ServerBuilder.forPort(port)
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
        } catch (IOException | InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
    }

    public Properties getProperties() {

        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/properties/collarservice.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Collar Service properties ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
            System.out.println("\t service_port: " +prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    public void registerService(Properties prop) {

        //get a jMDNS instance
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            /*
             * service information
             */

            String service_type = prop.getProperty("service_type");//"_http._tcp.local.";
            String service_name = prop.getProperty("service_name");// "example";
            String service_desc = prop.getProperty("service_description");//
            // int service_port = 1234;
            int service_port = Integer.parseInt( prop.getProperty("service_port"));// #.50052;

            //the assumption is that we are registering a grpc server
            //service_type = "_grpc._tcp.local.";
            // service-type.domain
            // service_name + service_type => simple_http._tcp.local
            //String service_name = "GrpcServer";
//            int service_port = port;
//            String service_desc = "test integration of jmDNS with gRPC";


            //Create ServiceInfo -
            //use the factory method to create the object
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);

            /*
             * register the service
             */

            jmdns.registerService(serviceInfo);

            System.out.printf("registering service with type: %s and name: %s on port %d ", service_type, service_name, service_port);

            //sleep for 1 seconds
            Thread.sleep(1000);
            System.out.println("\nService Registered");
            //unregister the services
            //jmdns.unregisterAllServices();   //you could also unregister a single service


        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
