/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobotMiniGame;

/**
 *
 * @author fornumber
 */
public class Background {

    public Background(int x, int y) {
        bgX = x;
        bgY = y;
        speedX = 0;
    }
    private int bgX, bgY, speedX;
    public int pass = 0;

    public void update() {
        bgX += speedX;
        if (bgX <= -800) {
            pass++;
            bgX += 1600;
        }
    }

    /**
     * @return the bgX
     */
    public int getBgX() {
        return bgX;
    }

    /**
     * @param bgX the bgX to set
     */
    public void setBgX(int bgX) {
        this.bgX = bgX;
    }

    /**
     * @return the bgY
     */
    public int getBgY() {
        return bgY;
    }

    /**
     * @param bgY the bgY to set
     */
    public void setBgY(int bgY) {
        this.bgY = bgY;
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

}
