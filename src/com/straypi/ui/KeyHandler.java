package com.straypi.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W: {
                upPressed = true;
            }
            case KeyEvent.VK_S: {
                downPressed = true;
            }
            case KeyEvent.VK_A: {
                leftPressed = true;
            }
            case KeyEvent.VK_D: {
                rightPressed = true;
            }
            case KeyEvent.VK_ESCAPE: {
                if (gp.gameState == GamePanel.playState) gp.gameState = GamePanel.pauseState;
                else if (gp.gameState == GamePanel.pauseState) gp.gameState = GamePanel.playState;
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
      int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_W: {
                upPressed = false;
            }
            case KeyEvent.VK_S: {
                downPressed = false;
            }
            case KeyEvent.VK_A: {
                leftPressed = false;
            }
            case KeyEvent.VK_D: {
                rightPressed = false;
            }
            case KeyEvent.VK_ESCAPE: {
                if (gp.gameState == GamePanel.playState) gp.gameState = GamePanel.pauseState;
                else if (gp.gameState == GamePanel.pauseState) gp.gameState = GamePanel.playState;
                break;
            }
        }
    }
}
