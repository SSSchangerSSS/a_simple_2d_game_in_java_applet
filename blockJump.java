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

//need to be check
public class blockJump {
    
private int startX,startY,hstartX;    
private boolean onBlock = false;
private Rectangle r = new Rectangle(0,0,0,0); 
 blockJump(int x){
 startX=x;
 startY=260;
 }    

 
public void update1(){
if(!(StartingClass.hb1.die && StartingClass.hb2.die)){
r.setBounds(startX,startY,100,30); 
checkCollision();
}
if(StartingClass.hb1.die && StartingClass.hb2.die){
r.setBounds(0,0,0,0);    
StartingClass.robot.setGROUND(368);
StartingClass.robot.setOnBlock(false);
}
}

private void checkCollision(){  
if(r.intersects(StartingClass.robot.getRect12())){
StartingClass.robot.setOnBlock(true);
}  
if(!r.intersects(StartingClass.robot.getRect12())){
StartingClass.robot.setOnBlock(false);
}  
}
    /**
     * @return the startX
     */
    public int getStartX() {
        return startX;
    }

    /**
     * @param startX the startX to set
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * @return the startY
     */
    public int getStartY() {
        return startY;
    }

    /**
     * @param startY the startY to set
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * @return the r
     */
    public Rectangle getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Rectangle r) {
        this.r = r;
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

    /**
     * @return the hstartX
     */
    public int getHstartX() {
        return hstartX;
    }

    /**
     * @param hstartX the hstartX to set
     */
    public void setHstartX(int hstartX) {
        this.hstartX = hstartX;
    }



}





