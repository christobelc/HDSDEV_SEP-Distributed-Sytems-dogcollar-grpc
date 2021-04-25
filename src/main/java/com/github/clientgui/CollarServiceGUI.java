package com.github.clientgui;

import com.github.collarservice.grpc.*;
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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CollarServiceGUI implements ActionListener {

    //------------------------
    private JLabel message1Label = new JLabel("Message 1:");
    private JTextField message1Entry = new JTextField("", 10);

    private JLabel message2Label = new JLabel("Message 2:");
    private JTextField message2Entry = new JTextField("", 10);

    private JLabel message3Label = new JLabel("Message 3:");
    private JTextField message3Entry = new JTextField("", 10);

    //    collarStatusBtn
    private JButton messageStreamBtn = new JButton("Send Messages");
    private JTextArea messageStreamTextArea = new JTextArea(10, 30);


    //------------------------

    private JLabel lightIsReadyLabel = new JLabel("Light Ready: true/false");
    private JTextField lightIsreadyEntry = new JTextField("", 10);

    private JLabel batteryLabel = new JLabel("Battery %: ");
    private JTextField batteryEntry = new JTextField("", 10);


    private JTextArea lightTextArea = new JTextArea(10, 30);
    private JButton lightBtn = new JButton("Activate Light");


    // ------------------



// ----------



    private JTabbedPane getUserToolsGUIJTabbedPane() {

        JTabbedPane tabPane = new JTabbedPane();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

// Light Status Zone ----------------------

        JPanel lightPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.anchor = GridBagConstraints.WEST;
        gridBagConstraints1.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 0;
        lightPanel.add(lightIsReadyLabel, gridBagConstraints1);



        gridBagConstraints1.gridx = 1;
        lightPanel.add(lightIsreadyEntry, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 1;
        lightPanel.add(batteryLabel, gridBagConstraints1);

        gridBagConstraints1.gridx = 1;
        lightPanel.add(batteryEntry, gridBagConstraints1);


        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 5;
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.anchor = GridBagConstraints.CENTER;
        lightBtn.addActionListener(this);
        lightPanel.add(lightBtn, gridBagConstraints1);

        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 6;
        lightPanel.add(lightTextArea, gridBagConstraints1);


        // set border for the panel
        lightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "LED Light"));

// Send Messages PANEL -------------------

        JPanel sendMessagesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.anchor = GridBagConstraints.WEST;
        gridBagConstraints2.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 0;
        sendMessagesPanel.add(message1Label, gridBagConstraints2);

        gridBagConstraints2.gridx = 1;
        sendMessagesPanel.add(message1Entry, gridBagConstraints2);

        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 1;
        sendMessagesPanel.add(message2Label, gridBagConstraints2);

        gridBagConstraints2.gridx = 1;
        sendMessagesPanel.add(message2Entry, gridBagConstraints2);

        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 2;
        sendMessagesPanel.add(message3Label, gridBagConstraints2);

        gridBagConstraints2.gridx = 1;
        sendMessagesPanel.add(message3Entry, gridBagConstraints2);


        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 5;
        gridBagConstraints2.gridwidth = 2;
        gridBagConstraints2.anchor = GridBagConstraints.CENTER;
        messageStreamBtn.addActionListener(this);
        sendMessagesPanel.add(messageStreamBtn, gridBagConstraints2);

        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.gridy = 6;
        sendMessagesPanel.add(messageStreamTextArea, gridBagConstraints2);
        // set border for the panel
        sendMessagesPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Send Messages"));


        //set the panes
        tabPane.add("Send Messages", sendMessagesPanel);
        tabPane.add("LED Light", lightPanel);
//        tabPane.add("Find the Dog", streaming);

        return tabPane;
    }

    public static void main(String[] args) {

        CollarServiceGUI gui = new CollarServiceGUI();
        gui.build();
    }

    private void build() {

        JFrame frame = new JFrame("Collar Services GUI");
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
        if (label.equals("Send Messages")) {
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
                    messageStreamTextArea.append(value.getResult());
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
                            .setMessage1(message1Entry.getText())
                            .build())
                    .build());


            // 2nd message
            System.out.println("Client Sent Message 2:");
            requestObserver.onNext(StreamVoiceRequest.newBuilder()
                    .setVoiceMessages(VoiceMessages.newBuilder()
                            .setMessage2(message2Entry.getText())
                            .build())
                    .build());


            // 3rd message
            System.out.println("Client Sent Message 3:");
            requestObserver.onNext(StreamVoiceRequest.newBuilder()
                    .setVoiceMessages(VoiceMessages.newBuilder()
                            .setMessage3(message3Entry.getText())
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

        }else if (label.equals("Activate Light")) {
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
                    String temp = lightIsreadyEntry.getText();
                    int battery = Integer.parseInt(batteryEntry.getText());
                    boolean flag = true;
                    if (!temp.equals("true")) {
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
                                lightTextArea.append(ledLightResponse.getResult()+"\n");
                                System.out.println(ledLightResponse.getResult());
                            });

                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } catch (StatusRuntimeException e1) {
                    JOptionPane.showConfirmDialog(null, "Server not reachable");
                } catch (IllegalArgumentException i) {
                    System.out.println("Invalid input, please correct: boolean | battery");
                }
            }).run();

            System.out.print("The Channel is shutting down!");
            channel.shutdown();
        }
    }
}
