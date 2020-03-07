/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

// WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
// TODO: import required subsystems here!
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ConveyorSubsystem;
// ^^-----------------------------------------------------------------------------------^^ //

/**
 * Spins up shooter, then delivers power cells to shooter with conveyor
 */
public class ShootPowerCell extends CommandBase {
  // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
  // TODO: declare the shooter and conveyor subsystems here (m_shooter, m_conveyor)
  private final ShooterSubsystem m_shooter;
  private final ConveyorSubsystem m_conveyor;
  // ^^-----------------------------------------------------------------------------------^^ //

  public ShootPowerCell(ShooterSubsystem shooter, ConveyorSubsystem conveyor) {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: instantiate the shooter and conveyor here
    m_shooter = shooter;
    m_conveyor = conveyor;
    // TODO: add shooter and conveyor as a requirement
    addRequirements(m_shooter, m_conveyor);
    // ^^-----------------------------------------------------------------------------------^^ //
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: set shooter to shoot here
    m_shooter.shoot();
    // ^^-----------------------------------------------------------------------------------^^ //
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: return if shooter is ready
    return m_shooter.ready();
    // ^^-----------------------------------------------------------------------------------^^ //
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: set conveyor to feed power cells to shooter
    m_conveyor.moveUp();
    // ^^-----------------------------------------------------------------------------------^^ //
  }
}
