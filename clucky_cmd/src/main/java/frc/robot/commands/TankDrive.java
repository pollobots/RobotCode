/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Drive the robot tank style
 */
public class TankDrive extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final DoubleSupplier m_leftSpeed;
  private final DoubleSupplier m_rightSpeed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param left Control input for left side drive
   * @param right Control input for right side drive
   * @param driveTrain The drivetrain subsystem used by this command
   */
  public TankDrive(DoubleSupplier left, DoubleSupplier right, DriveSubsystem driveTrain) {
    m_driveSubsystem = driveTrain;
    m_leftSpeed = left;
    m_rightSpeed = right;
    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveSubsystem.tankDrive(m_leftSpeed.getAsDouble(), m_rightSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
