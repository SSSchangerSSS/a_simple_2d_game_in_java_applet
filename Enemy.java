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
public class Enemy {

//need to change    
    private int speedX, centerX, hcenterX, centerY, hcenterY, power;
    public int health = 3;
    public boolean die = false;
    private Background bg1 = StartingClass.getBg1();
    private Rectangle rectE = new Rectangle(0, 0, 0, 0);
    private boolean goingUp = true, goingDown = false;
    public boolean generate = false;
    public int milliseconds = 0;

    public void update() {
        if (!die) {
            milliseconds++;
            Ai_0();
            rectE.setBounds(centerX - 25, centerY - 25, 50, 60);
        }
        rectE.setBounds(centerX - 25, centerY - 25, 50, 60);
    }

//need to change
    public void die() {
        hcenterX = centerX;
        centerX = -1000;
        die = true;
    }
//need to change

    public void reborn() {
        centerX = hcenterX;
        die = false;
        health = 3;
        StartingClass.getBg1().setSpeedX(0);
        StartingClass.getBg2().setSpeedX(0);
    }

    private void Ai_0() {
        if (goingUp == true && goingDown == false) {
            centerY -= 4;
        }
        if (centerY == 40) {
            goingUp = false;
            goingDown = true;
        }
        if (goingDown == true && goingUp == false) {
            centerY += 4;
        }
        if (centerY == 360) {
            goingUp = true;
            goingDown = false;
        }
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
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * @return the bg1
     */
    public Background getBg1() {
        return bg1;
    }

    /**
     * @param bg1 the bg1 to set
     */
    public void setBg1(Background bg1) {
        this.bg1 = bg1;
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
     * @return the rectE
     */
    public Rectangle getRectE() {
        return rectE;
    }

    /**
     * @param aRectE the rectE to set
     */
    public void setRectE(Rectangle aRectE) {
        rectE = aRectE;
    }

}
