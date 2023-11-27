// package com.straypi.character;

// import java.awt.image.BufferedImage;
// import java.util.List;

// import com.straypi.ui.GamePanel;

// public class Player extends Entity {
//     public final int defaultMaxLife = 100;

//     public final int screenX;
//     public final int screenY;

//     public boolean isMovingUp;
//     public boolean isMovingDown;
//     public boolean isMovingLeft;
//     public boolean isMovingRight;

//     public BufferedImage bulletImg;
//     public List<Projectile> projectiles;
//     public int projectileCount;
//     private int cdCount = 0;

//     public Player(GamePanel gp){
//         super(gp);
//         this.loadSprite("/assets/player");
//         this.screenX = (gp.screenWidth - gp.tileSize)/2;
//         this.screenY = (gp.screenHeight - gp.tileSize)/2;

//     }

//     private void loadSprite(String string) {
//     }

// }
