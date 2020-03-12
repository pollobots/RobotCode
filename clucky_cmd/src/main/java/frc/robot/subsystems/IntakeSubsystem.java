/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
// Import needed packages here!
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
// ^^-----------------------------------------------------------------------------------^^ //

import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Intake subsystem of robot. Motor driving belt system for moving power cells to shooter
   */

  // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
  //  instantiate the intake motor controller here (m_intakeMotor)
  Spark m_intakeMotor = new Spark(IntakeConstants.kIntakeMotorPort);
  // ^^-----------------------------------------------------------------------------------^^ //
  
  public IntakeSubsystem() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    //  configure and initialize motor (if necessary)
    m_intakeMotor.set(0);
    // ^^-----------------------------------------------------------------------------------^^ //
  }

  /**
   * Stop intake
   */
  public void stop() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: stop the intake motor
    m_intakeMotor.set(0);
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
