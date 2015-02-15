/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team4343.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4343.robot.Robot;

/**
 * Drive the given distance straight (negative values go backwards).
 * Uses a local PID controller to run a simple PID loop that is only
 * enabled while this command is running. The input is the averaged
 * values of the left and right encoders. 
 */
public class DriveStraightToDistance extends Command {
    private double distance;
	private boolean finished;
    
    public DriveStraightToDistance(double distance) {
        requires(Robot.driveTrain);
        this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.driveTrain.getAverageDistance() < distance) {
    		Robot.driveTrain.fullSpeedDrive(0.5, 0);
    	} else {
    		finished = true;
    		Robot.driveTrain.tankDrive(0, 0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        finished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
