package com.company;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void run() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        Socket socket = new Socket(inetAddress, 9876);

        File file = new File("/home/arthur/Desktop/@pucrs/lab_redes/trabalhos/labredes-trab1/tcp-cliente/exemplo-grande.txt");
        FileInputStream inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        OutputStream outputStream = socket.getOutputStream();
        byte[] conteudo;
        long tamanhoArquivo = file.length();
        long count = 0;
        while (count != tamanhoArquivo) {
            int tamanhoArray = 10000;
            if (tamanhoArquivo - count >= tamanhoArray) {
                count += tamanhoArray;
            } else {
                tamanhoArray = (int) (tamanhoArquivo - count);
                count = tamanhoArquivo;
            }
            conteudo = new byte[tamanhoArray];
            bufferedInputStream.read(conteudo, 0, tamanhoArray);
            outputStream.write(conteudo);
            System.out.println("Enviando arquivo... " + (count * 100) / tamanhoArquivo + "%");
        }
        outputStream.flush();
        socket.close();
        System.out.println("Arquivo enviado com sucesso");
    }

}
