/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot;

import org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins.DriveForward;
import org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins.OneReverse;
import org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins.OneTwoReverse;
import org.usfirst.frc.team4343.robot.joystick.ButtonMap;
import org.usfirst.frc.team4343.robot.subsystems.Claw;
import org.usfirst.frc.team4343.robot.subsystems.ClawLimitSwitch;
import org.usfirst.frc.team4343.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4343.robot.subsystems.FrontRollers;
import org.usfirst.frc.team4343.robot.subsystems.Lights;
import org.usfirst.frc.team4343.robot.subsystems.Transmission;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
	
	// Declare and Initialize Subsystems
	public static DriveTrain driveTrain = new DriveTrain();
	public static Transmission transmission = new Transmission();
	public static Claw claw = new Claw();
	public static ClawLimitSwitch clawLimitSwitch = new ClawLimitSwitch();
	public static Lights lights = new Lights();
	public static FrontRollers roller = new FrontRollers();

	public static OI oi;

	private Command autonomousCommand;
	private byte autoChooser = 0; // by default drive forward 

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
	}

	/**
	 * Anything that does not involve motors, pneumatic solenoids, etc will run in disabled mode
	 */
	public void disabledPeriodic() {
		Scheduler.getInstance().run(); // this needs to be here for command base
		
		String autoMode = "NO AUTO SELECTED"; // default initialization value
		
		if (ButtonMap.xbox1.getRawButton(1)) // button a
			autoChooser = 1;
		if (ButtonMap.xbox1.getRawButton(2)) // button b
			autoChooser = 2;
		if (ButtonMap.xbox1.getRawButton(2)) // button x
			autoChooser = 0;
		
		switch (autoChooser) {
			case 1:
				autoMode = "1 Reverse";
				break;
			case 2:
				autoMode = "1->2 Reverse";
				break;
			default: // 0
				autoMode = "Drive Forward";
				break;
		}
		SmartDashboard.putString("Auto Mode", autoMode);
	}

	public void autonomousInit() {
		// Autonomous Chooser based on joystick 1
		switch (autoChooser) {
			case 1:
				autonomousCommand = new OneReverse();
				break;
			case 2:
				autonomousCommand = new OneTwoReverse();
				break;
			default: // 0
				autonomousCommand = new DriveForward();
				break;
		}
		autonomousCommand.start(); // start autonomous
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		oi.setRumble(ButtonMap.xbox0, RumbleType.kLeftRumble, false); // turn off rumble
		oi.setRumble(ButtonMap.xbox0, RumbleType.kRightRumble, false); // turn off rumble
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
        //transmission.log();
        driveTrain.log();
        //claw.log();
    }
}
