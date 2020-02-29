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
 * Intakes power cell with intake system and clears conveyor if necessary
 */
public class IntakePowerCell extends CommandBase {
  // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
  // TODO: declare the intake and conveyor subsystems here (m_intake, m_conveyor)

  // ^^-----------------------------------------------------------------------------------^^ //

  public IntakePowerCell(IntakeSubsystem intake, ConveyorSubsystem conveyor) {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: instantiate the intake and conveyor here
    
    // TODO: add intake and conveyor as a requirement
    // addRequirements(m_intake, m_conveyor);
    // ^^-----------------------------------------------------------------------------------^^ //
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: set intake to intake power cells, and set conveyor to stop

    // ^^-----------------------------------------------------------------------------------^^ //
  }

  // Run periodically
  @Override
  public void execute() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: check power cell sensor
    //  if there is a power cell, run conveyor to clear
    //  if not, then turn conveyor off

    // ^^-----------------------------------------------------------------------------------^^ //
  }
}
