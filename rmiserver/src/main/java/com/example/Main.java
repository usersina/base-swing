package com.example;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting RMIServer...");
        try {
            LocateRegistry.createRegistry(1099);

            String url = "rmi://localhost:1099/ChatRemote";

            ChatRemoteImpl chatRemoteImpl = new ChatRemoteImpl();
            Naming.rebind(url, chatRemoteImpl);

            System.out.println("RMIServer started! Waiting for requests...");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}