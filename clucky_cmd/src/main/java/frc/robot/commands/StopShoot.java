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

// ^^-----------------------------------------------------------------------------------^^ //

/**
 * Stops shooter and conveyor
 */
public class StopShoot extends CommandBase {
  // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
  // TODO: declare the shooter and conveyor subsystems here (m_shooter, m_conveyor)

  // ^^-----------------------------------------------------------------------------------^^ //

  public StopShoot(ShooterSubsystem shooter, ConveyorSubsystem conveyor) {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: instantiate the shooter and conveyor here
    
    // TODO: add shooter and conveyor as a requirement
    // addRequirements(m_shooter, m_conveyor);
    // ^^-----------------------------------------------------------------------------------^^ //
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: stop both shooter and conveyor here

    // ^^-----------------------------------------------------------------------------------^^ //
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: return true

    // ^^-----------------------------------------------------------------------------------^^ //
  }
}
