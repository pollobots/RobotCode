/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Shooter subsystem of robot. Single wheel driven with SparkMAXs on either side.
   */
  
  // The main shooter motor
  private final CANSparkMax m_shooterMotor = new CANSparkMax(ShooterConstants.kShooterMotorPort, MotorType.kBrushless);
  private final CANEncoder m_shooterEncoder;
  // The secondary shooter motor (inverted)
  private final CANSparkMax m_shooterFollower = new CANSparkMax(ShooterConstants.kShooterFollowerPort, MotorType.kBrushless);
  private final CANEncoder m_followerEncoder;
  // PID controller
  private CANPIDController m_pidController;  

  public ShooterSubsystem() {
    m_shooterFollower.follow(m_shooterMotor,true); 
    m_shooterEncoder = m_shooterMotor.getEncoder();
    m_followerEncoder = m_shooterFollower.getEncoder();
    m_pidController = m_shooterMotor.getPIDController();
    // set PID coefficients
    m_pidController.setP(ShooterConstants.kP);
    m_pidController.setI(ShooterConstants.kI);
    m_pidController.setD(ShooterConstants.kD);
    m_pidController.setIZone(ShooterConstants.kIz);
    m_pidController.setFF(ShooterConstants.kFF);
    m_pidController.setOutputRange(-1,1);
  }

  /**
   * Spins up shooter
   */
  public void shoot() {
    m_pidController.setReference(ShooterConstants.kShootRPM, ControlType.kVelocity);
  }

  /**
   * Stops shooter
   */
  public void stop() {
    m_pidController.setReference(0, ControlType.kVelocity);
  
  }
  
  /**
   * Reterns whether the shooter has reached desired speed (boolean)
   */
  public boolean ready() {
    double m_shooterEncoder_RPM = m_shooterEncoder.getVelocity();
    double m_followerEncoder_RPM  = m_followerEncoder.getVelocity();
    double average_RPM = (m_shooterEncoder_RPM + m_followerEncoder_RPM)/2;
    double error = Math.abs(ShooterConstants.kShootRPM - average_RPM);
    boolean isReady = error < ShooterConstants.kShooterthreshold;
    return isReady;
  }
}
