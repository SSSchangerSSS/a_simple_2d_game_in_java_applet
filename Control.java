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
public class Control {


public static boolean genrate(){
return(StartingClass.hb1.die == StartingClass.hb2.die == true && (StartingClass.getBg1().pass>=1||StartingClass.getBg2().pass>=1) );
}
public static boolean collision_stand(){
return (!StartingClass.robot.isDucked()&&!StartingClass.robot.isJumped()&&!StartingClass.robot.isIsMovingLeft()&&!StartingClass.robot.isIsMovingRight());
}
public static boolean collision_movingRight(){
return(!StartingClass.robot.isDucked()&&!StartingClass.robot.isJumped()&&!StartingClass.robot.isIsMovingLeft()&&StartingClass.robot.isIsMovingRight());
}
public static boolean collision_movingLeft(){
return(!StartingClass.robot.isDucked()&&!StartingClass.robot.isJumped()&&StartingClass.robot.isIsMovingLeft()&&!StartingClass.robot.isIsMovingRight());
}
public static boolean collision_jumped(){
return(!StartingClass.robot.isDucked()&&StartingClass.robot.isJumped()&&!StartingClass.robot.isIsMovingLeft()&&!StartingClass.robot.isIsMovingRight());
}
public static boolean collision_movingRightAndJumped(){
return(!StartingClass.robot.isDucked()&&StartingClass.robot.isJumped()&&!StartingClass.robot.isIsMovingLeft()&&StartingClass.robot.isIsMovingRight());
}
public static boolean collision_movingLeftAndJumped(){
return(!StartingClass.robot.isDucked()&&StartingClass.robot.isJumped()&&StartingClass.robot.isIsMovingLeft()&&!StartingClass.robot.isIsMovingRight());
}
public static boolean collison_ducked(){
return(StartingClass.robot.isDucked()&&!StartingClass.robot.isJumped()&&!StartingClass.robot.isIsMovingLeft()&&!StartingClass.robot.isIsMovingRight());
}
}