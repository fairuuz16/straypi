package com.straypi;

import javax.swing.JFrame;

import com.straypi.ui.GamePanel;

public class Main {
        public static void main(String[] args) throws Exception {
        JFrame window  = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("StrayPi");

        GamePanel gp = new GamePanel();
        window.add(gp);
        gp.startThread();

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
