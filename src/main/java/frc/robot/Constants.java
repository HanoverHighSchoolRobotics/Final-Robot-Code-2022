// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //PWM ports 
    public static final int frontLeft = 1; 
    public static final int backLeft = 2; 
    public static final int frontRight = 3; 
    public static final int backRight = 4; 
    public static final int shooter = 5; 
    public static final int shootLift = 6; 
    public static final int winchLift = 7;  
    public static final int armAngle = 8;
    public static final int winchLift2 = 9; 

    public static int move = 1; 
    public static int turn = 2;
    public static double speed =.8;
    public static int joyStick1 = 0;
    public static int joyStick2 = 1;
    public static double timing;
    public static double holdUp = .05;
    public static double shootSpeed = 1;  
    public static boolean up = true;
    public static double timeDown = 2; 
    public static double timeUp = 3.35;
    public static double spoolSpeed = .7;
    public static double armSpeed = .4;
    public static double winchSpeed = 1;
    public static double winchSpeed2 = 1;
    public static double timeDownAuto = 2.4;
    public static double fix = .7;
    public static double spoolDown = 78;
    public static double spoolUp = 79;
	public static double driveSpeed =1;
}

