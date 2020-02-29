/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Drive subsystem of robot. Differential drive with two motors driving each side.
   */
  // The motors on the left side of the drive
  private final VictorSPX m_leftMotor1 = new VictorSPX(DriveConstants.kLeftMotor1Port);
  private final VictorSPX m_leftMotor2 = new VictorSPX(DriveConstants.kLeftMotor2Port);
  // The motors on the right side of the drive
  private final VictorSPX m_rightMotor1 = new VictorSPX(DriveConstants.kRightMotor1Port);
  private final VictorSPX m_rightMotor2 = new VictorSPX(DriveConstants.kRightMotor2Port);

  public DriveSubsystem() {
    m_leftMotor1.configFactoryDefault();
    m_leftMotor1.set(ControlMode.PercentOutput, 0);
    m_leftMotor2.configFactoryDefault();
    m_leftMotor2.set(ControlMode.PercentOutput, 0);
    m_rightMotor1.configFactoryDefault();
    m_rightMotor1.set(ControlMode.PercentOutput, 0);
    m_rightMotor2.configFactoryDefault();
    m_rightMotor2.set(ControlMode.PercentOutput, 0);
  }

  /**
   * Drives the robot using tank drive.
   * 
   * @param leftspeed speed for left side
   * @param rightspeed speed for right side
   */
  public void tankDrive(double leftspeed, double rightspeed) {
    m_leftMotor1.set(ControlMode.PercentOutput, leftspeed);
    m_leftMotor2.set(ControlMode.PercentOutput, leftspeed);
    m_rightMotor1.set(ControlMode.PercentOutput, -rightspeed);
    m_rightMotor2.set(ControlMode.PercentOutput, -rightspeed);
  }
}
