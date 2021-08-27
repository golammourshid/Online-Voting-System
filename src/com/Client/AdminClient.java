package com.Client;

import com.WindowLayOut.Information;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AdminClient {

    Information obj1;
    public AdminClient(Information obj1)
    {
        this.obj1=obj1;
    }

    public int communication()
    {
        System.out.println("welcome client");
        Socket socket = null;
        int inp = 0;
        int what=0;
        try {
            socket = new Socket("localhost", 4444);
            System.out.println("Client connected");
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Ok");
            Information info = obj1;

            os.writeObject(info);
            //String sC = "This is from client";
            //out.println(sC);
            //System.out.println("Message sent");
            //ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            /*inp = in.read();
            int inpt = Integer.parseInt(String.valueOf(inp)) ;
            */

            String output = in.readLine();
            System.out.println("output ki = "+output);
            if (output.contains("yes")) what=2;
            else what = 1;
            System.out.println("Server theke asbe = "+what);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return what;
    }
}
