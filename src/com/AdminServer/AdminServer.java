package com.AdminServer;

import com.WindowLayOut.AdminPermission;
import com.WindowLayOut.Information;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AdminServer extends Application {

    public static final int port = 4444;
    static Information info;
    static ObjectInputStream is;
    static ObjectOutputStream os;
    static PrintWriter out;
    static BufferedReader in;
    static  Socket socket;
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int flag = 0;
        ServerSocket ss = new ServerSocket(port);
        System.out.println("System server ready");
        socket = ss.accept();
        System.out.println("System server ready");
        is = new ObjectInputStream(socket.getInputStream());
        os = new ObjectOutputStream(socket.getOutputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        info = (Information) is.readObject();
        System.out.println("Pelam");
        Information obj1 = info;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //int temp =new  MessageWindow().display();
        int what = new AdminPermission(info).permission();
        System.out.println("admin = "+what);
        if (what==1)
        {
            out.println("no");
        }
        else if (what==2)
        {
            out.println("yes");
        }
        socket.close();
    }
}
