// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

/**
 * Represents the drivetrain of the robot.
 */
public class Drivetrain extends SubsystemBase {

    // Drivetrain left and right side motors
    private final PWMSparkMax m_leftMotor = new PWMSparkMax(DrivetrainConstants.kLeftMotor);
    private final PWMSparkMax m_rightMotor = new PWMSparkMax(DrivetrainConstants.kRightMotor);

    // Drivetrain encoders
    private final Encoder m_leftEncoder = new Encoder(
            DrivetrainConstants.kLeftEncoder[0],
            DrivetrainConstants.kLeftEncoder[1]);
    private final Encoder m_rightEncoder = new Encoder(
            DrivetrainConstants.kRightEncoder[0],
            DrivetrainConstants.kRightEncoder[1]);

    // Drivetrain gyro
    private final AnalogGyro m_gyro = new AnalogGyro(DrivetrainConstants.kGyro);

    // Drivetrain differential drive
    private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    // Drivetrain odometry
    private final DifferentialDriveOdometry m_odometry = new DifferentialDriveOdometry(
            m_gyro.getRotation2d(),
            new Pose2d(DrivetrainConstants.kOdometryPoseX, DrivetrainConstants.kOdometryPoseY, new Rotation2d()));

    public Drivetrain() {
        // Set encoder units per revolution
        m_leftEncoder.setDistancePerPulse(
                2 * Math.PI * DrivetrainConstants.kWheelRadius / DrivetrainConstants.kEncoderResolution);
        m_rightEncoder.setDistancePerPulse(
                2 * Math.PI * DrivetrainConstants.kWheelRadius / DrivetrainConstants.kEncoderResolution);
    }

    /**
     * Get the heading of the robot from the gyro.
     * 
     * @return Heading in degrees
     */
    public double getHeading() {
        return m_gyro.getAngle();
    }

    /**
     * Drive the robot using arcade drive.
     * 
     * @param xSpeed       Straight speed
     * @param zRotation    Rotation speed
     * @param squareInputs Square inputs
     */
    public void arcadeDrive(double xSpeed, double zRotation, boolean squareInputs) {
        m_robotDrive.arcadeDrive(xSpeed, zRotation, squareInputs);
    }

    /**
     * Drive the robot using arcade drive with squared inputs.
     * 
     * @param xSpeed    Straight speed
     * @param zRotation Rotation speed
     */
    public void arcadeDrive(double xSpeed, double zRotation) {
        arcadeDrive(xSpeed, zRotation, true);
    }

    /**
     * Stop the robot.
     */
    public void stop() {
        m_robotDrive.stopMotor();
    }

    /**
     * Update drivetrain odometry.
     */
    @Override
    public void periodic() {
        m_odometry.update(m_gyro.getRotation2d(), m_leftEncoder.getDistance(), m_rightEncoder.getDistance());
    }
}