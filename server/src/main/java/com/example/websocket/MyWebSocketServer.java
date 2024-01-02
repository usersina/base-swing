package com.example.websocket;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyWebSocketServer extends WebSocketServer {
    private static final Logger logger = LoggerFactory.getLogger(MyWebSocketServer.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public MyWebSocketServer(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        logger.info("New connection from " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        logger.info("Closed connection to " + conn.getRemoteSocketAddress() + " with exit code " + code);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        try {
            logger.info(
                    String.format("Received message from %s: %d bytes", conn.getRemoteSocketAddress(), message.length()) //
            );
            logger.info("Broadcasting message to all connections");
            broadcast(message);
        } catch (Exception e) {
            logger.error("Error parsing message: " + e.getMessage());
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        logger.error("An error occurred on connection " + conn.getRemoteSocketAddress() + ":" + ex);
    }

    @Override
    public void onStart() {
        logger.info("Server started successfully");
    }

    public void sendMessage(WebSocket conn, Message message) {
        try {
            String msg = objectMapper.writeValueAsString(message);
            conn.send(msg);
        } catch (Exception e) {
            logger.error("Error sending message: " + e.getMessage());
        }
    }
}
