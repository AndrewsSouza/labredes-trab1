package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Stream;

public class UDPServer {
    public static void run() throws Exception {
        // cria socket do servidor com a porta 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];
        while (true) {
            // declara o pacote a ser recebido
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // recebe o pacote do cliente
            serverSocket.receive(receivePacket);

            // pega os dados, o endere�o IP e a porta do cliente
            // para poder mandar a msg de volta
            String sentence = new String(receivePacket.getData(), StandardCharsets.UTF_8);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            File outputFile = new File("outputFile.txt");
            try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                outputStream.write(receiveData);
            }
        }
    }
}

