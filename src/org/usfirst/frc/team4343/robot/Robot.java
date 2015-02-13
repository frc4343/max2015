/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4343.robot.commands.autonomous.Alt;
import org.usfirst.frc.team4343.robot.commands.autonomous.Auto;
import org.usfirst.frc.team4343.robot.commands.autonomous.Middle;
import org.usfirst.frc.team4343.robot.commands.autonomous.ReverseWithContainer;
import org.usfirst.frc.team4343.robot.commands.autonomous.TurnAndGo;
import org.usfirst.frc.team4343.robot.commands.autonomous.FasterAuto;
import org.usfirst.frc.team4343.robot.subsystems.Claw;
import org.usfirst.frc.team4343.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4343.robot.subsystems.EncoderTest;
import org.usfirst.frc.team4343.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team4343.robot.subsystems.Lights;
import org.usfirst.frc.team4343.robot.subsystems.FrontRollers;
import org.usfirst.frc.team4343.robot.subsystems.Transmission;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static Transmission transmission;
	public static Claw claw;
	public static Lights lights;
	public static EncoderTest encoderTest;
	public static GyroSubsystem gyro;
	public static FrontRollers roller;

	public static OI oi;

	Command autonomousCommand;
	SendableChooser autonomousChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// Initialize Subsystems
		driveTrain = new DriveTrain();
		transmission = new Transmission();
		claw = new Claw();
		lights = new Lights();
		encoderTest = new EncoderTest();
		gyro = new GyroSubsystem();
		roller = new FrontRollers();
		oi = new OI();
		// instantiate the command used for the autonomous period
		autonomousChooser = new SendableChooser();
		autonomousChooser.addDefault("Slow Auto", new Auto());
		autonomousChooser.addObject("Fast Auto", new FasterAuto());
		autonomousChooser.addObject("Turn and Go (1 Container and 1 Tote)", new TurnAndGo());
		autonomousChooser.addObject("Reverse with Container (Any Position)",new ReverseWithContainer());
		autonomousChooser.addObject("Start Centre Behind Totes", new Middle());
		autonomousChooser.addObject("ALT", new Alt());
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) autonomousChooser.getSelected();
		autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
