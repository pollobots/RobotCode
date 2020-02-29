/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        // main drive motors (VictorSPX)
        public static final int kLeftMotor1Port = 0;
        public static final int kLeftMotor2Port = 1;
        public static final int kRightMotor1Port = 2;   
        public static final int kRightMotor2Port = 3;
        public static final double kDriveLimiter = 3;
    }
    public static final class ShooterConstants {
        // main shooter motors (SparkMAX)
        public static final int kShooterMotorPort = 4;
        public static final int kShooterFollowerPort = 5;
        // shooter PID controller constants
        public static final double kP = 6e-5; 
        public static final double kI = 0;
        public static final double kD = 0; 
        public static final double kIz = 0; 
        public static final double kFF = 0.000175; 
        public static final double kMaxOutput = -3000; 
        public static final double kMaxRPM = 5700;
        public static final double kWallDistance = 0;
        // shooter speeds
        public static final double kShootRPM = -3000;
        public static final double kShooterthreshold = 300;
    }
    public static final class ConveyorConstants {

    }
    public static final class IntakeConstants {

    }
    public static final class HangerConstants {

    }
    public static final class JoystickConstants {
        // controller ports
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
        // driver controller axes and buttons
        public static final int kDriverLeftStickAxis = 3;
        public static final int kDriverRightStickAxis = 1;
        public static final int kDriverScaleFactor = 3/2; // amount to DIVIDE joystick value by
                                                            // the larger the factor, the slower the robot
        // operator controller axes and buttons
    }
}
