// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Winch;

public class WinchMoveU extends CommandBase {
  /** Creates a new WinchMoveU. */
  Winch winch; 
  public WinchMoveU(Winch w) {
    // Use addRequirements() here to declare subsystem dependencies.
    winch = w; 
    addRequirements(winch);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    winch.move(Constants.winchSpeed,Constants.winchSpeed2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    winch.stop(); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
