/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //

// TODO: import joystick utilities here
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.util.JoystickAxisButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// TODO: import subsystems here
import frc.robot.subsystems.DriveSubsystem;

// TODO: import commands here
// import frc.robot.commands.Autonomous;
import frc.robot.commands.TankDrive;
import frc.robot.commands.IntakePowerCell;
import frc.robot.commands.ShootPowerCell;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

// TODO: import constants here
import frc.robot.Constants.JoystickConstants;

// ^^-----------------------------------------------------------------------------------^^ //

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_drive = new DriveSubsystem();

  // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
  // TODO: Instantiate the remaining subsystems:
  //  - m_shooter
  //  - m_conveyor
  //  - m_intake
  //  - m_hanger (when we're finished!)

  // ^^-----------------------------------------------------------------------------------^^ //

  // private final Autonomous m_autoCommand = new Autonomous(m_shooter, m_conveyor, m_intake, m_hanger);
  private final CommandBase m_autonomousCommand = null;

  // The driver's controller
  Joystick m_driverController = new Joystick(JoystickConstants.kDriverControllerPort);
  Joystick m_operatorController = new Joystick(JoystickConstants.kOperatorControllerPort);

  /**
   * The container for the robot.  Contains subsystems, devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Set default drive command to tank drive
    m_drive.setDefaultCommand(
      new TankDrive(
        () -> m_driverController.getRawAxis(JoystickConstants.kDriverLeftStickAxis)/JoystickConstants.kDriverScaleFactor, 
        () -> m_driverController.getRawAxis(JoystickConstants.kDriverRightStickAxis)/JoystickConstants.kDriverScaleFactor,
        m_drive)
    );
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // operator left trigger for intake
    final JoystickAxisButton m_operatorLeftTriggerAxisButton = new JoystickAxisButton(m_operatorController, JoystickConstants.kOperatorLeftTrigger, JoystickConstants.kTriggerThreshold);
    final Trigger m_operatorLeftTrigger = new Trigger(m_operatorLeftTriggerAxisButton::get);

    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: Create JoystickAxisButton and Trigger objects for operator right trigger for shooting

    // TODO: Create JoystickButton objects for useful operator buttons

    // TODO: Create JoystickButton objects for driver trigger for precise mode

    // ^^-----------------------------------------------------------------------------------^^ //



    // connect operator left trigger to intake power cell command
    m_operatorLeftTrigger.whileActiveOnce(new IntakePowerCell(m_intake, m_conveyor));

    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: connect operator right trigger to shoot while active once

    // ^^-----------------------------------------------------------------------------------^^ //

    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: connect driver right trigger to go to precise mode when active (uncomment line below)
    // m_driverRightTrigger.whenActive(() -> m_drive.setPreciseMode());

    // TODO: connect driver right trigger to go back to regular drive mode when inactive

    // ^^-----------------------------------------------------------------------------------^^ //
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autonomousCommand;
  }
}
