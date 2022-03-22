package com.company;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {
    public static void run() throws Exception{
        //Initialize socket
        Socket socket = new Socket(InetAddress.getByName("10.32.143.130"), 5000);
        byte[] contents = new byte[10000];
        //Initialize the FileOutputStream to the output file's full path.
        FileOutputStream fos = new FileOutputStream("./texto.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = socket.getInputStream();
        //No of bytes read in one read() call
        int bytesRead = 0;
        while((bytesRead=is.read(contents))!=-1)
            bos.write(contents, 0, bytesRead);
        bos.flush();
        socket.close();
        System.out.println("File saved successfully!");
    }

}
