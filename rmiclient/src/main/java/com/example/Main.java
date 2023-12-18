package com.example;

import java.net.MalformedURLException;
import java.rmi.Naming;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "rmi://localhost:1099/ChatRemote";

            ChatRemote chatRemote = (ChatRemote) Naming.lookup(url);
            System.out.println("Message from server: " + chatRemote.getMessage());
            chatRemote.sendMessage("Goodbye, world!");
            System.out.println("Message from server: " + chatRemote.getMessage());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}