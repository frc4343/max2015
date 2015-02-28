/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.camera;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Update front camera command
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class UpdateFrontCamera extends Command {

    public UpdateFrontCamera() {
        requires(Robot.cameraFeed);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cameraFeed.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cameraFeed.updateCam();
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
