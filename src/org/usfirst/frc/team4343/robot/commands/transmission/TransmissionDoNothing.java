/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.transmission;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4343.robot.Robot;

/**
 * Transmission Do Nothing Command
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class TransmissionDoNothing extends Command {

    public TransmissionDoNothing() {
        requires(Robot.transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.transmission.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
