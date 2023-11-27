package com.straypi.character;

import java.awt.Graphics2D;

import com.straypi.ui.Drawable;

public class Entity implements Drawable {
    protected final int maxFrame = 8;
    protected final int masType = 3;
    protected final int maxDirection = 2;
    protected final int idleState = 0;
    protected final int moveState = 1;
    protected final int attackState = 2;
    public final int faceRight = 0;
    public final int faceLeft = 1;

    
    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public void draw(Graphics2D g) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }
    
}
