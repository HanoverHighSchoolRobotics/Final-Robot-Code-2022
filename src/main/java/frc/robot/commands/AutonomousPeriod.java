// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class AutonomousPeriod extends CommandBase {
  /** Creates a new AutonomousPeriod. */
  Timer m_timer = new Timer();
  private final DriveTrain driveTrain;
  boolean stop = false;  
  Spark shooter; 
  Spark shootLift; 
  public AutonomousPeriod(DriveTrain dt, Spark sl, Spark sh) {
    shooter = sh; 
    shootLift = sl; 
    driveTrain = dt; 
    addRequirements(driveTrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset(); 
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        if(m_timer.get() < 2){
          shootLift.set(Constants.holdUp); 
          shooter.set(-Constants.shootSpeed); 
          driveTrain.stop();
        }
        else if(m_timer.get() < 3){
          //shooting
          //if(m_timer.get() < Constants.timeUp){
            //shootLift.set(Constants.spoolSpeed);
          //  shootLift.set(0); 
          //}
          //else{
            shootLift.set(Constants.holdUp);
            shooter.set(Constants.shootSpeed); 
            driveTrain.stop(); 
          //} 
        }
        else if(m_timer.get() < 6){
          shooter.set(0); 
          driveTrain.driveBackward(); 
        }
        else if(m_timer.get() - 6 < Constants.timeDown){
          shootLift.set(-Constants.spoolSpeed); 
          Constants.up = true; 
          driveTrain.stop();
        }
        else{
          //m_robotDrive.stopMotor();
          shootLift.set(0); 
          driveTrain.stop();
          shooter.set(0); 
           
        } 
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) { 
    shootLift.set(0); 
    driveTrain.stop();
    shooter.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return stop;
  }
}
