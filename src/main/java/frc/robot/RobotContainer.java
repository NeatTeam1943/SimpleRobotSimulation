// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.
 */
public class RobotContainer {

    private final SendableChooser<Command> m_autoChooser = new SendableChooser<>();

    /**
     * The container for the robot. Contains subsystems, IO devices, and commands.
     */
    public RobotContainer() {
        configureAutoChooser();
        configureButtonBindings();
        configureDefaultCommands();
    }

    /**
     * Use this method to configure a chooser for autonomous commands.
     * The chooser will be displayed on the dashboard.
     */
    private void configureAutoChooser() {
        SmartDashboard.putData("Auto", m_autoChooser);
    }

    /**
     * Use this method to define your button -> command mappings.
     */
    private void configureButtonBindings() {
    }

    /**
     * Use this method to configure default commands for subsystems.
     * For example an arcade drive command for the drivetrain that uses
     * a joystick to control the robot.
     */
    private void configureDefaultCommands() {
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     * 
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return m_autoChooser.getSelected();
    }
}