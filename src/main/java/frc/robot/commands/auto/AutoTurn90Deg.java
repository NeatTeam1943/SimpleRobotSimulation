// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.Drivetrain;

/**
 * Autonomously turns the robot 90 degrees.
 */
public class AutoTurn90Deg extends CommandBase {

  private double m_originalHeading = .0;

  private final Drivetrain m_drivetrain;

  public AutoTurn90Deg(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
  }

  /**
   * Called when the command is initially scheduled.
   */
  @Override
  public void initialize() {
    m_originalHeading = m_drivetrain.getHeading();
  }

  /**
   * Called every time the scheduler runs while the command is scheduled.
   */
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(.0, AutoConstants.kAutoTurnPower);
  }

  /**
   * Called once the command ends or is interrupted.
   */
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
  }

  /**
   * Returns true when the command should end.
   */
  @Override
  public boolean isFinished() {
    return m_drivetrain.getHeading() > m_originalHeading + AutoConstants.kAutoTurnAngle;
  }
}
