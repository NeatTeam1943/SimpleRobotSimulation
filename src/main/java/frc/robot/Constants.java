// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants.
 */
public final class Constants {

    public static final class SimConstants {

        public static final double kDrivetrainSimUpdatePeriod = .02;
    }

    public static final class IOConstants {

        public static final int kJoystick = 0;
    }

    public static final class AutoConstants {

        public static final double kAutoTurnAngle = 90.;
        public static final double kAutoTurnPower = .3;

        public static final double kAutoTurnP = .1;
        public static final double kAutoTurnI = .1;
        public static final double kAutoTurnD = .0;

        public static final double kAutoDriveTime = 2.;
        public static final double kAutoDrivePower = .5;
    }

    public static final class DrivetrainConstants {

        public static final int kLeftMotor = 0;
        public static final int kRightMotor = 1;

        public static final int[] kLeftEncoder = { 0, 1 };
        public static final int[] kRightEncoder = { 2, 3 };

        public static final int kEncoderResolution = 2048;

        public static final double kWheelRadius = .333333333;

        public static final int kGyro = 0;

        public static final double kOdometryPoseX = 5.;
        public static final double kOdometryPoseY = 13.5;
    }
}