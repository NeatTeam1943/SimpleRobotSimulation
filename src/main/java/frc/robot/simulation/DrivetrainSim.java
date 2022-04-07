package frc.robot.simulation;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.AnalogGyroSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import frc.robot.Constants.SimConstants;

/**
 * This class is a simulation of the drivetrain.
 * it handles all the necessary updates and simulation objects.
 */
public class DrivetrainSim {

    // Simulated encoders
    private final EncoderSim m_leftEncoderSim;
    private final EncoderSim m_rightEncoderSim;

    // Simulated gyro
    private final AnalogGyroSim m_gyroSim;

    // Simulated drivetrain
    private final DifferentialDrivetrainSim m_driveSim;

    public DrivetrainSim(
            Encoder leftEncoder,
            Encoder rightEncoder,
            AnalogGyro gyro,
            DifferentialDrivetrainSim driveSim) {
        m_leftEncoderSim = new EncoderSim(leftEncoder);
        m_rightEncoderSim = new EncoderSim(rightEncoder);
        m_gyroSim = new AnalogGyroSim(gyro);
        m_driveSim = driveSim;
    }

    /**
     * Updates the simulation.
     * 
     * @param leftMotorValue  Last PWM value sent to the left motor.
     * @param rightMotorValue Last PWM value sent to the right motor.
     */
    public void simulationPeriodic(double leftMotorValue, double rightMotorValue) {
        m_driveSim.setInputs(
                leftMotorValue * RobotController.getInputVoltage(),
                rightMotorValue * RobotController.getInputVoltage());

        m_driveSim.update(SimConstants.kDrivetrainSimUpdatePeriod);

        m_leftEncoderSim.setDistance(m_driveSim.getLeftPositionMeters());
        m_leftEncoderSim.setRate(m_driveSim.getLeftVelocityMetersPerSecond());

        m_rightEncoderSim.setDistance(m_driveSim.getRightPositionMeters());
        m_rightEncoderSim.setRate(m_driveSim.getRightVelocityMetersPerSecond());

        m_gyroSim.setAngle(-m_driveSim.getHeading().getDegrees());
    }
}
