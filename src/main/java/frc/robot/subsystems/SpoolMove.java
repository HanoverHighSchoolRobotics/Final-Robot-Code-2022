// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpoolMove extends SubsystemBase {
  Spark shootLift;  
  public Encoder encode; 
  /** Creates a new Winch. */
  public SpoolMove(Spark lift) {
    shootLift = lift;   
    
  }
  public SpoolMove(Spark lift, Encoder code){
    shootLift = lift; 
    encode = code; 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void move(double speed){
    shootLift.set(speed); 
  }
  public void stop(){
    shootLift.set(0);
  }
}
