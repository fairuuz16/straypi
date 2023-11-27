package com.straypi.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

// import com.straypi.character.Player;

public class GamePanel extends JPanel implements Runnable{
	public final int originalTileSize = 32;
	public final int scale = 4;
	public final int tileSize = originalTileSize * scale;

	public final int maxTileRow = 5;
	public final int maxTileCol = 9;
	public final int screenWidth = maxTileCol * tileSize;
	public final int screenHeight = maxTileRow * tileSize;

    public final int maxState = 4;
    public static final int titleState = 0;
    public static final int playState = 1;
    public static final int pauseState = 2;
    public static final int endState = 3;

    public final int FPS = 120;
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;

	public Thread gameThread;
	public KeyHandler keyH;
    public MouseHandler mouseH;
    public int gameState;

    // public Player player;
    // public Map world;
    // public MiniMap miniMap;
    // public List<Entity> enemies;

	public GamePanel() {
        this.setupGame();
        
        this.keyH = new KeyHandler(this);
        this.mouseH = new MouseHandler(this);
        this.setPreferredSize(new Dimension(screenWidth , screenHeight));
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.addMouseMotionListener(mouseH);
        this.setBackground(new Color(135, 133, 121));
        this.setFocusable(true);
	}

	private void setupGame() {

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
                // this.update();
                this.repaint();
                delta--;
            }
        }
    }

    
    public void update() {
        if(keyH.upPressed == true){
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed == true){
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed == true){
            playerY -= playerSpeed;
        }
        else if (keyH.rightPressed == true){
            playerY += playerSpeed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
	
}
