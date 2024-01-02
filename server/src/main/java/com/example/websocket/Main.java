package com.example.websocket;

import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            MyWebSocketServer server = new MyWebSocketServer(8888);
            server.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}