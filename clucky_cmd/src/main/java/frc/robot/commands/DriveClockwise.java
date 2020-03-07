/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

/**
 * Drives robot clockwise for given period of time.
 */
public class DriveClockwise extends WaitCommand {
  // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
  // TODO: declare the drive train here (m_driveTrain)
  private final DriveSubsystem m_driveTrain;
  // ^^-----------------------------------------------------------------------------------^^ //
  
  /**
   * Creates a new DriveClockwise command.
   *
   * @param driveTrain The drivetrain subsystem used by this command
   */
  public DriveClockwise(double seconds, DriveSubsystem driveTrain) {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // tell the system how long to run command for here:
    super(seconds);

    // TODO: instantiate the driveTrain here
    m_driveTrain = driveTrain;
    // TODO: add driveTrain as a requirement
    addRequirements(m_driveTrain);
    // ^^-----------------------------------------------------------------------------------^^ //
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: set driveTrain to drive clockwise
    m_driveTrain.tankDrive(DriveConstants.kDriveTurnSpeed, -DriveConstants.kDriveTurnSpeed);
    // ^^-----------------------------------------------------------------------------------^^ //
    super.initialize();
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: set driveTrain to stop
    m_driveTrain.tankDrive(0,0);
    // ^^-----------------------------------------------------------------------------------^^ //
  }
}
