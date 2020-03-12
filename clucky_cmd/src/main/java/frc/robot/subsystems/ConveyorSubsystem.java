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

import frc.robot.Constants.ConveyorConstants;

public class ConveyorSubsystem extends SubsystemBase {
  /**
   * Conveyor subsystem of robot. Motor driving belt system for moving power cells to shooter
   */

  // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
  //  instantiate the converyor motor controller here (m_conveyorMotor)
  Spark m_conveyorMotor = new Spark(ConveyorConstants.kConveyorMotorPort);
  // TODO: instantiate the power cell sensor here (m_powerCellSensor)
  //    Wait until it is actually implemented, for now we don't need it!

  // ^^-----------------------------------------------------------------------------------^^ //
  
  public ConveyorSubsystem() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    //  configure and initialize motor (if necessary)
    m_conveyorMotor.set(0);
    // TODO: configure and initialize power cell sensor (if necessary)

    // ^^-----------------------------------------------------------------------------------^^ //
  }

  /**
   * Stop conveyor
   */
  public void stop() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    //  stop the conveyor motor
    m_conveyorMotor.set(0);
    // ^^-----------------------------------------------------------------------------------^^ //
  }

  /**
   * Move power cells up with conveyor
   */
  public void moveUp() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    //  turn on conveyor motor to move power cells toward shooter
    m_conveyorMotor.set(ConveyorConstants.kConveyorUpSpeed);

    // ^^-----------------------------------------------------------------------------------^^ //
  }

  /**
   * Move power cells down with conveyor
   */
  public void moveDown() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    //  turn on conveyor motor to move power cells toward intake
    m_conveyorMotor.set(ConveyorConstants.kConveyorDownSpeed);
    // ^^-----------------------------------------------------------------------------------^^ //
  }
  
  /**
   * Reterns whether there is a power cell in the bottom of the conveyor
   */
  public boolean hasPowerCell() {
    // WRITE CODE BETWEEN THESE LINES -------------------------------------------------------- //
    // TODO: read power cell sensor to see if there is a power cell currently in position
    //       (return whether there is a cell in the true/false variable "hasCell")
    boolean hasCell = true; // intializing to true, need to add logic
    return hasCell;
  }
}
