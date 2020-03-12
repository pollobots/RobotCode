/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
// import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj.AnalogInput;
/* Trying to get vision stuff to work
import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
// creates UsbCamera and Mjpegserver [1] and connects them
 CameraServer.getInstance().startAutomaticCapture();
  // Creates the CvSink and connects it to the UsbCamera
*/

/*
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
Timer my_timer = new Timer();

VictorSPX leftmotor1 = new VictorSPX(2);
VictorSPX leftmotor2 = new VictorSPX(3);
VictorSPX rightmotor1 = new VictorSPX(0);
VictorSPX rightmotor2 = new VictorSPX(1);

CANSparkMax shootermotor = new CANSparkMax(4, MotorType.kBrushless);
CANSparkMax shooterfollower = new CANSparkMax(5, MotorType.kBrushless);
private CANPIDController m_pidController;
private CANEncoder m_encoder, m2_encoder;
public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM, wall_distance;

VictorSPX hangermotor = new VictorSPX(6);
Spark conveyor1 = new Spark(7);
Spark intakemotor = new Spark(8);

private Joystick controller1 = new Joystick(0);
private Joystick controller2 = new Joystick(1);


private final AnalogInput ultrasonic = new AnalogInput(0);



  @Override
  public void robotInit() {
    shooterfollower.follow(shootermotor,true); 
    CameraServer.getInstance().startAutomaticCapture();

    m_pidController = shootermotor.getPIDController();
    m_encoder = shootermotor.getEncoder();
    m2_encoder = shooterfollower.getEncoder();

     // PID coefficients
     kP = 6e-5; 
     kI = 0;
     kD = 0; 
     kIz = 0; 
     kFF = 0.000175; 
     kMaxOutput = 3000; 
     maxRPM = 5700;
     wall_distance = 0;
 
     // set PID coefficients
     m_pidController.setP(kP);
     m_pidController.setI(kI);
     m_pidController.setD(kD);
     m_pidController.setIZone(kIz);
     m_pidController.setFF(kFF);
     m_pidController.setOutputRange(-1,1);
 
     // display PID coefficients on SmartDashboard
     SmartDashboard.putNumber("P Gain", kP);
     SmartDashboard.putNumber("I Gain", kI);
     SmartDashboard.putNumber("D Gain", kD);
     SmartDashboard.putNumber("I Zone", kIz);
     SmartDashboard.putNumber("Feed Forward", kFF);
     SmartDashboard.putNumber("Set Speed", kMaxOutput);
     SmartDashboard.putNumber("wall_distance", wall_distance);
  }   


  @Override
  public void autonomousInit() {
    my_timer.reset();
    my_timer.start();

    leftmotor1.configFactoryDefault();
    leftmotor1.set(ControlMode.PercentOutput, 0);
    leftmotor2.configFactoryDefault();
    leftmotor2.set(ControlMode.PercentOutput, 0);
    rightmotor1.configFactoryDefault();
    rightmotor1.set(ControlMode.PercentOutput, 0);
    rightmotor2.configFactoryDefault();
    rightmotor2.set(ControlMode.PercentOutput, 0);

    intakemotor.set(0);
    conveyor1.set(0);
    hangermotor.configFactoryDefault();
    hangermotor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void autonomousPeriodic() {
    double leftspeed = 0;
    double rightspeed = 0;
    double shooterspeed = 0;
    double conveyorspeed = 0;
    double ElapsedTime = my_timer.get();
    if(ElapsedTime < 3){
      leftspeed = -.3;
      rightspeed = .3;
    }

    if(ElapsedTime > 3){
      // shooterspeed = -.55;
      shooterspeed = SmartDashboard.getNumber("Set Speed", 0);
    }
    if (ElapsedTime > 4){
        conveyorspeed = -.3;
    }

    if(ElapsedTime > 8){
      shooterspeed = 0.0;
      conveyorspeed = 0.0;
    }
    
    if(ElapsedTime > 10){
      leftspeed = .3;
      rightspeed = -.3;
    }
   
    if(ElapsedTime > 13){
      leftspeed = 0;
      rightspeed = 0;
    }

    conveyor1.set(conveyorspeed);
    // shootermotor.set(shooterspeed);
    m_pidController.setReference(shooterspeed, ControlType.kVelocity);

    leftmotor1.set(ControlMode.PercentOutput, leftspeed);
    leftmotor2.set(ControlMode.PercentOutput, leftspeed);
    rightmotor1.set(ControlMode.PercentOutput, rightspeed);
    rightmotor2.set(ControlMode.PercentOutput, rightspeed);
    
  }
    

  @Override
  public void teleopInit() {
    leftmotor1.configFactoryDefault();
    leftmotor1.set(ControlMode.PercentOutput, 0);
    leftmotor2.configFactoryDefault();
    leftmotor2.set(ControlMode.PercentOutput, 0);
    rightmotor1.configFactoryDefault();
    rightmotor1.set(ControlMode.PercentOutput, 0);
    rightmotor2.configFactoryDefault();
    rightmotor2.set(ControlMode.PercentOutput, 0);

    intakemotor.set(0);
    conveyor1.set(0);
    hangermotor.configFactoryDefault();
    hangermotor.set(ControlMode.PercentOutput, 0);
  }
 
  @Override
  public void teleopPeriodic() {
    double leftspeed = controller1.getRawAxis(3)/3*2;
    double rightspeed = -controller1.getRawAxis(1)/3*2;

    double intakespeed = .0;
    double conveyorspeed = .0;
    int intakedirection = -1;
    boolean button_rb = controller2.getRawButton(6);
    boolean button_lb = controller2.getRawButton(5);
    int D_pad = controller2.getPOV(0);
    
    double shooterspeed = 0;
    double righttrigger = controller2.getRawAxis(3);
    boolean righttriggerpulled = righttrigger > 0.5;

    double hangerspeed = 0;
    double lefttrigger =controller2.getRawAxis(2);
    boolean lefttriggerpulled = lefttrigger > 0.5;

     // read PID coefficients from SmartDashboard
     double p = SmartDashboard.getNumber("P Gain", 0);
     double i = SmartDashboard.getNumber("I Gain", 0);
     double d = SmartDashboard.getNumber("D Gain", 0);
     double iz = SmartDashboard.getNumber("I Zone", 0);
     double ff = SmartDashboard.getNumber("Feed Forward", 0);
     double target = SmartDashboard.getNumber("Set Speed", 0);
 
     // if PID coefficients on SmartDashboard have changed, write new values to controller
     if((p != kP)) { m_pidController.setP(p); kP = p; }
     if((i != kI)) { m_pidController.setI(i); kI = i; }
     if((d != kD)) { m_pidController.setD(d); kD = d; }
     if((iz != kIz)) { m_pidController.setIZone(iz); kIz = iz; }
     if((ff != kFF)) { m_pidController.setFF(ff); kFF = ff; }


    leftmotor1.set(ControlMode.PercentOutput, leftspeed);
    leftmotor2.set(ControlMode.PercentOutput, leftspeed);
    rightmotor1.set(ControlMode.PercentOutput, rightspeed);
    rightmotor2.set(ControlMode.PercentOutput, rightspeed);

    if(button_lb){
      conveyorspeed = .35;
    }

    if(button_rb){
      intakespeed = .55;
    }

    if(D_pad == 0){
      intakedirection = -1;
    }

    if(D_pad == 180){
      intakedirection = 1;
    }

    if(righttriggerpulled){
      shooterspeed = target;
    }

    SmartDashboard.putNumber("SetPoint", shooterspeed);
    SmartDashboard.putNumber("motor 1 speed", m_encoder.getVelocity());
    SmartDashboard.putNumber("motor 2 speed", m2_encoder.getVelocity());


    if(lefttriggerpulled){
      hangerspeed = 1;
    }

    // set the direction for the motors
    intakespeed = intakespeed*intakedirection;
    conveyorspeed = conveyorspeed*intakedirection;
    hangerspeed = hangerspeed*intakedirection;

    intakemotor.set(intakespeed);
    conveyor1.set(conveyorspeed);
    // shootermotor.set(shooterspeed);
    m_pidController.setReference(shooterspeed, ControlType.kVelocity);
    hangermotor.set(ControlMode.PercentOutput, hangerspeed);


    double distance = ultrasonic.getValue();
    SmartDashboard.putNumber("wall_distance", distance);


  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
