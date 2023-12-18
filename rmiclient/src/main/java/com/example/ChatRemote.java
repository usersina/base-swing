package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRemote extends Remote {
    public String getMessage() throws RemoteException;

    public void sendMessage(String message) throws RemoteException;
}
