package com.github.gui;

import com.github.dogtracking.grpc.*;
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

public class ControllerGUI implements ActionListener {
    private JTextField entry1, reply1;
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

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("",10);
        panel.add(entry1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 1");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply1 = new JTextField("", 10);
        reply1 .setEditable(false);
        panel.add(reply1 );

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value")	;
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

        JButton button = new JButton("Invoke Service 4");
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

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry6 = new JTextField("",10);
        panel.add(entry6);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 4");
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

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry7 = new JTextField("",10);
        panel.add(entry7);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 4");
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

        JLabel label = new JLabel("Enter value")	;
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry8 = new JTextField("",10);
        panel.add(entry8);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 4");
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

        if (label.equals("Invoke Service 1")) {
            System.out.println("service 1 to be invoked ...");


            /*
             *
             */
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

            // created a service client (Synchronous - Blocking)
            DogTrackingGrpc.DogTrackingBlockingStub dogTracker = DogTrackingGrpc.newBlockingStub(channel);

            //----------------unary method-----------------------
            // make the protocol buffer current status message
            CurrentStatus currentStatus = CurrentStatus.newBuilder()
                    .setWearing(true)
                    .setHeartBeatSensorBPM(40)
                    .setThermometerBodyTemp(36.8)
                    .build();

            // Get request message
            WearingCollarRequest wearingCollarRequest = WearingCollarRequest.newBuilder()
                    .setCurrentStatus(currentStatus)
                    .build();

            //pass the request message, call the gRPC method
            WearingCollarResponse wearingCollarResponse = dogTracker.wearingCollar(wearingCollarRequest);
            reply1.setText( String.valueOf(wearingCollarResponse.getResult()) );

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

//            //preparing message to send
//            ds.service3.RequestMessage request = ds.service3.RequestMessage.newBuilder().setText(entry3.getText()).build();
//
//            //retreving reply from service
//            ds.service3.ResponseMessage response = blockingStub.service3Do(request);
//
//            reply3.setText( String.valueOf( response.getLength()) );

        }


    }
}
