/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.drivetrain;

import org.usfirst.frc.team4343.robot.Robot;
import org.usfirst.frc.team4343.robot.joystick.ButtonMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class ArcadeTriggerDriveWithJoystick extends Command {
	public ArcadeTriggerDriveWithJoystick() {
		requires(Robot.driveTrain);
	}

	/**
	 * Called just before this Command runs the first time
	 */
	protected void initialize() {
	}

	/**
	 * Gets x and y values from oi and passes values into arcadeDrive method to
	 * drive robot
	 */
	protected void execute() {
		Robot.driveTrain.slowDrive(Robot.oi.getForwardBackwardDriveSpeedFromTriggers(), Robot.oi.getLeftJoystickHorizontalAxis(ButtonMap.xbox0));
	}

	/**
	 * Never stops the command to drive
	 * 
	 * @return False, ALWAYS
	 */
	protected boolean isFinished() {
		return false;
	}

	/**
	 * Called once after isFinished returns true
	 */
	protected void end() {
	}

	/**
	 * Called when another command which requires one or more of the same
	 * subsystems is scheduled to run
	 */
	protected void interrupted() {
	}
}