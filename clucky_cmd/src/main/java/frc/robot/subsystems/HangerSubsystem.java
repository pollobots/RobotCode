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

// import frc.robot.Constants.HangerConstants;

public class HangerSubsystem extends SubsystemBase {
  /**
   * Hangar subsystem of robot. Motor driving winch for hangar. Note that motor drives in a 
   * single direction for both extending and pulling in.
   */

  // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
  // TODO: instantiate the hanger motor controller here (m_hangerMotor)

  // TODO: instantiate the hanger sensor to see if hanger is extended (m_hangerSensor)

  // TODO: instantiate a boolean (true/false) flag indicating whether hanger is extended (m_extended)
  //       flag should be initialized false and only set true from the deploy() method

  // ^^-----------------------------------------------------------------------------------^^ //
  
  public HangerSubsystem() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: configure and initialize motor (if necessary)

    // TODO: configure and initialize sensor (if necessary)

    // ^^-----------------------------------------------------------------------------------^^ //
  }

  /**
   * Deploy hanger
   */
  public void deploy() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: run the intake motor to both extend the hanger
    //       Note: only enable running motor when the m_extended flag is false
    //       Also check the motor sensor to see if extended state has been reached.
    //       If the sensor says we have full extended, set the m_extended flag to true!
    //       Once the m_extended flag has been set, this function will no longer be able to 
    //       run the motor.

    // ^^-----------------------------------------------------------------------------------^^ //
  }

  /**
   * Hang (pull in the hanger)
   */
  public void hang() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: run the intake motor to both extend and pull in hanger
    //       Note: only enable running motor when the m_extended flag is true

    // ^^-----------------------------------------------------------------------------------^^ //
  }
  

  /**
   * Tell the rest of the program if hanger has been extended fully
   */
  public boolean extended() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: return the value of the m_extended flag.
    return false;
    // ^^-----------------------------------------------------------------------------------^^ //
  }
}
