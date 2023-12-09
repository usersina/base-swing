package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimatedWindow extends JFrame {
    private JButton btnStart, btnStop;

    private MyPanel panelCenter;

    private Animation animation;
    private boolean isRunning;
    private int x;

    public AnimatedWindow() {
        super("Animated Window");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        JPanel panelNorth = new JPanel();
        panelNorth.add(btnStart);
        panelNorth.add(btnStop);
        this.add(panelNorth, BorderLayout.NORTH);

        this.panelCenter = new MyPanel();
        this.add(this.panelCenter, BorderLayout.CENTER);

        isRunning = false;
        animation = new Animation();
        animation.start();

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = true;
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = false;
            }
        });
    }

    class MyPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.setColor(Color.GREEN);
            g.fillOval(x, 100, 60, 60);
        }
    }

    class Animation extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Running animation thread");
                while (x < 600 && isRunning) {
                    x += 10;
                    panelCenter.repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        }
    }
}
