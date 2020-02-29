/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
// TODO: Import needed packages here!
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// ^^-----------------------------------------------------------------------------------^^ //

import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Intake subsystem of robot. Motor driving belt system for moving power cells to shooter
   */

  // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
  // TODO: instantiate the intake motor controller here (m_intakeMotor)

  // ^^-----------------------------------------------------------------------------------^^ //
  
  public IntakeSubsystem() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: configure and initialize motor (if necessary)

    // ^^-----------------------------------------------------------------------------------^^ //
  }

  /**
   * Stop intake
   */
  public void stop() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: stop the intake motor

    // ^^-----------------------------------------------------------------------------------^^ //
  }

  /**
   * Intake power cells
   */
  public void intake() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: turn on intake motor to intake power cells

    // ^^-----------------------------------------------------------------------------------^^ //
  }

  /**
   * Expel power cells
   */
  public void eject() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: turn on intake motor to eject power cells

    // ^^-----------------------------------------------------------------------------------^^ //
  }
}
