/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RobotMiniGame;

import RobotMiniGame.framework.animations;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author fornumber
 */
public class  StartingClass extends Applet implements Runnable, KeyListener {

 
    
    
    
    
    
    public static Robot robot;
    public static Heliboy hb1, hb2;
    private Guns gun;
    private Graphics second;
    private Image image, ShotFire,currentSpirit, characterDown, characterDownb, characterDownbb, characterJumped, characterJumpedb, characterJumpedbb, lightGun, lightGunMovingLeft, lightGunDucked, heavyGun, heavyGunMovingLeft, heavyGunDucked, background, background1, jumper, Character, characterb, characterbb, Character1, character1b, character1bb, Character2, character2b, character2bb, Character3, character3b, character3bb, Character4, character4b, character4bb, Character5, character5b, character5bb, heliboy, heliboy2, heliboy3, heliboy4, heliboy5, move1, move2, move3, move4, move5, move6, move7, move8, move9, move10, move11, move12, move1b, move2b, move3b, move4b, move5b, move6b, move7b, move8b, move9b, move10b, move11b, move12b, move1bb, move2bb, move3bb, move4bb, move5bb, move6bb, move7bb, move8bb, move9bb, move10bb, move11bb, move12bb, move2_1, move2_2, move2_3, move2_4, move2_5, move2_6, move2_7, move2_8, move2_9, move2_10, move2_11, move2_12, move2_1b, move2_2b, move2_3b, move2_4b, move2_5b, move2_6b, move2_7b, move2_8b, move2_9b, move2_10b, move2_11b, move2_12b, move2_1bb, move2_2bb, move2_3bb, move2_4bb, move2_5bb, move2_6bb, move2_7bb, move2_8bb, move2_9bb, move2_10bb, move2_11bb, move2_12bb, bullet, bullet_E;
    private URL base;
    private static Background bg1, bg2;
    private animations anim, animb, animbb, hanim, characterMove, characterMoveb, characterMovebb, characterMove2, characterMove2b, characterMove2bb;
    private int milliseconds = 31;
    private static int delta = 0;
    public static int milliseconds_for_shotFire = 0;
    public static boolean shotFire = false;
    private Font font = new Font(null, Font.BOLD, 30);
    private Font shootLine = new Font(null, Font.ITALIC, 20);
    public static int score = 0;

    public static blockJump block;

    
    
    @Override
    public void init() {
        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("my first game");

        try {
            base = getCodeBase();
        } catch (Exception e) {

        }

        
        ShotFire = getImage(base , "data/shotFire.png");
        
        heavyGun = getImage(base, "data/heavyGun.png");
        heavyGunMovingLeft = getImage(base, "data/heavyGunMovingLeft.png");
        heavyGunDucked = getImage(base, "data/heavyGunDucked.png");

        lightGun = getImage(base, "data/lightGun.png");
        lightGunMovingLeft = getImage(base, "data/lightGunMovingLeft.png");
        lightGunDucked = getImage(base, "data/lightGunDucked.png");

        background = getImage(base, "data/Background.png");
        background1 = getImage(base, "data/Background.png");

        jumper = getImage(base , "data/jumper.png");
        
        bullet = getImage(base, "data/bullet.png");
        bullet_E = getImage(base, "data/bullet_E.png");

        characterJumped = getImage(base, "data/Jump_1.png");
        characterDown = getImage(base, "data/Character_Down_1.png");
        characterJumpedb = getImage(base, "data/Jump_1b.png");
        characterDownb = getImage(base, "data/Character_Down_1b.png");
        characterJumpedbb = getImage(base, "data/Jump_1bb.png");
        characterDownbb = getImage(base, "data/Character_Down_1bb.png");

        Character = getImage(base, "data/Character_1_1.png");
        Character1 = getImage(base, "data/Character_2.png");
        Character2 = getImage(base, "data/Character_2_1.png");
        Character3 = getImage(base, "data/Character_3 - .png");
        Character4 = getImage(base, "data/Character_4.png");
        Character5 = getImage(base, "data/Charcter_5.png");

        characterb = getImage(base, "data/Character_1_1b.png");
        character1b = getImage(base, "data/Character_2b.png");
        character2b = getImage(base, "data/Character_2_1b.png");
        character3b = getImage(base, "data/Character_3 - b.png");
        character4b = getImage(base, "data/Character_4b.png");
        character5b = getImage(base, "data/Charcter_5b.png");

        characterbb = getImage(base, "data/Character_1_1bb.png");
        character1bb = getImage(base, "data/Character_2bb.png");
        character2bb = getImage(base, "data/Character_2_1bb.png");
        character3bb = getImage(base, "data/Character_3 - bb.png");
        character4bb = getImage(base, "data/Character_4bb.png");
        character5bb = getImage(base, "data/Charcter_5bb.png");

        move1 = getImage(base, "data/0.png");
        move2 = getImage(base, "data/1.1.png");
        move3 = getImage(base, "data/1.png");
        move4 = getImage(base, "data/2.png");
        move5 = getImage(base, "data/3.png");
        move6 = getImage(base, "data/4.0.png");
        move7 = getImage(base, "data/4.1.png");
        move8 = getImage(base, "data/5.png");
        move9 = getImage(base, "data/6.png");
        move10 = getImage(base, "data/7.png");
        move11 = getImage(base, "data/8.png");
        move12 = getImage(base, "data/9.png");

        move1b = getImage(base, "data/0b.png");
        move2b = getImage(base, "data/1.1b.png");
        move3b = getImage(base, "data/1b.png");
        move4b = getImage(base, "data/2b.png");
        move5b = getImage(base, "data/3b.png");
        move6b = getImage(base, "data/4.0b.png");
        move7b = getImage(base, "data/4.1b.png");
        move8b = getImage(base, "data/5b.png");
        move9b = getImage(base, "data/6b.png");
        move10b = getImage(base, "data/7b.png");
        move11b = getImage(base, "data/8b.png");
        move12b = getImage(base, "data/9b.png");

        move1bb = getImage(base, "data/0bb.png");
        move2bb = getImage(base, "data/1.1bb.png");
        move3bb = getImage(base, "data/1bb.png");
        move4bb = getImage(base, "data/2bb.png");
        move5bb = getImage(base, "data/3bb.png");
        move6bb = getImage(base, "data/4.0bb.png");
        move7bb = getImage(base, "data/4.1bb.png");
        move8bb = getImage(base, "data/5bb.png");
        move9bb = getImage(base, "data/6bb.png");
        move10bb = getImage(base, "data/7bb.png");
        move11bb = getImage(base, "data/8bb.png");
        move12bb = getImage(base, "data/9bb.png");

        move2_1 = getImage(base, "data/L0.png");
        move2_2 = getImage(base, "data/L1.1.png");
        move2_3 = getImage(base, "data/L1.png");
        move2_4 = getImage(base, "data/L2.png");
        move2_5 = getImage(base, "data/L3.png");
        move2_6 = getImage(base, "data/L4.png");
        move2_7 = getImage(base, "data/L5.png");
        move2_8 = getImage(base, "data/L6.png");
        move2_9 = getImage(base, "data/L7.png");
        move2_10 = getImage(base, "data/L8.png");
        move2_11 = getImage(base, "data/L9.png");
        move2_12 = getImage(base, "data/L10.png");

        move2_1b = getImage(base, "data/L0b.png");
        move2_2b = getImage(base, "data/L1.1b.png");
        move2_3b = getImage(base, "data/L1b.png");
        move2_4b = getImage(base, "data/L2b.png");
        move2_5b = getImage(base, "data/L3b.png");
        move2_6b = getImage(base, "data/L4b.png");
        move2_7b = getImage(base, "data/L5b.png");
        move2_8b = getImage(base, "data/L6b.png");
        move2_9b = getImage(base, "data/L7b.png");
        move2_10b = getImage(base, "data/L8b.png");
        move2_11b = getImage(base, "data/L9b.png");
        move2_12b = getImage(base, "data/L10b.png");

        move2_1bb = getImage(base, "data/L0bb.png");
        move2_2bb = getImage(base, "data/L1.1bb.png");
        move2_3bb = getImage(base, "data/L1bb.png");
        move2_4bb = getImage(base, "data/L2bb.png");
        move2_5bb = getImage(base, "data/L3bb.png");
        move2_6bb = getImage(base, "data/L4bb.png");
        move2_7bb = getImage(base, "data/L5bb.png");
        move2_8bb = getImage(base, "data/L6bb.png");
        move2_9bb = getImage(base, "data/L7bb.png");
        move2_10bb = getImage(base, "data/L8bb.png");
        move2_11bb = getImage(base, "data/L9bb.png");
        move2_12bb = getImage(base, "data/L10bb.png");

        heliboy = getImage(base, "data/heliboy.png");
        heliboy2 = getImage(base, "data/heliboy2.png");
        heliboy3 = getImage(base, "data/heliboy3.png");
        heliboy4 = getImage(base, "data/heliboy4.png");
        heliboy5 = getImage(base, "data/heliboy5.png");

        anim = new animations();
        anim.addFrame(Character1, 1250);
        anim.addFrame(Character, 300);
        anim.addFrame(Character2, 300);
        anim.addFrame(Character3, 300);
        anim.addFrame(Character4, 300);
        anim.addFrame(Character5, 300);
        anim.addFrame(Character5, 300);
        anim.addFrame(Character1, 300);

        animb = new animations();
        animb.addFrame(character1b, 1250);
        animb.addFrame(characterb, 300);
        animb.addFrame(character2b, 300);
        animb.addFrame(character3b, 300);
        animb.addFrame(character4b, 300);
        animb.addFrame(character5b, 300);
        animb.addFrame(character5b, 300);
        animb.addFrame(character1b, 300);

        animbb = new animations();
        animbb.addFrame(character1bb, 1250);
        animbb.addFrame(characterbb, 300);
        animbb.addFrame(character2bb, 300);
        animbb.addFrame(character3bb, 300);
        animbb.addFrame(character4bb, 300);
        animbb.addFrame(character5bb, 300);
        animbb.addFrame(character5bb, 300);
        animbb.addFrame(character1bb, 300);

        characterMove = new animations();
        characterMove.addFrame(move1, 135);
        characterMove.addFrame(move2, 135);
        characterMove.addFrame(move3, 135);
        characterMove.addFrame(move4, 135);
        characterMove.addFrame(move5, 135);
        characterMove.addFrame(move6, 135);
        characterMove.addFrame(move7, 135);
        characterMove.addFrame(move8, 135);
        characterMove.addFrame(move9, 135);
        characterMove.addFrame(move10, 135);
        characterMove.addFrame(move11, 135);
        characterMove.addFrame(move12, 135);

        characterMoveb = new animations();
        characterMoveb.addFrame(move1b, 135);
        characterMoveb.addFrame(move2b, 135);
        characterMoveb.addFrame(move3b, 135);
        characterMoveb.addFrame(move4b, 135);
        characterMoveb.addFrame(move5b, 135);
        characterMoveb.addFrame(move6b, 135);
        characterMoveb.addFrame(move7b, 135);
        characterMoveb.addFrame(move8b, 135);
        characterMoveb.addFrame(move9b, 135);
        characterMoveb.addFrame(move10b, 135);
        characterMoveb.addFrame(move11b, 135);
        characterMoveb.addFrame(move12b, 135);

        characterMovebb = new animations();
        characterMovebb.addFrame(move1bb, 135);
        characterMovebb.addFrame(move2bb, 135);
        characterMovebb.addFrame(move3bb, 135);
        characterMovebb.addFrame(move4bb, 135);
        characterMovebb.addFrame(move5bb, 135);
        characterMovebb.addFrame(move6bb, 135);
        characterMovebb.addFrame(move7bb, 135);
        characterMovebb.addFrame(move8bb, 135);
        characterMovebb.addFrame(move9bb, 135);
        characterMovebb.addFrame(move10bb, 135);
        characterMovebb.addFrame(move11bb, 135);
        characterMovebb.addFrame(move12bb, 135);

        characterMove2 = new animations();
        characterMove2.addFrame(move2_1, 135);
        characterMove2.addFrame(move2_2, 135);
        characterMove2.addFrame(move2_3, 135);
        characterMove2.addFrame(move2_4, 135);
        characterMove2.addFrame(move2_5, 135);
        characterMove2.addFrame(move2_6, 135);
        characterMove2.addFrame(move2_7, 135);
        characterMove2.addFrame(move2_8, 135);
        characterMove2.addFrame(move2_9, 135);
        characterMove2.addFrame(move2_10, 135);
        characterMove2.addFrame(move2_11, 135);
        characterMove2.addFrame(move2_12, 135);

        characterMove2b = new animations();
        characterMove2b.addFrame(move2_1b, 135);
        characterMove2b.addFrame(move2_2b, 135);
        characterMove2b.addFrame(move2_3b, 135);
        characterMove2b.addFrame(move2_4b, 135);
        characterMove2b.addFrame(move2_5b, 135);
        characterMove2b.addFrame(move2_6b, 135);
        characterMove2b.addFrame(move2_7b, 135);
        characterMove2b.addFrame(move2_8b, 135);
        characterMove2b.addFrame(move2_9b, 135);
        characterMove2b.addFrame(move2_10b, 135);
        characterMove2b.addFrame(move2_11b, 135);
        characterMove2b.addFrame(move2_12b, 135);

        characterMove2bb = new animations();
        characterMove2bb.addFrame(move2_1bb, 135);
        characterMove2bb.addFrame(move2_2bb, 135);
        characterMove2bb.addFrame(move2_3bb, 135);
        characterMove2bb.addFrame(move2_4bb, 135);
        characterMove2bb.addFrame(move2_5bb, 135);
        characterMove2bb.addFrame(move2_6bb, 135);
        characterMove2bb.addFrame(move2_7bb, 135);
        characterMove2bb.addFrame(move2_8bb, 135);
        characterMove2bb.addFrame(move2_9bb, 135);
        characterMove2bb.addFrame(move2_10bb, 135);
        characterMove2bb.addFrame(move2_11bb, 135);
        characterMove2bb.addFrame(move2_12bb, 135);

        hanim = new animations();
        hanim.addFrame(heliboy, 100);
        hanim.addFrame(heliboy2, 100);
        hanim.addFrame(heliboy3, 100);
        hanim.addFrame(heliboy4, 100);
        hanim.addFrame(heliboy5, 100);
        hanim.addFrame(heliboy4, 100);
        hanim.addFrame(heliboy3, 100);
        hanim.addFrame(heliboy3, 100);
        hanim.addFrame(heliboy2, 100);

        currentSpirit = anim.getImage();
    }

    @Override
    public void start() {
       
            bg1 = new Background(0, 0);
            bg2 = new Background(800, 0);
            hb1 = new Heliboy(480, 360);
            hb2 = new Heliboy(650, 120);
            robot = new Robot();
            block = new blockJump(60);
            gun = new Guns();
            gun.setImage(lightGun);
            hb1.milliseconds = 0;
            hb2.milliseconds = 30;
            Thread thread = new Thread(this);
            thread.start();
           // Thread t = new Thread(new music("Epic Sport Rock .mp3"));
           // t.start();
    }

    @Override
    public void stop() {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        if (robot.isAlive() && robot.health != 0) {
            while (true) {

                robot.Update();
                gun.update();
                updateGunsImages();
                block.update1();
                if (robot.isJumped() == true) {
                    if (robot.health == 3) {
                        currentSpirit = characterJumped;
                    }
                    if (robot.health == 2) {
                        currentSpirit = characterJumpedbb;
                    }
                    if (robot.health == 1) {
                        currentSpirit = characterJumpedb;
                    }
                } else if (robot.isJumped() == false && robot.isDucked() == false) {
                    if (robot.health == 3) {
                        currentSpirit = anim.getImage();
                    }
                    if (robot.health == 2) {
                        currentSpirit = animbb.getImage();
                    }
                    if (robot.health == 1) {
                        currentSpirit = animb.getImage();
                    }

                }

                ArrayList<Projectile> projectiles = robot.getProjectiles();
                for (int i = 0; i < projectiles.size(); i++) {
                    Projectile p = (Projectile) projectiles.get(i);
                    if (p.isVisible()) {
                        p.update();
                    } else {
                        projectiles.remove(p);
                    }
                }
                hb1.update();
                hb2.update();
                bg1.update();
                bg2.update();

                hanim.update(50);
                if (robot.isIsMovingRight()) {
                    characterMove.update(50);
                    characterMovebb.update(50);
                    characterMoveb.update(50);
                } else if (robot.isIsMovingLeft()) {
                    characterMove2.update(50);
                    characterMove2bb.update(50);
                    characterMove2b.update(50);
                } else {
                    anim.update(50);
                    animb.update(50);
                    animbb.update(50);
                }
                if (hb1.milliseconds > 50 && !hb1.die) {
                    hb1.attack();
                    hb1.milliseconds = 0;
                }
                ArrayList<Enemy_bullet> Enemy_bullets = hb1.getEnemy_bullets();
                for (int i = 0; i < Enemy_bullets.size(); i++) {
                    Enemy_bullet b = (Enemy_bullet) Enemy_bullets.get(i);
                    if (b.visible == true) {
                        b.update();
                    } else {
                        Enemy_bullets.remove(i);
                    }
                }

                if (hb2.milliseconds > 65 && !hb2.die) {
                    hb2.attack();
                    hb2.milliseconds = 0;
                }
                ArrayList<Enemy_bullet> Enemy_bullets2 = hb2.getEnemy_bullets();
                for (int i = 0; i < Enemy_bullets2.size(); i++) {
                    Enemy_bullet b = (Enemy_bullet) Enemy_bullets2.get(i);
                    if (b.visible == true) {
                        b.update();
                    } else {
                        Enemy_bullets2.remove(i);
                    }
                }

                if (Control.genrate()) {
                    hb1.reborn();
                    hb2.reborn();
                    bg1.pass = 0;
                    bg2.pass = 0;
                }

                milliseconds++;
                delta++;
                
                if(score <= 9){
                if(milliseconds_for_shotFire > 20){
                shotFire = false;        
                milliseconds_for_shotFire = 0;
                }
                }
                else 
                {
                 if(milliseconds_for_shotFire > 15){   
                 shotFire = false;   
                 milliseconds_for_shotFire = 0;   
                 }
                }
                
                
                
                if(shotFire)
                milliseconds_for_shotFire++;
                
                repaint();

                try {
                    Thread.sleep(17);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Override
    public void paint(Graphics g) {
        if (robot.isAlive() && robot.health != 0) {
            g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
            g.drawImage(background1, bg2.getBgX(), bg2.getBgY(), this);

            ArrayList<Projectile> projectiles = robot.getProjectiles();
            for (int i = 0; i < projectiles.size(); i++) {
                Projectile p = (Projectile) projectiles.get(i);
                if (p.isVisible()) {
                    g.drawImage(bullet, p.getX(), p.getY(), this);
                }

            }

            ArrayList<Enemy_bullet> Enemy_bullets = hb1.getEnemy_bullets();
            for (int i = 0; i < Enemy_bullets.size(); i++) {
                Enemy_bullet b = (Enemy_bullet) Enemy_bullets.get(i);
                if (b.visible == true) {
                    g.drawImage(bullet_E, b.getCenterX(), b.getCenterY(), this);
                    //g.setColor(Color.ORANGE);
                    //g.fillRect((int) b.getR().x, (int) b.getR().y, (int) b.getR().width, (int) b.getR().height);
                }
            }
            ArrayList<Enemy_bullet> Enemy_bullets2 = hb2.getEnemy_bullets();
            for (int i = 0; i < Enemy_bullets2.size(); i++) {
                Enemy_bullet b = (Enemy_bullet) Enemy_bullets2.get(i);
                if (b.visible == true) {
                    g.drawImage(bullet_E, b.getCenterX(), b.getCenterY(), this);
                    //g.setColor(Color.ORANGE);
                    //g.fillRect((int) b.getR().x, (int) b.getR().y, (int) b.getR().width, (int) b.getR().height);
                }
            }

            g.drawImage(hanim.getImage(), hb1.getCenterX() - 48, hb1.getCenterY() - 48, this);
            g.drawImage(hanim.getImage(), hb2.getCenterX() - 48, hb2.getCenterY() - 48, this);

            if (robot.isIsMovingRight() && !robot.isDucked()) {
                if (robot.health == 3) {
                    g.drawImage(characterMove.getImage(), robot.getCenterX() - 61, robot.getCenterY() - 63, this);
                }
                if (robot.health == 2) {
                    g.drawImage(characterMovebb.getImage(), robot.getCenterX() - 61, robot.getCenterY() - 63, this);
                }
                if (robot.health == 1) {
                    g.drawImage(characterMoveb.getImage(), robot.getCenterX() - 61, robot.getCenterY() - 63, this);
                }

            } else if (robot.isIsMovingLeft() & !robot.isDucked()) {
                if (robot.health == 3) {
                    g.drawImage(characterMove2.getImage(), robot.getCenterX() - 61, robot.getCenterY() - 63, this);
                }
                if (robot.health == 2) {
                    g.drawImage(characterMove2bb.getImage(), robot.getCenterX() - 61, robot.getCenterY() - 63, this);
                }
                if (robot.health == 1) {
                    g.drawImage(characterMove2b.getImage(), robot.getCenterX() - 61, robot.getCenterY() - 63, this);
                }

            } else {
                g.drawImage(currentSpirit, robot.getCenterX() - 61, robot.getCenterY() - 63, this);
            }
            g.drawImage(gun.getImage(), gun.getCenterX(), gun.getCenterY(), this);

            g.setFont(font);
            g.setColor(Color.BLUE);
            g.drawString(Integer.toString(score), 370, 30);
            if ((!hb1.die || !hb2.die)) {
                g.setFont(shootLine);
                g.setColor(Color.red);
                g.drawString("dead line", 300, 365);
                g.fillRect(340,0,3,355);
                //   g.setColor(Color.WHITE);
                // g.fillRect(320, 394, 10, 30);
            }
            //bodyCollision_stand_movingRight            
            //  g.setColor(Color.pink);
            //  g.fillRect((int) robot.getRect().x, (int) robot.getRect().y, (int) robot.getRect().width, (int) robot.getRect().height);
            //legCollision_stand_movingRight
            // g.setColor(Color.BLACK);
            // g.fillRect((int) robot.getRect2().x, (int) robot.getRect2().y, (int) robot.getRect2().width, (int) robot.getRect2().height);
            //handCollisoin_stand_movingRight
            // g.setColor(Color.GRAY);
            // g.fillRect((int) robot.getRect3().x, (int) robot.getRect3().y, (int) robot.getRect3().width, (int) robot.getRect3().height);
            //head_stand_movingRight
            //g.setColor(Color.BLUE);
            //g.fillRect((int) robot.getRect4().x, (int) robot.getRect4().y, (int) robot.getRect4().width, (int) robot.getRect4().height);
            //legs_jumped 
            //g.setColor(Color.red);
            //g.fillRect((int) robot.getRect5().x, (int) robot.getRect5().y, (int) robot.getRect5().width, (int) robot.getRect5().height);
            //legs_movingLeft          
            //g.setColor(Color.red);
            //g.fillRect((int) robot.getRect6().x, (int) robot.getRect6().y, (int) robot.getRect6().width, (int) robot.getRect6().height);
            //body_movingLeft
            //g.setColor(Color.red);
            //g.fillRect((int) robot.getRect7().x, (int) robot.getRect7().y, (int) robot.getRect7().width, (int) robot.getRect7().height);
            //head_movingLeft
            //g.setColor(Color.red);
            //g.fillRect((int) robot.getRect8().x, (int) robot.getRect8().y, (int) robot.getRect8().width, (int) robot.getRect8().height);
            //leg_ducked
            //g.setColor(Color.red);
            //g.fillRect((int) robot.getRect9().x, (int) robot.getRect9().y, (int) robot.getRect9().width, (int) robot.getRect9().height);
            //hand_ducked
            //g.setColor(Color.PINK);
            //g.fillRect((int) robot.getRect10().x, (int) robot.getRect10().y, (int) robot.getRect10().width, (int) robot.getRect10().height);
            //head_ducked
            //g.setColor(Color.WHITE);
            //g.fillRect((int) robot.getRect11().x, (int) robot.getRect11().y, (int) robot.getRect11().width, (int) robot.getRect11().height);
            //legs_blockCollisoionTest
            //g.setColor(Color.GREEN);
            //g.fillRect((int) robot.getRect12().x, (int) robot.getRect12().y, (int) robot.getRect12().width, (int) robot.getRect12().height);
            //Block_collisionTest
            if(!(hb1.die && hb2.die))
            g.drawImage(jumper, block.getStartX(),block.getStartY(),this);
           
            
            if(shotFire){
                if(!robot.isDucked()){
                    if(score<=9){
                  g.drawImage(ShotFire,robot.getCenterX()+80, robot.getCenterY()-57, this);    
                    }
                 else
                    {
                g.drawImage(ShotFire,robot.getCenterX()+58, robot.getCenterY()-36, this);    
                    }
                        
                
                
                }
            }  
            
        } else {
            g.setFont(font);
            g.setColor(Color.BLUE);
            g.drawString("Your score is:" + Integer.toString(score), 310, 240);
            g.setFont(font);
            g.setColor(Color.red);
            g.drawString("Game is over", 310, 200);
            g.setFont(shootLine);
            g.setColor(Color.WHITE);
            g.drawString("press Enter to restart the game", 310, 280);
        }

    }

    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            second = image.getGraphics();
        }

        second.setColor(getBackground());
        second.fillRect(0, 0, getWidth(), getHeight());
        second.setColor(getForeground());
        paint(second);
        g.drawImage(image, 0, 0, this);

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                System.out.println("move_up");
                break;

            case KeyEvent.VK_S:
                if (robot.isJumped() == false) {
                    robot.setIsMovingRight(false);
                    robot.setIsMovingLeft(false);
                    robot.setDucked(true);
                    if (robot.health == 3) {
                        currentSpirit = characterDown;
                    }
                    if (robot.health == 2) {
                        currentSpirit = characterDownbb;
                    }
                    if (robot.health == 1) {
                        currentSpirit = characterDownb;
                    }
                    robot.setSpeedX(0);
                }
                break;

            case KeyEvent.VK_D:
                robot.moveToRight();
                robot.setIsMovingLeft(false);
                robot.setIsMovingRight(true);

                break;

            case KeyEvent.VK_A:
                robot.moveToLeft();
                robot.setIsMovingLeft(true);
                robot.setIsMovingRight(false);
                break;

            case KeyEvent.VK_SPACE:
                if(!robot.isDucked())
                robot.jump();
                break;

            case KeyEvent.VK_CONTROL:
                if (robot.isDucked() == false && robot.isIsMovingLeft() == false) {
                    if (score <= 9) {
                        if (milliseconds > 30) {
                            robot.shoot();
                            shotFire =true;
                            milliseconds = 0;
                        }
                    } else {
                        if (milliseconds > 15) {
                            robot.shoot();
                            shotFire =true;
                            milliseconds = 0;
                        }
                    }
                }
                break;

            case KeyEvent.VK_ENTER:
                if (robot.health == 0) {
                    WAIT();
                    robot.setAlive(true);
                    robot.health = 3;
                    score = 0;
                    robot.setCenterX(100);
                    robot.setGROUND(368);
                    robot.setCenterY(368);
                    hb1 = new Heliboy(480, 360);
                    hb2 = new Heliboy(650, 120);
                    hb1.health = 3;
                    hb2.health = 3;
                }
                break;

        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                System.out.println("stop_moveing_up");
                break;

            case KeyEvent.VK_S:
                robot.setDucked(false);
                if (robot.health == 3) {
                    currentSpirit = anim.getImage();
                }
                if (robot.health == 2) {
                    currentSpirit = animbb.getImage();
                }
                if (robot.health == 1) {
                    currentSpirit = animb.getImage();
                }
                break;

            case KeyEvent.VK_D:
                robot.stopMovingRight();
                if (robot.health == 3 && !robot.isDucked()) {
                    currentSpirit = anim.getImage();
                }
                if (robot.health == 2 && !robot.isDucked()) {
                    currentSpirit = animbb.getImage();
                }
                if (robot.health == 1 && !robot.isDucked()) {
                    currentSpirit = animb.getImage();
                }

                break;

            case KeyEvent.VK_A:
                robot.stopMovingLeft();
                if (robot.health == 3 && !robot.isDucked()) {
                    currentSpirit = anim.getImage();
                }
                if (robot.health == 2 && !robot.isDucked()) {
                    currentSpirit = animbb.getImage();
                }
                if (robot.health == 1 && !robot.isDucked()) {
                    currentSpirit = animb.getImage();
                }
                break;

            
                
              
                
                }
    }

    public void updateGunsImages() {
        if (score <= 9) {
            if (Control.collision_movingLeft() || Control.collision_movingLeftAndJumped()) {
                gun.setImage(lightGunMovingLeft);
            }
            if (Control.collison_ducked()) {
                gun.setImage(lightGunDucked);
            }
            if (Control.collision_stand() || Control.collision_movingRight() || Control.collision_movingRightAndJumped()) {
                gun.setImage(lightGun);
            }
            if (Control.collision_jumped()) {
                gun.setImage(lightGun);
            }
        }
        if (score > 9) {
            gun.setImage(heavyGun);

            if (Control.collision_movingLeft() || Control.collision_movingLeftAndJumped()) {
                gun.setImage(heavyGunMovingLeft);
            }
            if (Control.collison_ducked()) {
                gun.setImage(heavyGunDucked);
            }
            if (Control.collision_stand() || Control.collision_movingRight() || Control.collision_movingRightAndJumped()) {
                gun.setImage(heavyGun);
            }
            if (Control.collision_jumped()) {
                gun.setImage(heavyGun);
            }

        }

    }

    
    public void WAIT(){
        int l = 0;
       for(int i = 0 ; i< 10;i++)
         for(int s = 0 ; s< 10;s++)
             for(int f = 0 ; f< 10;f++)
                 for(int j = 0 ; j< 100;j++)
                  l++;
    }
    
    public void keyTyped(KeyEvent e) {

    }

    public static Background getBg1() {
        return bg1;
    }

    public static Background getBg2() {
        return bg2;
    }

    /**
     * @return the delta
     */
    public static int getDelta() {
        return delta;
    }

    /**
     * @param aDelta the delta to set
     */
    public static void setDelta(int aDelta) {
        delta = aDelta;
    }

}
