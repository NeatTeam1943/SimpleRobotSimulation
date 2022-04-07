// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/**
 * Drive the robot using arcade drive. Default command for the drivetrain.
 */
public class ArcadeDrive extends CommandBase {

  private final Joystick m_stick;
  private final Drivetrain m_drivetrain;

  public ArcadeDrive(Joystick stick, Drivetrain drivetrain) {
    m_stick = stick;
    m_drivetrain = drivetrain;

    addRequirements(m_drivetrain);
  }

  /**
   * Called when the command is initially scheduled.
   */
  @Override
  public void initialize() {
  }

  /**
   * Called every time the scheduler runs while the command is scheduled.
   */
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(-m_stick.getY(), m_stick.getX());
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
    return false;
  }
}
