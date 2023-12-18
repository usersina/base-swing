package com.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatRemoteImpl extends UnicastRemoteObject implements ChatRemote {
    protected ChatRemoteImpl() throws RemoteException {
        super();
    }

    private String message = "Hello world!";

    @Override
    public String getMessage() throws RemoteException {
        System.out.println("Client requested message: " + message);
        return message;
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        System.out.println("Client set message to: " + message);
        this.message = message;
    }
}
