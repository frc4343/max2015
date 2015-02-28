/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot;

import org.usfirst.frc.team4343.robot.commands.TestingG2;
import org.usfirst.frc.team4343.robot.commands.autonomous.Alt;
import org.usfirst.frc.team4343.robot.commands.autonomous.Auto;
import org.usfirst.frc.team4343.robot.commands.autonomous.FasterAuto;
import org.usfirst.frc.team4343.robot.commands.autonomous.Middle;
import org.usfirst.frc.team4343.robot.commands.autonomous.OneContainerOneTote;
import org.usfirst.frc.team4343.robot.commands.autonomous.PickUpAllTotes;
import org.usfirst.frc.team4343.robot.commands.autonomous.TurnAndGo;
import org.usfirst.frc.team4343.robot.commands.autonomous.TwoContainerOneTote;
import org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins.DriveForward;
import org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins.OneReverse;
import org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins.OneTwoReverse;
import org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins.TwoOneReverse;
import org.usfirst.frc.team4343.robot.subsystems.CameraFeeds;
import org.usfirst.frc.team4343.robot.subsystems.Claw;
import org.usfirst.frc.team4343.robot.subsystems.ClawLimitSwitch;
import org.usfirst.frc.team4343.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4343.robot.subsystems.FrontRollers;
import org.usfirst.frc.team4343.robot.subsystems.Lights;
import org.usfirst.frc.team4343.robot.subsystems.Transmission;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static FrontRollers roller;
	public static ClawLimitSwitch clawLimitSwitch;
	public static CameraFeeds cameraFeed;
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
		roller = new FrontRollers();
		clawLimitSwitch = new ClawLimitSwitch();
		cameraFeed = new CameraFeeds();
		oi = new OI();

		// instantiate the command used for the autonomous period
		autonomousChooser = new SendableChooser();
		
		autonomousChooser.addObject("Slow Auto", new Auto());
		autonomousChooser.addObject("Fast Auto", new FasterAuto());
		autonomousChooser.addObject("Turn and Go (1 Container and 1 Tote)", new TurnAndGo());
		autonomousChooser.addObject("Start Centre Behind Totes", new Middle());
		autonomousChooser.addObject("ALT", new Alt());
		autonomousChooser.addObject("1 Conteiner 1 tote", new OneContainerOneTote());
		autonomousChooser.addObject("2 Conteiner 1 tote", new TwoContainerOneTote());
		autonomousChooser.addObject("TEST2", new TestingG2());
		autonomousChooser.addObject("3 tote stack", new PickUpAllTotes());
		//autonomousChooser.addDefault("ENCODER TEST", new DriveTest());
		
		// WORKING AUTONOMOUS MODES
		autonomousChooser.addObject("Drive Forward Only", new DriveForward());
		autonomousChooser.addDefault("1 Reverse", new OneReverse());
		autonomousChooser.addObject("1+2 (Reverse)", new OneTwoReverse());
		autonomousChooser.addObject("2+1 (Reverse)", new TwoOneReverse());
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
		log();
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
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
    private void log() {
        transmission.log();
        driveTrain.log();
        claw.log();
    }
}
