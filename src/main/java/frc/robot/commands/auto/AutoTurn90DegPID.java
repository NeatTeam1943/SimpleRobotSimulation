// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.Drivetrain;

/**
 * Autonomously turns the robot 90 degrees with a PID controller.
 */
public class AutoTurn90DegPID extends PIDCommand {

  private final Drivetrain m_drivetrain;

  public AutoTurn90DegPID(Drivetrain drivetrain) {
    super(
        // The controller that the command will use
        new PIDController(
            AutoConstants.kAutoTurnP,
            AutoConstants.kAutoTurnI,
            AutoConstants.kAutoTurnD),
        // This should return the measurement
        () -> drivetrain.getHeading(),
        // Return fake setpoint (Real one set in {@link #initialize()})
        () -> 0,
        // This uses the output
        output -> {
          drivetrain.arcadeDrive(.0, output);
        });

    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
  }

  /**
   * Initialize the command.
   */
  @Override
  public void initialize() {
    super.initialize();
    double setpoint = m_drivetrain.getHeading() + AutoConstants.kAutoTurnAngle;
    m_setpoint = () -> setpoint;
  }

  /**
   * Returns true when the command should end.
   */
  @Override
  public boolean isFinished() {
    return m_controller.atSetpoint();
  }
}
