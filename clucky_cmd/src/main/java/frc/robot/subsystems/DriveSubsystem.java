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
  private final VictorSPX leftmotor1 = new VictorSPX(DriveConstants.kLeftMotor1Port);
  private final VictorSPX leftmotor2 = new VictorSPX(DriveConstants.kLeftMotor2Port);
  // The motors on the right side of the drive
  private final VictorSPX rightmotor1 = new VictorSPX(DriveConstants.kRightMotor1Port);
  private final VictorSPX rightmotor2 = new VictorSPX(DriveConstants.kRightMotor2Port);

  public DriveSubsystem() {

  }

  /**
   * Initializes and stops the drive train.
   * 
   */
  public void initMotors() {
    leftmotor1.configFactoryDefault();
    leftmotor1.set(ControlMode.PercentOutput, 0);
    leftmotor2.configFactoryDefault();
    leftmotor2.set(ControlMode.PercentOutput, 0);
    rightmotor1.configFactoryDefault();
    rightmotor1.set(ControlMode.PercentOutput, 0);
    rightmotor2.configFactoryDefault();
    rightmotor2.set(ControlMode.PercentOutput, 0);
  }

  /**
   * Drives the robot using tank drive.
   * 
   * @param leftspeed speed for left side
   * @param rightspeed speed for right side
   */
  public void tankDrive(double leftspeed, double rightspeed) {
    leftmotor1.set(ControlMode.PercentOutput, leftspeed);
    leftmotor2.set(ControlMode.PercentOutput, leftspeed);
    rightmotor1.set(ControlMode.PercentOutput, rightspeed);
    rightmotor2.set(ControlMode.PercentOutput, rightspeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
