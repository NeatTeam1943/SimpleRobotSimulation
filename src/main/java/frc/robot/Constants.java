// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants.
 */
public final class Constants {
    public static final class DrivetrainConstants {
        public static int kLeftMotor = 0;
        public static int kRightMotor = 1;

        public static int[] kLeftEncoder = { 0, 1 };
        public static int[] kRightEncoder = { 2, 3 };

        public static int kEncoderResolution = 2048;

        public static double kWheelRadius = .333333333;

        public static int kGyro = 0;
    }
}