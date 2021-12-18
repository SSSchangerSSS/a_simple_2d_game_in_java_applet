/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package RobotMiniGame;

import java.awt.Image;
import java.net.URL;

/**
 *
 * @author fornumber
 */
public class Guns {

    private Image image;
    private int centerX;
    private int centerY;

    public Guns() {

    }

    public void update() {
        if (StartingClass.score <= 9) {
            if (Control.collision_stand() || Control.collision_movingRight() || Control.collision_jumped() || Control.collision_movingRightAndJumped()) {
                centerX = StartingClass.robot.getCenterX() - 60;
                centerY = StartingClass.robot.getCenterY() - 68;
            }
            if (Control.collision_movingLeft() || Control.collision_movingLeftAndJumped()) {
                centerX = StartingClass.robot.getCenterX() - 172;
                centerY = StartingClass.robot.getCenterY() - 68;
            }
            if (Control.collison_ducked()) {
                centerX = StartingClass.robot.getCenterX() - 100;
                centerY = StartingClass.robot.getCenterY() - 68;
            }
        } else {
            if (Control.collision_stand() || Control.collision_movingRight() || Control.collision_jumped() || Control.collision_movingRightAndJumped()) {
                centerX = StartingClass.robot.getCenterX() - 83;
                centerY = StartingClass.robot.getCenterY() - 58;
            }
            if (Control.collision_movingLeft() || Control.collision_movingLeftAndJumped()) {
                centerX = StartingClass.robot.getCenterX() - 105;
                centerY = StartingClass.robot.getCenterY() - 58;
            }
            if (Control.collison_ducked()) {
                centerX = StartingClass.robot.getCenterX() - 25;
                centerY = StartingClass.robot.getCenterY() - 70;
            }
        }
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param aImage the image to set
     */
    public void setImage(Image aImage) {
        image = aImage;
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

}
