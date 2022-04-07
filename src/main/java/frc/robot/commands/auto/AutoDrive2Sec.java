// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.Drivetrain;

/**
 * Autonomously drives the robot for 2 seconds.
 */
public class AutoDrive2Sec extends CommandBase {

  private final Timer m_timer = new Timer();

  private final Drivetrain m_drivetrain;

  public AutoDrive2Sec(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
  }

  /**
   * Called when the command is initially scheduled.
   */
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  /**
   * Called every time the scheduler runs while the command is scheduled.
   */
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(AutoConstants.kAutoDrivePower, .0);
  }

  /**
   * Called once the command ends or is interrupted.
   */
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
    m_timer.stop();
  }

  /**
   * Returns true when the command should end.
   */
  @Override
  public boolean isFinished() {
    return m_timer.get() >= AutoConstants.kAutoDriveTime;
  }
}
