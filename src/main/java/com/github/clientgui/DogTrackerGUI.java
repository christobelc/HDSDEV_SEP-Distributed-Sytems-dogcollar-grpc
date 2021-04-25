package com.github.clientgui;

import com.github.dogtracking.grpc.*;
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
import java.util.concurrent.atomic.AtomicInteger;

public class DogTrackerGUI implements ActionListener {


    //------------------------
    private JLabel isWearingLabel = new JLabel("Wearing Collar");
    private JTextField isWearingEntry = new JTextField("", 10);

    private JLabel bpmLabel = new JLabel("Beats per Minute");
    private JTextField bpmEntry = new JTextField("", 10);

    private JLabel bodyTempLabel = new JLabel("Body Temperature");
    private JTextField bodyTempEntry = new JTextField("", 10);

    //    collarStatusBtn
    private JButton collarReadingBtn = new JButton("Collar Reading");
    private JTextArea collarReadingTextArea = new JTextArea(10, 30);


    private JLabel coordinates1Label = new JLabel("Coordinates 1");
    private JTextField coordinates1Entry = new JTextField("", 10);

    private JLabel coordinates2Label = new JLabel("Coordinates 2");
    private JTextField coordinates2Entry = new JTextField("", 10);


    private JLabel coordinates3Label = new JLabel("Coordinates 3");
    private JTextField coordinates3Entry = new JTextField("", 10);


    private JLabel coordinates4Label = new JLabel("Coordinates 4");
    private JTextField coordinates4Entry = new JTextField("", 10);

    private JTextArea safezoneTextArea = new JTextArea(10, 30);
    private JButton setSafeZoneBtn = new JButton("Select");


    // ------------------

    private JLabel dogsCoordinatesLabel = new JLabel("Dog's Coordinates");
    private JTextField dogsCoordinatesEntry = new JTextField("", 10);

    private JButton bidiStreamBtn = new JButton("Stream location");
    private JTextArea bidiTextArea = new JTextArea(10, 30);


// ----------



    private JTabbedPane getUserToolsGUIJTabbedPane() {

        JTabbedPane tabPane = new JTabbedPane();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

// Safety Zone ----------------------

        JPanel safetyZonePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.anchor = GridBagConstraints.WEST;
        gridBagConstraints1.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 0;
        safetyZonePanel.add(coordinates1Label, gridBagConstraints1);



        gridBagConstraints1.gridx = 1;
        safetyZonePanel.add(coordinates1Entry, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 1;
        safetyZonePanel.add(coordinates2Label, gridBagConstraints1);

        gridBagConstraints1.gridx = 1;
        safetyZonePanel.add(coordinates2Entry, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 2;
        safetyZonePanel.add(coordinates3Label, gridBagConstraints1);

        gridBagConstraints1.gridx = 1;
        safetyZonePanel.add(coordinates3Entry, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 3;
        safetyZonePanel.add(coordinates4Label, gridBagConstraints1);

        gridBagConstraints1.gridx = 1;
        safetyZonePanel.add(coordinates4Entry, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 5;
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.anchor = GridBagConstraints.CENTER;
        setSafeZoneBtn.addActionListener(this);
        safetyZonePanel.add(setSafeZoneBtn, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 6;
        safetyZonePanel.add(safezoneTextArea, gridBagConstraints1);


        // set border for the panel
        safetyZonePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Safety Zone"));

// Dog Wearing Collar PANEL -------------------

        JPanel wearingCollarPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.anchor = GridBagConstraints.WEST;
        gridBagConstraints2.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 0;
        wearingCollarPanel.add(isWearingLabel, gridBagConstraints2);

        gridBagConstraints2.gridx = 1;
        wearingCollarPanel.add(isWearingEntry, gridBagConstraints2);

        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 1;
        wearingCollarPanel.add(bpmLabel, gridBagConstraints2);

        gridBagConstraints2.gridx = 1;
        wearingCollarPanel.add(bpmEntry, gridBagConstraints2);

        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 2;
        wearingCollarPanel.add(bodyTempLabel, gridBagConstraints2);

        gridBagConstraints2.gridx = 1;
        wearingCollarPanel.add(bodyTempEntry, gridBagConstraints2);


        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 5;
        gridBagConstraints2.gridwidth = 2;
        gridBagConstraints2.anchor = GridBagConstraints.CENTER;
        collarReadingBtn.addActionListener(this);
        wearingCollarPanel.add(collarReadingBtn, gridBagConstraints2);

        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 6;
        wearingCollarPanel.add(collarReadingTextArea, gridBagConstraints2);
        // set border for the panel
        wearingCollarPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Wearing Collar"));

// Find the Dog PANEL -------------------

        JPanel streaming = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.anchor = GridBagConstraints.WEST;
        gridBagConstraints3.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 0;
        streaming.add(dogsCoordinatesLabel, gridBagConstraints3);

        gridBagConstraints3.gridx = 1;
        streaming.add(dogsCoordinatesEntry, gridBagConstraints3);

        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 5;
        gridBagConstraints3.gridwidth = 2;
        gridBagConstraints3.anchor = GridBagConstraints.CENTER;
        bidiStreamBtn.addActionListener(this);
        streaming.add(bidiStreamBtn, gridBagConstraints3);

        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 6;
        streaming.add(bidiTextArea, gridBagConstraints3);
        // set border for the panel
        streaming
                .setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Find the Dog"));

        //--------------------------------------------------------

        //set the panes
        tabPane.add("Wearing Collar", wearingCollarPanel);
        tabPane.add("Safety Zone", safetyZonePanel);
        tabPane.add("Find the Dog", streaming);

        return tabPane;
    }

    public static void main(String[] args) {

        DogTrackerGUI gui = new DogTrackerGUI();
        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Dog Tracker Services GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();


        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(25, 50, 25, 50)));

        panel.add(getUserToolsGUIJTabbedPane());


        // Set size for the frame
        frame.setSize(1500, 1500);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

        // is the dog wearing the collar and send back status
        if (label.equals("Collar Reading")) {
            System.out.println(" Is dog wearing collar service to be invoked");

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
            boolean wearing;
            int bpm;
            double bodyTemp;


            try {
                String temp = bpmEntry.getText();
                bpm = Integer.parseInt(temp);
                temp = bodyTempEntry.getText();
                bodyTemp = Double.parseDouble(temp);
                if (isWearingEntry.getText().equals("true")) {
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
//                    reply1.setText( String.valueOf(wearingCollarResponse.getResult()) );
                    collarReadingTextArea.setText(String.valueOf(wearingCollarResponse.getResult()));
                    System.out.println(String.valueOf(wearingCollarResponse.getResult()));
                } else {
                    wearing = false;
                    bpm = 0;
                    bodyTemp = 0.0;
                }
                System.out.println("wearing: " + wearing);
                System.out.println("bpm: " + bpm);
                System.out.println("bodyTemp: " + bodyTemp);
            } catch (IllegalArgumentException i) {
                System.out.println("Invalid inputs, please re-enter valid inputs");
            }

            System.out.print("The Channel is shutting down!");
            channel.shutdown();

            //Sets the safe zone and streams the dogs location
        } else if (label.equals("Select")) {
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

          //Parse the input coordinates
            String[] coordinates1 = coordinates1Entry.getText().split(",", 2);
            String[] coordinates2 = coordinates2Entry.getText().split(",", 2);
            String[] coordinates3 = coordinates3Entry.getText().split(",", 2);
            String[] coordinates4 = coordinates4Entry.getText().split(",", 2);

//            retrieving reply from service

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

                    safezoneTextArea.setText("Updating Dogs Current location");
                    Thread.sleep(1000);

                    //for each response output to the console and textArea
                    dogTracker.outOfBoundsLocation(safetyZoneRequest).forEachRemaining(updateLocationResponse -> {
                        safezoneTextArea.append("\n");
                        safezoneTextArea.append(updateLocationResponse.getResult());
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
        } else if (label.equals("Stream location")) {
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
                    bidiTextArea.append("Response from server: " + value.getDogCoordinates() + "\n");
//                    bidiTextArea.append("\n");
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


            String[] dogsCoordinates = dogsCoordinatesEntry.getText().split(",", 2);
            String coordinateParsed = dogsCoordinates[0] + "N " + dogsCoordinates[1] + "W";
            System.out.println("coordinate parsed" + coordinateParsed);
            String[] list = new String [6];
            for (int i = 0; i < 6; i++) {
                list[i] = coordinateParsed;
            }

            for (String coordinates : list) {
                bidiTextArea.append("\n");
                bidiTextArea.append("The dog's current coordinates: " + coordinates+ "\n");
                System.out.println("The dog's current coordinates: " + coordinates+ "\n");
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
        }
    }
}

