/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobotMiniGame;

import java.awt.Rectangle;

/**
 *
 * @author fornumber
 */
public class Enemy_bullet {

    //public int targetX,targetY;    
    public int centerX = 0;
    private int centerY = 0;
    public int speed = 0;
    public boolean visible;
    //public int m;
    //public double R,teta;
    private Rectangle r = new Rectangle(0, 0, 0, 0);

    public Enemy_bullet(int X, int Y) {
//targetX = StartingClass.robot.getCenterX();
//targetY = StartingClass.robot.getCenterY();    
        centerX = X;
        centerY = Y;
//R=(Math.abs(centerY - targetY)*Math.abs(centerY - targetY))+(Math.abs(centerX - targetX)*Math.abs(centerX - targetX));
//teta = Math.atan(R);
//m=Math.abs(centerY - targetY)/Math.abs(centerX - targetX);
        visible = true;
        speed = -7;
    }

    public void update() {
        r.setBounds(centerX, centerY, 10, 5);
        centerX += speed;

        if (centerX >= 0) {
            checkCollision();
        } else {
            visible = false;
            r = null;
        }
    }

    private void checkCollision() {
        
        if(StartingClass.block.getR().intersects(r))
            visible = false;
        
        
        if (Control.collision_stand() || Control.collision_movingRight()) {
            if (r.intersects(StartingClass.robot.getRect()) || r.intersects(StartingClass.robot.getRect2()) || r.intersects(StartingClass.robot.getRect3()) || r.intersects(StartingClass.robot.getRect4())) {
                visible = false;
                if (StartingClass.robot.health >= 1) {
                    StartingClass.robot.health--;
                } else {
                    StartingClass.robot.setAlive(false);
                }
            }
        } else if (Control.collision_movingLeft()) {
            if (r.intersects(StartingClass.robot.getRect6()) || r.intersects(StartingClass.robot.getRect7()) || r.intersects(StartingClass.robot.getRect8())) {
                visible = false;
                if (StartingClass.robot.health >= 1) {
                    StartingClass.robot.health--;
                } else {
                    StartingClass.robot.setAlive(false);
                }
            }
        } else if (Control.collision_jumped()) {
            if (r.intersects(StartingClass.robot.getRect()) || r.intersects(StartingClass.robot.getRect3()) || r.intersects(StartingClass.robot.getRect4()) || r.intersects(StartingClass.robot.getRect5())) {

                visible = false;
                if (StartingClass.robot.health >= 1) {
                    StartingClass.robot.health--;
                } else {
                    StartingClass.robot.setAlive(false);
                }
            }
        } else if (Control.collision_movingRightAndJumped()) {
            if (r.intersects(StartingClass.robot.getRect()) || r.intersects(StartingClass.robot.getRect2()) || r.intersects(StartingClass.robot.getRect3()) || r.intersects(StartingClass.robot.getRect4())) {
                visible = false;
                if (StartingClass.robot.health >= 1) {
                    StartingClass.robot.health--;
                } else {
                    StartingClass.robot.setAlive(false);
                }
            }
        } else if (Control.collision_movingLeftAndJumped()) {
            if (r.intersects(StartingClass.robot.getRect6()) || r.intersects(StartingClass.robot.getRect7()) || r.intersects(StartingClass.robot.getRect8())) {
                visible = false;
                if (StartingClass.robot.health >= 1) {
                    StartingClass.robot.health--;
                } else {
                    StartingClass.robot.setAlive(false);
                }
            }
        } else if (Control.collison_ducked()) {
            if (r.intersects(StartingClass.robot.getRect9()) || r.intersects(StartingClass.robot.getRect10()) || r.intersects(StartingClass.robot.getRect11())) {
                visible = false;
                if (StartingClass.robot.health >= 1) {
                    StartingClass.robot.health--;
                } else {
                    StartingClass.robot.setAlive(false);
                }
            }
        }
    }

    /**
     * @return the centerX
     */
    public int getCenterX() {
        return centerX;
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
     * @return the r
     */
    public Rectangle getR() {
        return r;
    }

}
