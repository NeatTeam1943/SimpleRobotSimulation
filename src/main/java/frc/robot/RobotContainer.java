// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.IOConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.auto.AutoDrive2Sec;
import frc.robot.commands.auto.AutoTurn90Deg;
import frc.robot.commands.auto.AutoTurn90DegPID;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared.
 */
public class RobotContainer {

    private final Joystick m_stick = new Joystick(IOConstants.kJoystick);

    private final Drivetrain m_drivetrain = new Drivetrain();

    private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_stick, m_drivetrain);

    private final AutoDrive2Sec m_autoDrive2Sec = new AutoDrive2Sec(m_drivetrain);
    private final AutoTurn90Deg m_autoTurn90Deg = new AutoTurn90Deg(m_drivetrain);
    private final AutoTurn90DegPID m_autoTurn90DegPID = new AutoTurn90DegPID(m_drivetrain);

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
        m_autoChooser.setDefaultOption("Drive 2 Seconds", m_autoDrive2Sec);
        m_autoChooser.addOption("Turn 90 Degrees", m_autoTurn90Deg);
        m_autoChooser.addOption("Turn 90 Degrees PID", m_autoTurn90DegPID);

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
        m_drivetrain.setDefaultCommand(m_arcadeDrive);
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