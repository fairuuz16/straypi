package com.straypi.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

// import com.straypi.character.Player;

public class GamePanel extends JPanel implements Runnable{
	public final int originalTileSize = 16;
	public final int scale = 3;
	public final int tileSize = originalTileSize * scale;

	public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;

	public final int screenWidth = maxScreenCol * tileSize;
	public final int screenHeight = maxScreenRow * tileSize;

    public final int maxState = 4;
    public static final int titleState = 0;
    public static final int playState = 1;
    public static final int pauseState = 2;
    public static final int endState = 3;

    public final int FPS = 120;
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 3;

	public Thread gameThread;
	public KeyHandler keyH;
    public MouseHandler mouseH;
    public int gameState;

	public GamePanel() {
        this.keyH = new KeyHandler(this);
        this.mouseH = new MouseHandler(this);
        this.setPreferredSize(new Dimension(screenWidth , screenHeight));
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.addMouseMotionListener(mouseH);
        this.setBackground(new Color(135, 133, 121));
        this.setFocusable(true);
	}


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double delta = 0;
        double drawInterval = 1e9 / FPS;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                this.update();
                this.repaint();
                delta--;
            }
        }
    }

    
    public void update() {
        if (keyH.upPressed) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed) {
            playerY += playerSpeed;
        }
    
        if (keyH.leftPressed) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fill(new Rectangle(playerX, playerY, tileSize, tileSize));
        g2.dispose();
    }
	
}
