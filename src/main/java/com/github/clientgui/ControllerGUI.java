package com.github.clientgui;

import com.github.collarservice.grpc.*;
import com.github.dogtracking.grpc.*;
import com.github.healthservice.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ControllerGUI implements ActionListener {
    private JTextField entry1, entry11, entry111, reply1;
    private JTextField entry2, reply2;
    private JTextField entry3, reply3;
    private JTextField entry4, reply4;
    private JTextField entry5, reply5;
    private JTextField entry6, reply6;
    private JTextField entry7, reply7;
    private JTextField entry8, reply8;


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

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("",10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 2");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextField("", 10);
        reply2 .setEditable(false);
        panel.add(reply2 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService3JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry3 = new JTextField("",10);
        panel.add(entry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 3");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply3 = new JTextField("", 10);
        reply3 .setEditable(false);
        panel.add(reply3 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService4JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry4 = new JTextField("",10);
        panel.add(entry4);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 4");
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

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry5 = new JTextField("",10);
        panel.add(entry5);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 5");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply5 = new JTextField("", 10);
        reply5 .setEditable(false);
        panel.add(reply5);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService6JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry6 = new JTextField("",10);
        panel.add(entry6);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 6");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply6 = new JTextField("", 10);
        reply6 .setEditable(false);
        panel.add(reply6);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService7JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry7 = new JTextField("",10);
        panel.add(entry7);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 7");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply7 = new JTextField("", 10);
        reply7 .setEditable(false);
        panel.add(reply7);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService8JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry8 = new JTextField("",10);
        panel.add(entry8);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 8");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply8 = new JTextField("", 10);
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

        if (label.equals("CollarStatus")) {
            System.out.println(" Wearing Collar | BPM | Body Temp service to be invoked ...");


            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

            // created a service client (Synchronous - Blocking)
            DogTrackingGrpc.DogTrackingBlockingStub dogTracker = DogTrackingGrpc.newBlockingStub(channel);

            boolean wearing;
            String temp = entry11.getText();
            int bpm = Integer.parseInt(temp);
            temp = entry111.getText();
            double bodyTemp = Double.parseDouble(temp);
            if(entry1.getText().equals("true")){
                wearing = true;
            }else{
                wearing = false;
                bpm = 0;
                bodyTemp = 0.0;
            }
            System.out.println("wearing: " + wearing);
            System.out.println("bpm: " + bpm);
            System.out.println("bodyTemp: " + bodyTemp);


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

            System.out.print("The Channel is shutting down!");
            channel.shutdown();


        }else if (label.equals("Invoke Service 2")) {

            System.out.println("service 2 to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

            // created a service client (Synchronous - Blocking)
            DogTrackingGrpc.DogTrackingBlockingStub dogTracker = DogTrackingGrpc.newBlockingStub(channel);

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


            //preparing message to send
            //ds.service2.RequestMessage request = ds.service2.RequestMessage.newBuilder().setText(entry2.getText()).build();

            //retrieving reply from service
//            reply2.setText(String.valueOf(updateLocationResponse.getResult()));
            dogTracker.outOfBoundsLocation(safetyZoneRequest).forEachRemaining(updateLocationResponse -> {
                System.out.println(updateLocationResponse.getResult());
            });
//            WearingCollarResponse wearingCollarResponse = dogTracker.wearingCollar(wearingCollarRequest);
//            reply1.setText( String.valueOf(wearingCollarResponse.getResult()) );


            System.out.print("The Channel is shutting down!");
            channel.shutdown();


//            ds.service2.ResponseMessage response = blockingStub.service2Do(request);
//
//            reply2.setText( String.valueOf( response.getLength()) );

        }else if (label.equals("Invoke Service 3")) {
            System.out.println("service 3 to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
            //Asynchronous Stub
            DogTrackingGrpc.DogTrackingStub asyncClient = DogTrackingGrpc.newStub(channel);


            StreamObserver<OwnerLocationRequest> requestObserver = asyncClient.findTheDog(new StreamObserver<DogLocationResponse>() {
                @Override
                public void onNext(DogLocationResponse value) {
                    System.out.println("Response from server: " + value.getDogCoordinates());
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

            List<String> list = Arrays.asList("54.000000N 52.000000W", "54.010000N 52.0200000W","54.000000N 52.000000W",
                    "54.000000N 52.000000W", "54.010000N 52.0200000W","54.000000N 52.000000W");

            for (String coordinates: list) {
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

//            //preparing message to send
//            ds.service3.RequestMessage request = ds.service3.RequestMessage.newBuilder().setText(entry3.getText()).build();
//
//            //retreving reply from service
//            ds.service3.ResponseMessage response = blockingStub.service3Do(request);
//
//            reply3.setText( String.valueOf( response.getLength()) );

        }else if (label.equals("Invoke Service 4")) {
            System.out.println("service 4 to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                    .usePlaintext()
                    .build();

            System.out.println("Making Stub");

            // created a service client (Synchronous - Blocking)
            HealthServiceGrpc.HealthServiceBlockingStub healthService = HealthServiceGrpc.newBlockingStub(channel);

                    //Request
                TemperatureRequest temperatureRequest = TemperatureRequest.newBuilder()
                    .setCurrentTempRequest("Temperature request")
                    .build();

            //Response
                TemperatureResponse temperatureResponse = healthService.checkTemperature(temperatureRequest);
                System.out.println(temperatureResponse.getResult());

                reply4.setText( String.valueOf( temperatureResponse.getResult()) );
                System.out.print("The Channel is shutting down!");
                channel.shutdown();


        }else if (label.equals("Invoke Service 5")) {
            System.out.println("service 5 to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                    .usePlaintext()
                    .build();

            System.out.println("Making Stub");

            // created a service client (Synchronous - Blocking)
            HealthServiceGrpc.HealthServiceBlockingStub healthService = HealthServiceGrpc.newBlockingStub(channel);

            //---------------Server Streaming step counter method ---------------

        PedometerRequest pedometerRequest = PedometerRequest.newBuilder()
                .setPedometerStatus(PedometerStatus.newBuilder().setIsActive(true))
                .setPedometerStatus(PedometerStatus.newBuilder().setPreviousCount(3500))
                .build();
        System.out.println("We are here!");

        //Stream in a blocking way
        healthService.stepCounter(pedometerRequest)
                .forEachRemaining(pedometerResponse -> {
                    System.out.println(pedometerResponse.getResult());
                    System.out.println("The avg speed KPH is: "+pedometerResponse.getAvgSpeed());
                });

//            reply5.setText( String.valueOf() );
            System.out.print("The Channel is shutting down!");
            channel.shutdown();



        }else if (label.equals("Invoke Service 6")) {
            System.out.println("service 6 to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                    .usePlaintext()
                    .build();

            System.out.println("Making Stub");

            // created a service client (Synchronous - Blocking)
            HealthServiceGrpc.HealthServiceBlockingStub healthService = HealthServiceGrpc.newBlockingStub(channel);

            //---------------Server Streaming step counter method ---------------

            PedometerRequest pedometerRequest = PedometerRequest.newBuilder()
                    .setPedometerStatus(PedometerStatus.newBuilder().setIsActive(true))
                    .setPedometerStatus(PedometerStatus.newBuilder().setPreviousCount(3500))
                    .build();
            System.out.println("We are here!");

            //Stream in a blocking way
            healthService.stepCounter(pedometerRequest)
                    .forEachRemaining(pedometerResponse -> {
                        System.out.println(pedometerResponse.getResult());
                        System.out.println("The avg speed KPH is: "+pedometerResponse.getAvgSpeed());
                    });

//            reply5.setText( String.valueOf() );
            System.out.print("The Channel is shutting down!");
            channel.shutdown();


        }else if (label.equals("Invoke Service 7")) {
            System.out.println("service 7 to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054)
                    .usePlaintext()
                    .build();


            System.out.println("Making Stub");

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

//            reply5.setText( String.valueOf() );

            System.out.print("The Channel is shutting down!");
            channel.shutdown();

        }else if (label.equals("Invoke Service 8")) {
            System.out.println("service 8 to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054)
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
                            .setMessage1("Come Home Fido")
                            .build())
                    .build());


            // 2nd message
            System.out.println("Client Sent Message 2:");
            requestObserver.onNext(StreamVoiceRequest.newBuilder()
                    .setVoiceMessages(VoiceMessages.newBuilder()
                            .setMessage2("Dinner is ready")
                            .build())
                    .build());


            // 3rd message
            System.out.println("Client Sent Message 3:");
            requestObserver.onNext(StreamVoiceRequest.newBuilder()
                    .setVoiceMessages(VoiceMessages.newBuilder()
                            .setMessage3("Quickly Come Home Fido")
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

//            reply5.setText( String.valueOf() );
        }




    }
}
