package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.*; // classes para input e output streams e


class UDPClient {
    public static void run() throws Exception {
        FileInputStream inputStream = null;
        try {
            File file = new File("exemplo-pequeno.txt");
            inputStream = new FileInputStream(file);
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("localhost");

            byte[] sentence = inputStream.readAllBytes();
            DatagramPacket sendPacket = new DatagramPacket(sentence, sentence.length, IPAddress, 9876);

            clientSocket.send(sendPacket);
            clientSocket.close();
        } catch(Exception e){}
    }
}
