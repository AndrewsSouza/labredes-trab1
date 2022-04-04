package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void run() throws Exception {
        ServerSocket serverSocket = new ServerSocket(9876);
        Socket socket = serverSocket.accept();

        FileOutputStream fileOutputStream = new FileOutputStream("/home/arthur/Desktop/@pucrs/lab_redes/trabalhos/labredes-trab1/tcp-servidor/receba.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        InputStream inputStream = socket.getInputStream();
        byte[] conteudo = new byte[10000];

        int countBytes = 0;
        boolean terminou = false;
        while ((countBytes = inputStream.read(conteudo)) != -1){
            bufferedOutputStream.write(conteudo, 0, countBytes);
        }
        bufferedOutputStream.flush();
        socket.close();
        serverSocket.close();
        System.out.println("terminou de receber arquivo");
    }
}
