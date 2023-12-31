package com.straypi.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;

import com.straypi.state.*;

public class UI implements Drawable {
    
    private GamePanel gp;
    private Font maruFont;
    private State[] states;

    public UI(GamePanel gp) {
        this.gp = gp;
        this.states = new State[gp.maxState];
        this.states[GamePanel.titleState] = new TitleState(gp);
        this.states[GamePanel.playState] = new PlayState(gp);
        this.states[GamePanel.pauseState] = new PauseState(gp);
        this.states[GamePanel.endState] = new EndState(gp);

        try {
            this.maruFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("font/MaruMonica.ttf"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        switch (gp.gameState) {
        case GamePanel.titleState: {
            states[GamePanel.titleState].update();
            break;
        }
        case GamePanel.pauseState: {
            states[GamePanel.pauseState].update();
            break;
        }
        case GamePanel.endState: {
            states[GamePanel.endState].update();
            break;
        }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setFont(maruFont.deriveFont(Font.PLAIN, 20F));
        g.setColor(Color.WHITE);

        switch (gp.gameState) {
        case GamePanel.titleState: {
            states[GamePanel.titleState].draw(g);
            break;
        }
        case GamePanel.playState: {
            states[GamePanel.playState].draw(g);
            break;
        }
        case GamePanel.pauseState: {
            states[GamePanel.playState].draw(g);
            states[GamePanel.pauseState].draw(g);
            break;
        }
        case GamePanel.endState: {
            states[GamePanel.playState].draw(g);
            states[GamePanel.endState].draw(g);
            break;
        }
        }
    }

    public void reset() {
        this.states[GamePanel.titleState].reset();
    }
}