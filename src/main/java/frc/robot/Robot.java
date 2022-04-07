// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * Entry point for the robot program.
 * Holds the central functions representing different state of the robot's life.
 * 
 * Period -> A 20 millisecond timespan
 * Periodic -> Repeats every 20 milliseconds
 */
public class Robot extends TimedRobot {

    private Command m_autonomousCommand;
    private RobotContainer m_robotContainer;

    /**
     * Runs when the robot is powered up. Used for initializations.
     */
    @Override
    public void robotInit() {
        m_robotContainer = new RobotContainer();
    }

    /**
     * Runs every period no matter the robot state (Enable, Disable, Teleop...)
     */
    @Override
    public void robotPeriodic() {
        // The command scheduler is responsible for updating commands, running commands
        // and registering new commands we want to run. By calling it's run method
        // we tell it to perform the tasks described above.
        CommandScheduler.getInstance().run();
    }

    /**
     * This function runs once each time the robot enters autonomous mode.
     */
    @Override
    public void autonomousInit() {
        m_autonomousCommand = m_robotContainer.getAutonomousCommand();

        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    /**
     * This function is called once each time the robot enters teleoperated mode.
     */
    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when teleop starts running.
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
            m_autonomousCommand = null;
        }
    }

    /**
     * This function is called periodically during teleoperated mode.
     */
    @Override
    public void teleopPeriodic() {
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}