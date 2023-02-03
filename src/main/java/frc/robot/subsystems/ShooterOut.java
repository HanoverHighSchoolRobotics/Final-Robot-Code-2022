// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterOut extends SubsystemBase {
  //Spark shooter; 
  Spark shooter; 
  /** Creates a new ShooterOut. */
  public ShooterOut(Spark shoot) {
    shooter = shoot; 
    
    //shooter = new Spark(Constants.shooter); 
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void shootBall(double speed){
    shooter.set(speed); 
  }
  public void stop(){
    shooter.set(0); 
  }
}
