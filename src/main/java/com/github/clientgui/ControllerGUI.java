package com.github.clientgui;

import com.github.collarservice.grpc.*;
import com.github.dogtracking.grpc.*;
import com.github.healthservice.grpc.*;
import com.github.jmdns.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ControllerGUI implements ActionListener {
    private JTextField entry1, entry11, entry111, reply1;
    private JTextField entry2, entry22, entry222, entry2222;
    private JTextArea  reply2;
    private JTextField entry3;
    private JTextArea reply3;

    private JTextField entry4, reply4;
    private JTextField entry5, entry55;
    private JTextArea reply5;
    private JTextField entry6, entry66;
    private JTextArea reply6;
    private JTextField entry7, entry77;
    private JTextArea reply7;
    private JTextField entry8, entry88, entry888;
    private JTextArea reply8;


    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Wearing Collar | BPM | Body Temp");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("",3);
        panel.add(entry1);
        entry11 = new JTextField("",3);
        panel.add(entry11);
        entry111 = new JTextField("",3);
        panel.add(entry111);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("CollarStatus");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply1 = new JTextField("", 50);
        reply1 .setEditable(false);
        panel.add(reply1 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("SafeZone Coordinates |'dd.dd,dd.dd'");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("",3);
        panel.add(entry2);
        entry22 = new JTextField("",3);
        panel.add(entry22);
        entry222 = new JTextField("",3);
        panel.add(entry222);
        entry2222 = new JTextField("",3);
        panel.add(entry2222);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Dog's Location");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextArea(10, 50);
        reply2 .setEditable(false);
        panel.add(reply2 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService3JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Dog's coordinates")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry3 = new JTextField("",10);
        panel.add(entry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Stream location");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply3 = new JTextArea(10, 10);
        reply3 .setEditable(false);
        panel.add(reply3 );


        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService4JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Body Temperature")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry4 = new JTextField("",10);
        panel.add(entry4);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Calculate");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply4 = new JTextField("", 10);
        reply4 .setEditable(false);
        panel.add(reply4 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService5JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Pedometer Active | Previous Steps")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry5 = new JTextField("",3);
        panel.add(entry5);
        entry55 = new JTextField("",3);
        panel.add(entry55);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Start Step Tracking");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply5 = new JTextArea(20, 10);
        reply5 .setEditable(false);
        panel.add(reply5);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService6JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Heartbeat Sensor Active | Time Used");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry6 = new JTextField("",3);
        panel.add(entry6);
        entry66 = new JTextField("",3);
        panel.add(entry66);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Heartbeat Tracking");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply6 = new JTextArea(20, 10);
        reply6 .setEditable(false);
        panel.add(reply6);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService7JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Turn On light | Battery %");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry7 = new JTextField("",3);
        panel.add(entry7);
        entry77 = new JTextField("",3);
        panel.add(entry77);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Current Light");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply7 = new JTextArea(20, 10);
        reply7 .setEditable(false);
        panel.add(reply7);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService8JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter messages");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry8 = new JTextField("",3);
        panel.add(entry8);
        entry88 = new JTextField("",3);
        panel.add(entry88);
        entry888 = new JTextField("",3);
        panel.add(entry888);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Send to Collar");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply8 = new JTextArea(20, 10);
        reply8 .setEditable(false);
        panel.add(reply8);

        panel.setLayout(boxlayout);

        return panel;

    }

    public static void main(String[] args) {

        ControllerGUI gui = new ControllerGUI();

        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Service Controller Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add( getService1JPanel() );
        panel.add( getService2JPanel() );
        panel.add( getService3JPanel() );
        panel.add( getService4JPanel() );
        panel.add( getService5JPanel() );
        panel.add( getService6JPanel() );
        panel.add( getService7JPanel() );
        panel.add( getService8JPanel() );


        // Set size for the frame
        frame.setSize(1500, 1500);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        String label = button.getActionCommand();

        // is the dog wearing the collar and send back status
        if (label.equals("CollarStatus")) {
            System.out.println(" Is dog wearing collar service to be invoked");

            ServiceInfo serviceInfo;
            String service_type = "_dogtrack._tcp.local.";
            //Now get the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";



            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            // created a service client (Synchronous - Blocking)
            DogTrackingGrpc.DogTrackingBlockingStub dogTracker = DogTrackingGrpc.newBlockingStub(channel);
            boolean wearing;
            int bpm;
            double bodyTemp;
            try {
                String temp = entry11.getText();
                bpm = Integer.parseInt(temp);
                temp = entry111.getText();
                bodyTemp = Double.parseDouble(temp);
                if(entry1.getText().equals("true")){
                    wearing = true;

                    //----------------unary method-----------------------
                    // make the protocol buffer current status message
                    CurrentStatus currentStatus = CurrentStatus.newBuilder()
                            .setWearing(wearing)
                            .setHeartBeatSensorBPM(bpm)
                            .setThermometerBodyTemp(bodyTemp)
                            .build();

                    // Get request message
                    WearingCollarRequest wearingCollarRequest = WearingCollarRequest.newBuilder()
                            .setCurrentStatus(currentStatus)
                            .build();

                    //pass the request message, call the gRPC method
                    WearingCollarResponse wearingCollarResponse = dogTracker.wearingCollar(wearingCollarRequest);
                    reply1.setText( String.valueOf(wearingCollarResponse.getResult()) );
                }else{
                    wearing = false;
                    bpm = 0;
                    bodyTemp = 0.0;
                }
                System.out.println("wearing: " + wearing);
                System.out.println("bpm: " + bpm);
                System.out.println("bodyTemp: " + bodyTemp);
            }catch(IllegalArgumentException i){
                System.out.println("Invalid inputs, please re-enter valid inputs");
            }

            System.out.print("The Channel is shutting down!");
            channel.shutdown();

            //Sets the safe zone and streams the dogs location
        }else if (label.equals("Dog's Location")) {
            System.out.println("Safe Zone Service to be invoked");

            ServiceInfo serviceInfo;
            String service_type = "_dogtrack._tcp.local.";
            //Now get the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";



            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

            // created a service client (Synchronous - Blocking)
            DogTrackingGrpc.DogTrackingBlockingStub dogTracker = DogTrackingGrpc.newBlockingStub(channel);

//          //Parse the input coordinates
            String[] coordinates1 = entry2.getText().split(",", 2);
            String[] coordinates2 = entry22.getText().split(",", 2);
            String[] coordinates3 = entry222.getText().split(",", 2);
            String[] coordinates4 = entry2222.getText().split(",", 2);

            //retrieving reply from service

            new Thread(() -> {
                AtomicInteger call = new AtomicInteger();
                try {
                    SafetyZoneRequest safetyZoneRequest = SafetyZoneRequest.newBuilder()
                            .setSafeZoneCoordinates1(SafeZoneCoordinates.newBuilder().setLatitude(Double.parseDouble(coordinates1[0])))
                            .setSafeZoneCoordinates1(SafeZoneCoordinates.newBuilder().setLongitude(Double.parseDouble(coordinates1[1])))
                            .setSafeZoneCoordinates2(SafeZoneCoordinates.newBuilder().setLatitude(Double.parseDouble(coordinates2[0])))
                            .setSafeZoneCoordinates2(SafeZoneCoordinates.newBuilder().setLongitude(Double.parseDouble(coordinates2[1])))
                            .setSafeZoneCoordinates3(SafeZoneCoordinates.newBuilder().setLatitude(Double.parseDouble(coordinates3[0])))
                            .setSafeZoneCoordinates3(SafeZoneCoordinates.newBuilder().setLongitude(Double.parseDouble(coordinates3[1])))
                            .setSafeZoneCoordinates4(SafeZoneCoordinates.newBuilder().setLatitude(Double.parseDouble(coordinates4[0])))
                            .setSafeZoneCoordinates4(SafeZoneCoordinates.newBuilder().setLongitude(Double.parseDouble(coordinates4[1])))
                            .build();

                    reply2.setText("Updating Dogs Current location");
                    Thread.sleep(1000);

                    dogTracker.outOfBoundsLocation(safetyZoneRequest).forEachRemaining(updateLocationResponse -> {
                        reply2.append("\n");
                        reply2.append(updateLocationResponse.getResult());
                        System.out.println(updateLocationResponse.getResult());
                    });
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (StatusRuntimeException e1) {
                    JOptionPane.showConfirmDialog(null, "Server not reachable");
                } catch (IllegalArgumentException i) {
                    System.out.println("Invalid input for coordinates");
                }

            }).run();

            System.out.print("The Channel is shutting down!");
            channel.shutdown();

            //streams the dogs location and the owners location simultaneously
        }else if (label.equals("Stream location")) {
            System.out.println("Find the dog service");


            ServiceInfo serviceInfo;
            String service_type = "_dogtrack._tcp.local.";
            //Now get the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";

            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            //Asynchronous Stub
            DogTrackingGrpc.DogTrackingStub asyncClient = DogTrackingGrpc.newStub(channel);

            StreamObserver<OwnerLocationRequest> requestObserver = asyncClient.findTheDog(new StreamObserver<DogLocationResponse>() {
                @Override
                public void onNext(DogLocationResponse value) {
                    System.out.println("Response from server: " + value.getDogCoordinates());
                    reply3.append("Response from server: " + value.getDogCoordinates()+"\n");
                    reply3.append("\n");
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


            String[] dogsCoordinates = entry3.getText().split(",", 2);
            String coordinateParsed = dogsCoordinates[0] +"N " + dogsCoordinates[1]+"W";
            System.out.println("coordinate parsed" + coordinateParsed);
            List<String> list = new ArrayList<>();
            for(int i =0; i<6; i++){
                list.add(coordinateParsed);
            }

            for (String coordinates: list) {
                reply3.append("\n");
                reply3.append("The dog's current coordinates: " + coordinates);
                System.out.println("The dog's current coordinates: " + coordinates);
                requestObserver.onNext(OwnerLocationRequest.newBuilder()
                        .setOwnerCoordinates(coordinates)
                        .build());
                try {
                    Thread.sleep(200);
                    System.out.println("Waiting 2 seconds......");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            requestObserver.onCompleted();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            System.out.print("The Channel is shutting down!");
            channel.shutdown();


            //Dogs Body temperature Service
        }else if (label.equals("Calculate")) {
            System.out.println("Dogs Body temperature Service to be invoked ...");

            ServiceInfo serviceInfo;
            String service_type = "_health._tcp.local.";
            //Now get the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";

            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            System.out.println("Making Stub");

            // created a service client (Synchronous - Blocking)
            HealthServiceGrpc.HealthServiceBlockingStub healthService = HealthServiceGrpc.newBlockingStub(channel);

            try {
                String temp = entry4.getText();
                int bodyTemp = Integer.parseInt(temp);

                //Request
                TemperatureRequest temperatureRequest = TemperatureRequest.newBuilder()
                        .setCurrentTempRequest(bodyTemp)
                        .build();

                //Response
                TemperatureResponse temperatureResponse = healthService.checkTemperature(temperatureRequest);
                System.out.println(temperatureResponse.getResult());

                reply4.setText(String.valueOf(temperatureResponse.getResult()));

            }catch(IllegalArgumentException i){
                System.out.println("Invalid input for temperature!");
            }

            System.out.print("The Channel is shutting down!");
            channel.shutdown();


        }else if (label.equals("Start Step Tracking")) {
            System.out.println("Step Tracking Service invoked ...");

            ServiceInfo serviceInfo;
            String service_type = "_health._tcp.local.";
            //Now get the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";

            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            System.out.println("Making Stub");

            // created a service client (Synchronous - Blocking)
            HealthServiceGrpc.HealthServiceBlockingStub healthService = HealthServiceGrpc.newBlockingStub(channel);

            //---------------Server Streaming step counter method ---------------

            new Thread(() -> {
                AtomicInteger call = new AtomicInteger();
                try {
                    String isActive = entry5.getText();
                    int previousCount = Integer.parseInt(entry55.getText());
                    boolean flag = true;
                    if(!isActive.equals("true")){
                        flag = false;
                    }
                    System.out.println("Pedometer: " + flag);
                    PedometerRequest pedometerRequest = PedometerRequest.newBuilder()
                            .setPedometerStatus(PedometerStatus.newBuilder().setIsActive(flag))
                            .setPedometerStatus(PedometerStatus.newBuilder().setPreviousCount(previousCount))
                            .build();
                    System.out.println("We are here!");
                    Thread.sleep(1000);

                    if(!flag){
                            reply5.append("Pedometer can't be reached!");
                    }else {
                        //Stream in a blocking way
                        healthService.stepCounter(pedometerRequest)
                                .forEachRemaining(pedometerResponse -> {
                                    reply5.append("\n");
                                    reply5.append("The avg speed KPH: "  + pedometerResponse.getAvgSpeed());
                                    reply5.append("\n");
                                    reply5.append(pedometerResponse.getResult());
                                    System.out.println(pedometerResponse.getResult());
                                    System.out.println("The avg speed KPH is: "+pedometerResponse.getAvgSpeed());
                                });
                    }


                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }catch(StatusRuntimeException e1){
                    JOptionPane.showConfirmDialog(null, "Server not reachable");
                }catch(IllegalArgumentException i){
                    System.out.println("Invalid input, please correct: boolean | previous steps");
                }
            }).run();


            System.out.print("The Channel is shutting down!");
            channel.shutdown();



        }else if (label.equals("Heartbeat Tracking")) {
            System.out.println("Heartbeat Tracking Service invoked ...");

            ServiceInfo serviceInfo;
            String service_type = "_health._tcp.local.";
            //Now get the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";

            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            System.out.println("Making Stub");

            // created a service client (Synchronous - Blocking)
            HealthServiceGrpc.HealthServiceBlockingStub healthService = HealthServiceGrpc.newBlockingStub(channel);

            //---------------Server Streaming step counter method ---------------

            new Thread(() -> {
                AtomicInteger call = new AtomicInteger();
                try {
                    String temp = entry6.getText();
                    double previousUsageTime = Double.parseDouble(entry66.getText());
                    boolean flag = true;
                    if(!temp.equals("true")){
                        flag = false;
                    }

                    HeartBeatSensorRequest heartBeatSensorRequest = HeartBeatSensorRequest.newBuilder()
                            .setHeartBeatSensorStatus(HeartBeatSensorStatus.newBuilder().setIsActive(flag))
                            .setHeartBeatSensorStatus(HeartBeatSensorStatus.newBuilder().setPreviousUsageTime(previousUsageTime))
                            .build();
                    Thread.sleep(1000);

                    //Stream in a blocking way!
                    healthService.bpmCounter(heartBeatSensorRequest)
                            .forEachRemaining(heartBeatSensorResponse -> {
                                reply6.append("\n");
                                reply6.append(heartBeatSensorResponse.getResult());
                                System.out.println(heartBeatSensorResponse.getResult());
                            });

                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }catch(StatusRuntimeException e1){
                    JOptionPane.showConfirmDialog(null, "Server not reachable");
                }catch(IllegalArgumentException i){
                    System.out.println("Invalid input, please correct: boolean | previous steps");
                }
            }).run();


            System.out.print("The Channel is shutting down!");
            channel.shutdown();

        //Turn the light on for the dog, Stream the lux value of the light outside
        }else if (label.equals("Current Light")) {
            System.out.println("Turn the Light on stream the lux value ...");

            ServiceInfo serviceInfo;
            String service_type = "_collar._tcp.local.";
            //Now get the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";

            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            System.out.println("Making Stub");

            // created a service client (Synchronous - Blocking)
            CollarServiceGrpc.CollarServiceBlockingStub collarService = CollarServiceGrpc.newBlockingStub(channel);


            new Thread(() -> {
                AtomicInteger call = new AtomicInteger();
                try {
                    String temp = entry7.getText();
                    int battery = Integer.parseInt(entry77.getText());
                    boolean flag = true;
                    if(!temp.equals("true")){
                        flag = false;
                    }
                    //---------------Server Streaming led light reader---------------

                    //build request
                    LedLightRequest ledLightRequest = LedLightRequest.newBuilder()
                            .setLedLightStatus(LedLightStatus.newBuilder().setTurnOn(flag))
                            .setLedLightStatus(LedLightStatus.newBuilder().setBattery(battery))
                            .build();

                    Thread.sleep(1000);
                    //Stream in a blocking way!
                    collarService.collarLight(ledLightRequest)
                            .forEachRemaining(ledLightResponse -> {
                                reply7.append("\n");
                                reply7.append(ledLightResponse.getResult());
                                reply7.append("\n");
                                System.out.println(ledLightResponse.getResult());
                            });

                }catch(InterruptedException e1){
                    e1.printStackTrace();
                }catch(StatusRuntimeException e1){
                    JOptionPane.showConfirmDialog(null, "Server not reachable");
                }catch(IllegalArgumentException i){
                    System.out.println("Invalid input, please correct: boolean | battery");
                }
            }).run();

            System.out.print("The Channel is shutting down!");
            channel.shutdown();

        // Send messages to the dog, client streaming
        }else if (label.equals("Send to Collar")) {
            System.out.println("Send messages to the dog ...");

            ServiceInfo serviceInfo;
            String service_type = "_collar._tcp.local.";
            //Now get the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";

            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();


            System.out.println("Making Stub");
            CountDownLatch latch = new CountDownLatch(1);


            CollarServiceGrpc.CollarServiceBlockingStub collarService = CollarServiceGrpc.newBlockingStub(channel);

            // created a service client (Asynchronous)
            CollarServiceGrpc.CollarServiceStub asyncClient = CollarServiceGrpc.newStub(channel);

            //client streaming method streaming the owners voice to the collar
            StreamObserver<StreamVoiceRequest> requestObserver = asyncClient.streamVoice(new StreamObserver<StreamVoiceResponse>() {
                @Override
                public void onNext(StreamVoiceResponse value) {
                    //we get a response from the server
                    System.out.println("Received a response from the server ");
                    System.out.println(value.getResult());
                    reply8.append(value.getResult());
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
            System.out.println("Client Sent Message 1:");
            requestObserver.onNext(StreamVoiceRequest.newBuilder()
                    .setVoiceMessages(VoiceMessages.newBuilder()
                            .setMessage1(entry8.getText())
                            .build())
                    .build());


            // 2nd message
            System.out.println("Client Sent Message 2:");
            requestObserver.onNext(StreamVoiceRequest.newBuilder()
                    .setVoiceMessages(VoiceMessages.newBuilder()
                            .setMessage2(entry88.getText())
                            .build())
                    .build());


            // 3rd message
            System.out.println("Client Sent Message 3:");
            requestObserver.onNext(StreamVoiceRequest.newBuilder()
                    .setVoiceMessages(VoiceMessages.newBuilder()
                            .setMessage3(entry888.getText())
                            .build())
                    .build());


            // after all the messages are sent we tell the server that sending data is finished
            requestObserver.onCompleted();

            //latch is required to give time for server response
            try {
                latch.await(3L, TimeUnit.SECONDS);
            } catch (InterruptedException except) {
                except.printStackTrace();
            }

            System.out.print("The Channel is shutting down!");
            channel.shutdown();

        }




    }
}
