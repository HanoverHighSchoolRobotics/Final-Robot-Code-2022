// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.math.Drake;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.commands.AngleDown;
import frc.robot.commands.AngleUp;
import frc.robot.commands.AutonomousPeriod;
import frc.robot.commands.DriveWithJoySticks;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.ManualSpoolMoveD;
import frc.robot.commands.ManualSpoolMoveU;
import frc.robot.commands.ShootBall;
import frc.robot.commands.SpoolMoveD;
import frc.robot.commands.SpoolMoveU;
import frc.robot.commands.WinchMoveD;
import frc.robot.commands.WinchMoveU;
import frc.robot.subsystems.ArmAngle;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.SpoolMove;
import frc.robot.subsystems.Winch;
import frc.robot.subsystems.ShooterIn;
import frc.robot.subsystems.ShooterOut;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain = new DriveTrain();

  

  public static Joystick driverStick; 
  public static Joystick auxJoystick; 
  //private final DriveTrain driveTrain; 
  private final AutonomousPeriod auto; 
  private final DriveWithJoySticks driveWithJoySticks; 

  private final ShooterOut shootOut; 
  private final ShootBall shootBall;

  private final ShooterIn shootIn; 
  private final IntakeBall intakeBall; 

  private final SpoolMove shootUp; 
  private final SpoolMoveU shooterUp; 

  private final SpoolMove shootdown;
  private final SpoolMoveD shooterDown;
  
  private final SpoolMove manualU; 
  private final ManualSpoolMoveU manualUp; 

  private final SpoolMove manualD; 
  private final ManualSpoolMoveD manualDown; 

  private final ArmAngle angle; 
  private final AngleUp angleUp; 
  private final AngleDown angleDown;

  private final Winch winchMove; 
  private final WinchMoveU winchUp; 
  private final WinchMoveD winchDown;  
  
  Spark shooter; 
  Spark shootLift; 
  Spark winch; 
  Spark arm; 
  Spark winch2; 
  Encoder encode; 

  //private final DriveBackwardTimed driveBackwardTimed; 
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    shooter = new Spark(Constants.shooter);
    shootLift = new Spark(Constants.shootLift);
    winch = new Spark(Constants.winchLift); 
    arm = new Spark(Constants.armAngle);
    winch2 = new Spark(Constants.winchLift2); 

    encode = new Encoder(0, 1, false, Encoder.EncodingType.k1X); 
    auto = new AutonomousPeriod(driveTrain, shootLift, shooter); 
    driveWithJoySticks = new DriveWithJoySticks(driveTrain); 
    driveWithJoySticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoySticks);
    driverStick = new Joystick(Constants.joyStick1); 
    auxJoystick = new Joystick(Constants.joyStick2); 
    
    shootOut = new ShooterOut(shooter); 
    shootBall = new ShootBall(shootOut); 
    shootBall.addRequirements(shootOut); 

    shootIn = new ShooterIn(shooter); 
    intakeBall = new IntakeBall(shootIn); 
    intakeBall.addRequirements(shootIn);

    shootUp = new SpoolMove(shootLift, encode);
    shooterUp = new SpoolMoveU(shootUp); 
    shooterUp.addRequirements(shootUp);

    shootdown = new SpoolMove(shootLift, encode); 
    shooterDown = new SpoolMoveD(shootdown); 
    shooterDown.addRequirements(shootdown);

    manualU = new SpoolMove(shootLift); 
    manualUp = new ManualSpoolMoveU(manualU); 
    manualUp.addRequirements(manualU); 

    manualD = new SpoolMove(shootLift); 
    manualDown = new ManualSpoolMoveD(manualD); 
    manualDown.addRequirements(manualD);

    winchMove = new Winch(winch, winch2); 
    winchUp = new WinchMoveU(winchMove); 
    winchUp.addRequirements(winchMove); 
    winchDown = new WinchMoveD(winchMove); 
    winchDown.addRequirements(winchMove);

    angle = new ArmAngle(arm); 
    angleUp = new AngleUp(angle); 
    angleDown = new AngleDown(angle); 
    angleUp.addRequirements(angle);
    angleDown.addRequirements(angle);





    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
//David, if you need to change the value of the joystick, change the numberrs to the numbers on the joystick
  private void configureButtonBindings() {
  JoystickButton shootButton = new JoystickButton(auxJoystick, 1);
  shootButton.whileHeld(new ShootBall(shootOut)); 

  JoystickButton intakeButton = new JoystickButton(auxJoystick, 2);
    intakeButton.whileHeld(new IntakeBall(shootIn)); 

  JoystickButton shootLiftU = new JoystickButton(auxJoystick, 5);
  shootLiftU.whenPressed(new SpoolMoveU(shootUp));
  
  JoystickButton shootLiftD = new JoystickButton(auxJoystick, 3); 
  shootLiftD.whenPressed(new SpoolMoveD(shootdown)); 

  JoystickButton angleUp = new JoystickButton(auxJoystick, 4); 
  angleUp.whileHeld(new AngleUp(angle)); 

  JoystickButton angleDown = new JoystickButton(auxJoystick, 6); 
  angleDown.whileHeld(new AngleDown(angle)); 

  JoystickButton winchUp = new JoystickButton(auxJoystick, 12); 
  winchUp.whileHeld(new WinchMoveU(winchMove)); 

  JoystickButton winchDown = new JoystickButton(auxJoystick, 11); 
  winchDown.whileHeld(new WinchMoveD(winchMove)); 

  JoystickButton manualSpoolU = new JoystickButton(auxJoystick, 10);
  manualSpoolU.whileHeld(new ManualSpoolMoveU(manualU));  

  JoystickButton manualSpoolD = new JoystickButton(auxJoystick, 9);
  manualSpoolD.whileHeld(new ManualSpoolMoveD(manualD));
  


    
  }
  


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return auto;
  }
}
