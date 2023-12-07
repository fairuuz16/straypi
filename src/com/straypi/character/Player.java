package com.straypi.character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.straypi.ui.GamePanel;
import com.straypi.ui.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDevaultValues();
    }

    public void setDevaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update(){
        if (keyH.upPressed) {
            y -= speed;
        } else if (keyH.downPressed) {
            y += speed;
        }
    
        if (keyH.leftPressed) {
            x -= speed;
        } else if (keyH.rightPressed) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2){ 
        g2.setColor(Color.white);
        g2.fill(new Rectangle(x, y, gp.tileSize, gp.tileSize));
    }
}
