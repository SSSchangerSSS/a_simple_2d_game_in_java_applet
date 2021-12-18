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
public class Projectile {
    
private int x,y,speedX;
private boolean visible;    
private Rectangle r = new Rectangle(0,0,0,0);


public Projectile(int startX, int startY){
x=startX;
y=startY;
speedX=8;
visible=true;
}    

public void update(){
 x += speedX;
r.setBounds(x, y, 10, 5);
 if(x>800){
 visible=false;
 r= null;
 }
 if(x<801){
 checkCollision();
 }
}

public void checkCollision(){
    
    if(StartingClass.block.getR().intersects(r))
        visible = false;
    
    if(StartingClass.hb1.getRectE().intersects(r)){
        visible = false;
    if(StartingClass.hb1.health > 0){    
        StartingClass.hb1.health--;    
        StartingClass.score++;
    }
    if(StartingClass.hb1.health == 0)
    StartingClass.hb1.die();
    }
    if(StartingClass.hb2.getRectE().intersects(r)){
        visible = false;
    if(StartingClass.hb2.health > 0){    
        StartingClass.hb2.health--;      
        StartingClass.score++;
    }
    if(StartingClass.hb2.health == 0)
    StartingClass.hb2.die();
    }
}




    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
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
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    


    
}
