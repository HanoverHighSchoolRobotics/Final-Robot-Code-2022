// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  Spark frontLeftMotor;
  Spark backLeftMotor;  
  Spark frontRightMotor; 
  Spark backRightMotor; 
  MotorControllerGroup leftController; 
  MotorControllerGroup rightController; 
  DifferentialDrive m_robotDrive; 
  //Spark shootLift; 

  public DriveTrain() {
    frontLeftMotor = new Spark(Constants.frontLeft);
    backLeftMotor = new Spark(Constants.backLeft);  
    frontRightMotor = new Spark(Constants.frontRight); 
    backRightMotor = new Spark(Constants.backRight); 


    leftController = new MotorControllerGroup(backLeftMotor, frontLeftMotor); 
    rightController = new MotorControllerGroup(backRightMotor, frontRightMotor); 
    leftController.setInverted(true);


    m_robotDrive = new DifferentialDrive(leftController, rightController);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void joyStickDrive(Joystick driveWithJoySticks){
    m_robotDrive.arcadeDrive((driveWithJoySticks.getRawAxis(Constants.move) * Constants.driveSpeed), -(driveWithJoySticks.getRawAxis(Constants.turn) * Constants.driveSpeed));
  }
  public void driveBackward(){
    m_robotDrive.tankDrive(Constants.speed, Constants.speed);
  }// DAVID, place this into the parentheses -Constants.speed, -Constants.speed wheels not driving the right way in autonomous
  
  public void stop(){
    m_robotDrive.stopMotor();
  }
}
