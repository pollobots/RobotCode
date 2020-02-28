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
  private final CANSparkMax shootermotor = new CANSparkMax(ShooterConstants.kShooterMotorPort, MotorType.kBrushless);
  private final CANEncoder m_encoder;
  // The secondary shooter motor (inverted)
  private final CANSparkMax shooterfollower = new CANSparkMax(ShooterConstants.kShooterFollowerPort, MotorType.kBrushless);
  private final CANEncoder m2_encoder;
  // PID controller
  private CANPIDController m_pidController;  

  public ShooterSubsystem() {
    shooterfollower.follow(shootermotor,true); 
    m_encoder = shootermotor.getEncoder();
    m2_encoder = shooterfollower.getEncoder();
    m_pidController = shootermotor.getPIDController();
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
    m_pidController.setReference(ShooterConstants.shootRPM, ControlType.kVelocity);
  
  }

  /**
   * Stops shooter
   */
  public void stop() {
    m_pidController.setReference(0, ControlType.kVelocity);
  
  }
  /**
   * Reterns whether the shouter is right
   */
  public boolean ready() {
    double m_encoder_RPM = m_encoder.getVelocity();
    double m2_encoder_RPM  = m2_encoder.getVelocity();
    double average_RPM = (m_encoder_RPM + m2_encoder_RPM)/2;
    double error = Math.abs(ShooterConstants.shootRPM - average_RPM);
    boolean isready = error < ShooterConstants.shooterthreshold;
    return isready;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
