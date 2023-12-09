package com.example;

public class Traitement extends Thread {
    private String name;
    private long delay;

    public Traitement(String name, long delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("%s: %d", name, i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
