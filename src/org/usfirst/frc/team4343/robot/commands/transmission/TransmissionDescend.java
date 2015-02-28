/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.transmission;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Transmission Descend Command
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class TransmissionDescend extends Command {
	private boolean done = false;
	
    public TransmissionDescend() {
        requires(Robot.transmission);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!Robot.transmission.isMinHeight()) {
    		Robot.transmission.descend();
    	} else {
    		Robot.transmission.stop();
    		done = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.transmission.isMinHeight() || done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.transmission.stop();
    	done = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	if (DriverStation.getInstance().isOperatorControl()) {
    		done = false;
    	} else {
    		end();
    	}
    }
}
