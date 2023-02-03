// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


//import edu.wpi.first.wpilibj.Timer;     //uncomment these lines 
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SpoolMove;

public class SpoolMoveU extends CommandBase {
  /** Creates a new WinchMoveU. */
  SpoolMove liftUp; 
  double wheelDiameter = 1.422; 
  double pulsePerRotation = 360; 
  double gearRatio = 64; 
  double encoderGearRatio = 1; 
  double distancePerPulse; 
  //Timer time = new Timer();     //uncomment this line
  public SpoolMoveU(SpoolMove up){
    liftUp = up; 
    addRequirements(up);
    distancePerPulse = Math.PI * wheelDiameter / pulsePerRotation / encoderGearRatio / gearRatio; 
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  //  time.reset();  //uncomment these two lines 
  //  time.start(); 

  liftUp.encode.setReverseDirection(false); //comment these three lines out 
  liftUp.encode.reset(); 
  liftUp.encode.setDistancePerPulse(distancePerPulse);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //uncomment these lines 
  /*  if(Constants.up){
      if(time.get() < Constants.timeUp){
          liftUp.move(Constants.spoolSpeed);
      }
      else{
        liftUp.move(Constants.holdUp); 
        Constants.up = false; 
      }
    } 
    */ 

        //comment these lines out 
    if(Constants.up){
      if(liftUp.encode.getDistance() < Constants.spoolUp){
        liftUp.move(Constants.spoolSpeed); 
      } 
      else{
        liftUp.move(Constants.holdUp); 
        Constants.up = false; 
      } 
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    liftUp.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !Constants.up;
  }
}
