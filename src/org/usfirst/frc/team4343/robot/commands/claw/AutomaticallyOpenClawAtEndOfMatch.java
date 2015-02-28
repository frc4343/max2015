/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.claw;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Auto open claw command
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class AutomaticallyOpenClawAtEndOfMatch extends Command {

    public AutomaticallyOpenClawAtEndOfMatch() {
        requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (DriverStation.getInstance().getMatchTime() <= 0.5) {  // 0.5 secs of game left
    		Robot.claw.open(); // auto open
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // never!
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
