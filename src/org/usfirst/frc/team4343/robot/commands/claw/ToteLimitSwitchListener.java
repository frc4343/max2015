package org.usfirst.frc.team4343.robot.commands.claw;

import org.usfirst.frc.team4343.robot.Robot;
import org.usfirst.frc.team4343.robot.joystick.ButtonMap;

import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToteLimitSwitchListener extends Command {

    public ToteLimitSwitchListener() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.claw.isToteFullyInClaw()) {
    		Robot.oi.setRumble(ButtonMap.xbox0, RumbleType.kLeftRumble, true); // activate left rumble
    		Robot.oi.setRumble(ButtonMap.xbox0, RumbleType.kRightRumble, true); // activate right rumble
    	} else {
    		Robot.oi.setRumble(ButtonMap.xbox0, RumbleType.kLeftRumble, false); // deactivate left rumble
    		Robot.oi.setRumble(ButtonMap.xbox0, RumbleType.kRightRumble, false); // deactivate right rumble
    	}
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
