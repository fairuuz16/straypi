package com.straypi.state;

import java.awt.Color;
import java.awt.Graphics2D;

import com.straypi.ui.Drawable;
import com.straypi.ui.GamePanel;

public abstract class State implements Drawable {
    protected GamePanel gp;
    protected Color shaderColor;

    public State(GamePanel gp) {
        this.gp = gp;
        this.shaderColor = new Color(0, 0, 0, 0);
    }

    protected void drawShadedText(Graphics2D g, String text, int x, int y, int offsetX, int offsetY) {
        g.setColor(shaderColor);
        g.drawString(text, x+offsetX, y+offsetY);

        g.setColor(Color.WHITE);
        g.drawString(text, x, y);
    }

    protected int getLength(Graphics2D g, String text) {
        return (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
    }

    public void reset() {
        
    }
}
