// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import edu.wpi.first.wpilibj.Timer; //uncomment this line 
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SpoolMove;

public class SpoolMoveD extends CommandBase {
 // Timer time = new Timer(); //uncomment this line 
  double wheelDiameter = 1.422; 
  double pulsePerRotation = 360; 
  double gearRatio = 64; 
  double encoderGearRatio = 1; 
  double distancePerPulse; 
  /** Creates a new WinchMoveD. */
  SpoolMove liftDown; 
  public SpoolMoveD(SpoolMove down){ 
    liftDown = down; 
    addRequirements(liftDown); 
    distancePerPulse = Math.PI * wheelDiameter / pulsePerRotation / encoderGearRatio / gearRatio; 
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   // time.reset();  //uncomment these two lines 
   // time.start();
   liftDown.encode.setReverseDirection(true);  
   liftDown.encode.reset(); 
   liftDown.encode.setDistancePerPulse(distancePerPulse); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //uncomment these lines 
    /*
    if(!Constants.up){
      if(time.get() < Constants.timeDown){
          liftDown.move(-Constants.spoolSpeed);
      }
      else{
        liftDown.move(0); 
        Constants.up = true; 
      }
    } 
    */
       
    //comment out these lines 
    
    if(!Constants.up){
      if(liftDown.encode.getDistance() < Constants.spoolDown){
        liftDown.move(-Constants.spoolSpeed); 
      } 
      else{
        liftDown.move(Constants.holdUp); //-.1
        Constants.up = true; 
       
    }  
  }



}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    liftDown.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Constants.up;
  }
}
