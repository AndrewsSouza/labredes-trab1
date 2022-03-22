package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.*; // classes para input e output streams e


class UDPClient {
    public static void run() throws Exception {
        FileInputStream inputStream = null;
        try {
            File file = new File("file1.txt");
            inputStream = new FileInputStream(file);
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("10.32.143.12");

            byte[] sentence = inputStream.readAllBytes();
            DatagramPacket sendPacket = new DatagramPacket(sentence, sentence.length, IPAddress, 9876);

            clientSocket.send(sendPacket);
            clientSocket.close();
        } catch(Exception e){}
    }
}
