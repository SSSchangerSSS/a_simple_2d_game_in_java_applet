/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobotMiniGame;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author fornumber
 */
public class Robot {

    private int JUMPSPEED = -9;
    private int MOVESPEED = 5;
    private double GRAVITY = 0;
    private double GRAVITY_DELTA=0.5;
    private static int GROUND = 368;
    private boolean onBlock = false;
    private boolean isMovingRight = false;
    private boolean isMovingLeft = false;
    private boolean jumped = false;
    private boolean ducked = false;
    private int centerX = 100;
    private int centerY = GROUND;
    private int speedX = 0;
    private int speedY = 1;
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private static Background bg1 = StartingClass.getBg1();
    private static Background bg2 = StartingClass.getBg2();

    //body_stand&&movingRight
    private static Rectangle rect = new Rectangle(0, 0, 0, 0);
    //legs_stand&&movingRight
    private static Rectangle rect2 = new Rectangle(0, 0, 0, 0);
    //hand_stand&&movingRight
    private static Rectangle rect3 = new Rectangle(0, 0, 0, 0);
    //head_stand&&movingRight
    private static Rectangle rect4 = new Rectangle(0, 0, 0, 0);
    //leg_jumped
    private static Rectangle rect5 = new Rectangle(0, 0, 0, 0);
    //legs_movingLeft
    private static Rectangle rect6 = new Rectangle(0, 0, 0, 0);
    //body_movingLeft
    private static Rectangle rect7 = new Rectangle(0, 0, 0, 0);
    //head_movingLeft
    private static Rectangle rect8 = new Rectangle(0, 0, 0, 0);
    //legs_ducked
    private static Rectangle rect9 = new Rectangle(0, 0, 0, 0);
    //hand_ducked
    private static Rectangle rect10 = new Rectangle(0, 0, 0, 0);
    //head_ducked
    private static Rectangle rect11 = new Rectangle(0, 0, 0, 0);
    //Block_usage
    private static Rectangle rect12 = new Rectangle(0, 0, 0, 0);

    public int health = 3;
    private boolean alive = true;

    public void Update() {

//Update X position    
        if (speedX < 0) {
            centerX += speedX;
        }
        if (speedX == 0 || speedX < 0) {
            bg1.setSpeedX(0);
            bg2.setSpeedX(0);
        } else {
            if (centerX + speedX < 320) {
                centerX += speedX;
            } else if (centerX + speedX == 320 && !StartingClass.hb1.die && !StartingClass.hb2.die) {
                centerX = 319;
            } else if (centerX + speedX >= 320 && StartingClass.hb1.die && StartingClass.hb2.die) {
                bg1.setSpeedX(-MOVESPEED);
                bg2.setSpeedX(-MOVESPEED);
            }
        }
        
     
       
        
        
//Update Y position

        if (centerY >= GROUND) {
            centerY = GROUND;
            GRAVITY=0;
        }
        if (centerY < GROUND) {    
            GRAVITY += GRAVITY_DELTA;
            centerY += GRAVITY;
        if(centerY >=GROUND){
        centerY = GROUND;
        GRAVITY=0;
        jumped = false;  
        
        }    
        }
     
        
        
//Update jumped


        if (jumped == true) {
            if(speedY<0){
            centerY += speedY;
            speedY+=1;
            }
            else
            speedY=0;
        }
        if(jumped == true && centerY == GROUND){
        jumped = false;
        }
       
 if(onBlock == true){
       GROUND = 205;     
       }
       if(onBlock == false)
       GROUND = 368;           
       
           
        if (centerX + speedX <= 60) {
            centerX = 61;
        }

        rect.setRect(centerX - 50, centerY - 31, 31, 50);
        rect2.setRect(rect.getX() + 6, rect.getY() + 56, 24, 34);
        rect3.setRect(rect.getX() + 38, centerY - 29, 23, 16);
        rect4.setRect(rect.getX() + 9, rect.getY() - 30, 15, 26);
        rect5.setRect(rect2.getX() + 20, rect2.getY() - 4, 24, 40);
        rect6.setRect(rect2.getX() + 30, rect2.getY() - 4, 24, 36);
        rect7.setRect(rect2.getX() + 16, rect.getY() + 2, 31, 50);
        rect8.setRect(rect4.getX() + 24, rect4.getY(), 15, 26);
        rect9.setRect(rect2.getX() + 31, rect2.getY() + 1, 24, 36);
        rect10.setRect(rect2.getX() + 32, rect2.getY() - 29, 16, 25);
        rect11.setRect(rect2.getX() + 5, rect.getY() + 13, 15, 24);
        rect12.setRect(centerX - 50, centerY + 50, 31, 10);

    }

    public void moveToLeft() {
        if (ducked == false && isIsMovingRight() == false) {
            speedX += -MOVESPEED;
        }
    }

    public void moveToRight() {
        if (ducked == false && isMovingLeft == false) {
            speedX += MOVESPEED;
        }
    }

    public void stopMovingRight() {
        setIsMovingRight(false);
        stop();
    }

    public void stopMovingLeft() {
        setIsMovingLeft(false);
        stop();
    }

    public void stop() {
        if (isMovingRight == false && isMovingLeft == false) {
            speedX = 0;
        }
        if (isMovingRight == false && isMovingLeft == true) {
            moveToLeft();
        }
        if (isMovingRight == true && isMovingLeft == false) {
            moveToRight();
        }
    }

    public void jump() {
        if (jumped == false) {
            speedY += 3*JUMPSPEED + 5;
            jumped = true;
        }
    }

    public void shoot() {
        if (StartingClass.score <= 9) {
            Projectile p = new Projectile(getCenterX() + 103, getCenterY() - 50);
            projectiles.add(p);
        } else {
            Projectile p = new Projectile(getCenterX() + 94, getCenterY() - 26);
            projectiles.add(p);
        }

    }

    /**
     * @return the centerX
     */
    public int getCenterX() {
        return centerX;
    }

    /**
     * @param centerX the centerX to set
     */
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    /**
     * @return the centerY
     */
    public int getCenterY() {
        return centerY;
    }

    /**
     * @param centerY the centerY to set
     */
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    /**
     * @return the jumped
     */
    public boolean isJumped() {
        return jumped;
    }

    /**
     * @param jumped the jumped to set
     */
    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }

    /**
     * @return the speedX
     */
    public int getSpeedX() {
        return speedX;
    }

    /**
     * @param speedX the speedX to set
     */
    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    /**
     * @return the speedY
     */
    public int getSpeedY() {
        return speedY;
    }

    /**
     * @param speedY the speedY to set
     */
    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    /**
     * @return the JUMPSPEED
     */
    public int getJUMPSPEED() {
        return JUMPSPEED;
    }

    /**
     * @param JUMPSPEED the JUMPSPEED to set
     */
    public void setJUMPSPEED(int JUMPSPEED) {
        this.JUMPSPEED = JUMPSPEED;
    }

    /**
     * @return the MOVESPEED
     */
    public int getMOVESPEED() {
        return MOVESPEED;
    }

    /**
     * @param MOVESPEED the MOVESPEED to set
     */
    public void setMOVESPEED(int MOVESPEED) {
        this.MOVESPEED = MOVESPEED;
    }

    /**
     * @return the GROUND
     */
    public int getGROUND() {
        return GROUND;
    }

    /**
     * @param GROUND the GROUND to set
     */
    public void setGROUND(int GROUND) {
        this.GROUND = GROUND;
    }

    /**
     * @return the isMovingRight
     */
    public boolean isIsMovingRight() {
        return isMovingRight;
    }

    /**
     * @param isMovingRight the isMovingRight to set
     */
    public void setIsMovingRight(boolean isMovingRight) {
        this.isMovingRight = isMovingRight;
    }

    /**
     * @return the isMovingLeft
     */
    public boolean isIsMovingLeft() {
        return isMovingLeft;
    }

    /**
     * @param isMovingLeft the isMovingLeft to set
     */
    public void setIsMovingLeft(boolean isMovingLeft) {
        this.isMovingLeft = isMovingLeft;
    }

    /**
     * @return the ducked
     */
    public boolean isDucked() {
        return ducked;
    }

    /**
     * @param ducked the ducked to set
     */
    public void setDucked(boolean ducked) {
        this.ducked = ducked;
    }

    /**
     * @return the bg1
     */
    public static Background getBg1() {
        return bg1;
    }

    /**
     * @param aBg1 the bg1 to set
     */
    public static void setBg1(Background aBg1) {
        bg1 = aBg1;
    }

    /**
     * @return the bg2
     */
    public static Background getBg2() {
        return bg2;
    }

    /**
     * @param aBg2 the bg2 to set
     */
    public static void setBg2(Background aBg2) {
        bg2 = aBg2;
    }

    /**
     * @return the projectiles
     */
    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }

    /**
     * @return the rect
     */
    public static Rectangle getRect() {
        return rect;
    }

    /**
     * @return the rect2
     */
    public static Rectangle getRect2() {
        return rect2;
    }

    /**
     * @return the rect3
     */
    public static Rectangle getRect3() {
        return rect3;
    }

    /**
     * @param aRect3 the rect3 to set
     */
    public static void setRect3(Rectangle aRect3) {
        rect3 = aRect3;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * @return the rect4
     */
    public static Rectangle getRect4() {
        return rect4;
    }

    /**
     * @return the rect5
     */
    public static Rectangle getRect5() {
        return rect5;
    }

    /**
     * @return the rect6
     */
    public static Rectangle getRect6() {
        return rect6;
    }

    /**
     * @return the rect7
     */
    public static Rectangle getRect7() {
        return rect7;
    }

    /**
     * @return the rect8
     */
    public static Rectangle getRect8() {
        return rect8;
    }

    /**
     * @return the rect9
     */
    public static Rectangle getRect9() {
        return rect9;
    }

    /**
     * @return the rect10
     */
    public static Rectangle getRect10() {
        return rect10;
    }

    /**
     * @return the rect11
     */
    public static Rectangle getRect11() {
        return rect11;
    }

    /**
     * @return the rect12
     */
    public static Rectangle getRect12() {
        return rect12;
    }

    /**
     * @param aRect12 the rect12 to set
     */
    public static void setRect12(Rectangle aRect12) {
        rect12 = aRect12;
    }

    /**
     * @return the onBlock
     */
    public boolean isOnBlock() {
        return onBlock;
    }

    /**
     * @param onBlock the onBlock to set
     */
    public void setOnBlock(boolean onBlock) {
        this.onBlock = onBlock;
    }

}
