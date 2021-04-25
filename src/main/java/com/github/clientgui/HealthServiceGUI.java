package com.github.clientgui;

import com.github.healthservice.grpc.*;
import com.github.jmdns.ServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class HealthServiceGUI implements ActionListener {

    //------------------------
    private JLabel stepCounterReadyLabel = new JLabel("Step Counter Active: true/false");
    private JTextField stepCounterReadyEntry = new JTextField("", 10);

    private JLabel previousCountLabel = new JLabel("Previous Steps: ");
    private JTextField previousCountEntry = new JTextField("", 10);

    //    collarStatusBtn
    private JButton startStepCounterBtn = new JButton("Start Step Counter");
    private JTextArea startStepCounterTextArea = new JTextArea(10, 30);


    //------------------------


    private JLabel heartBeatSensorReadyLabel = new JLabel("Heartbeat Sensor Ready: true/false");
    private JTextField heartBeatSensorReadyEntry = new JTextField("", 10);

    private JLabel previousUsageLabel = new JLabel("Previous Usage: hh.mm");
    private JTextField previousUsageEntry = new JTextField("", 10);

    private JTextArea heartBeatSensorTextArea = new JTextArea(10, 30);
    private JButton heartBeatSensorBtn = new JButton("Heartbeat Logger");


    // ------------------

    private JLabel bodyTemperatureLabel = new JLabel("Dog's temperature: ");
    private JTextField bodyTemperatureEntry = new JTextField("", 10);

    private JButton bodyTempBtn = new JButton("Body Temperature");
    private JTextArea bodyTempTextArea = new JTextArea(10, 30);


// ----------



    private JTabbedPane getUserToolsGUIJTabbedPane() {

        JTabbedPane tabPane = new JTabbedPane();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

// Heart Beat tracking PANEL ----------------------

        JPanel heartbeatTrackingPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.anchor = GridBagConstraints.WEST;
        gridBagConstraints1.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 0;
        heartbeatTrackingPanel.add(heartBeatSensorReadyLabel, gridBagConstraints1);



        gridBagConstraints1.gridx = 1;
        heartbeatTrackingPanel.add(heartBeatSensorReadyEntry, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 1;
        heartbeatTrackingPanel.add(previousUsageLabel, gridBagConstraints1);

        gridBagConstraints1.gridx = 1;
        heartbeatTrackingPanel.add(previousUsageEntry, gridBagConstraints1);


        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 5;
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.anchor = GridBagConstraints.CENTER;
        heartBeatSensorBtn.addActionListener(this);
        heartbeatTrackingPanel.add(heartBeatSensorBtn, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 6;
        heartbeatTrackingPanel.add(heartBeatSensorTextArea, gridBagConstraints1);


        // set border for the panel
        heartbeatTrackingPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Heartbeat Tracking"));

// Step Counter PANEL -------------------

        JPanel stepCounterPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.anchor = GridBagConstraints.WEST;
        gridBagConstraints2.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 0;
        stepCounterPanel.add(stepCounterReadyLabel, gridBagConstraints2);

        gridBagConstraints2.gridx = 1;
        stepCounterPanel.add(stepCounterReadyEntry, gridBagConstraints2);

        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 1;
        stepCounterPanel.add(previousCountLabel, gridBagConstraints2);

        gridBagConstraints2.gridx = 1;
        stepCounterPanel.add(previousCountEntry, gridBagConstraints2);



        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 5;
        gridBagConstraints2.gridwidth = 2;
        gridBagConstraints2.anchor = GridBagConstraints.CENTER;
        startStepCounterBtn.addActionListener(this);
        stepCounterPanel.add(startStepCounterBtn, gridBagConstraints2);

        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 6;
        stepCounterPanel.add(startStepCounterTextArea, gridBagConstraints2);
        // set border for the panel
        stepCounterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Step Counter"));

// Body Temperature PANEL -------------------

        JPanel bodyTempPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.anchor = GridBagConstraints.WEST;
        gridBagConstraints3.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 0;
        bodyTempPanel.add(bodyTemperatureLabel, gridBagConstraints3);

        gridBagConstraints3.gridx = 1;
        bodyTempPanel.add(bodyTemperatureEntry, gridBagConstraints3);

        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 5;
        gridBagConstraints3.gridwidth = 2;
        gridBagConstraints3.anchor = GridBagConstraints.CENTER;
        bodyTempBtn.addActionListener(this);
        bodyTempPanel.add(bodyTempBtn, gridBagConstraints3);

        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 6;
        bodyTempPanel.add(bodyTempTextArea, gridBagConstraints3);
        // set border for the panel
        bodyTempPanel
                .setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Body Temperature"));

        //--------------------------------------------------------

        //set the panes
        tabPane.add("Start Step Counter", stepCounterPanel);
        tabPane.add("Heartbeat Tracker", heartbeatTrackingPanel);
        tabPane.add("Body Temperature", bodyTempPanel);

        return tabPane;
    }

    public static void main(String[] args) {

        HealthServiceGUI gui = new HealthServiceGUI();
        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Health Services GUI");
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

        // tracks the steps of the dog
        if (label.equals("Start Step Counter")) {
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
                    String isActive = stepCounterReadyEntry.getText();
                    int previousCount = Integer.parseInt(previousCountEntry.getText());
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
                        startStepCounterTextArea.append("Pedometer can't be reached!");
                    }else {
                        //Stream in a blocking way
                        healthService.stepCounter(pedometerRequest)
                                .forEachRemaining(pedometerResponse -> {
                                    startStepCounterTextArea.append("The avg speed KPH: "  + pedometerResponse.getAvgSpeed()+"\n");
                                    startStepCounterTextArea.append(pedometerResponse.getResult()+ "\n");
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




        } else if (label.equals("Heartbeat Logger")) {
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
                    String temp = heartBeatSensorReadyEntry.getText();
                    double previousUsageTime = Double.parseDouble(previousUsageEntry.getText());
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
//                                heartBeatSensorTextArea.append("\n");
                                heartBeatSensorTextArea.append(heartBeatSensorResponse.getResult()+"\n");
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


        } else if (label.equals("Body Temperature")) {
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
                String temp = bodyTemperatureEntry.getText();
                int bodyTemp = Integer.parseInt(temp);

                //Request
                TemperatureRequest temperatureRequest = TemperatureRequest.newBuilder()
                        .setCurrentTempRequest(bodyTemp)
                        .build();

                //Response
                TemperatureResponse temperatureResponse = healthService.checkTemperature(temperatureRequest);
                System.out.println(temperatureResponse.getResult());

                bodyTempTextArea.setText(String.valueOf(temperatureResponse.getResult()));


            }catch(IllegalArgumentException i){
                System.out.println("Invalid input for temperature!");
            }

            System.out.print("The Channel is shutting down!");
            channel.shutdown();


        }
    }
}
