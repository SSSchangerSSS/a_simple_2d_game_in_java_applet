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
public class Heliboy extends Enemy {

public  ArrayList<Enemy_bullet> Enemy_bullets = new ArrayList<>();    
    
public Heliboy(int centerX,int centerY){
    setCenterX(centerX);
    setCenterY(centerY);
}

public void attack(){
Enemy_bullet b = new Enemy_bullet((super.getCenterX() - 45),(super.getCenterY()));
Enemy_bullets.add(b);
}

    /**
     * @return the Enemy_bullets
     */
    public ArrayList<Enemy_bullet> getEnemy_bullets() {
        return Enemy_bullets;
    }
    

    
}

