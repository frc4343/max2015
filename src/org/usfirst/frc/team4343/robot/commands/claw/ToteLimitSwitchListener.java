/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.claw;

import org.usfirst.frc.team4343.robot.Robot;
import org.usfirst.frc.team4343.robot.joystick.ButtonMap;

import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Tote limitswitch command
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class ToteLimitSwitchListener extends Command {

	public ToteLimitSwitchListener() {
		requires(Robot.clawLimitSwitch);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.oi.setRumble(ButtonMap.xbox0, RumbleType.kLeftRumble, Robot.clawLimitSwitch.isToteFullyInClaw()); // shake!
		Robot.oi.setRumble(ButtonMap.xbox0, RumbleType.kRightRumble, Robot.clawLimitSwitch.isToteFullyInClaw()); // rumble!!
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
