package org.usfirst.frc.team4343.robot.commands.drivetrain;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnWithGyro2 extends Command {
	private double toleranceInDegrees = 1, angleToTurnTo, speed;
	private boolean isAngleToTurnToReached = false;
	private String leftRight;
	
	public TurnWithGyro2(double speed, double angleToTurnTo, String leftRight) {
        this.speed = Math.abs(speed); // SPEED NOT VELOCITY, NO NEED FOR DIRECTION
        this.angleToTurnTo = angleToTurnTo;
		this.leftRight = leftRight;
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!((Robot.driveTrain.getHeading() >= (angleToTurnTo - toleranceInDegrees)) && (Robot.driveTrain.getHeading() <= (angleToTurnTo + toleranceInDegrees)))) {
    		if (leftRight.equalsIgnoreCase("RIGHT")) {
        		Robot.driveTrain.fullSpeedDrive(0, -speed); // robot turns right 
        	} else {
        		Robot.driveTrain.fullSpeedDrive(0, speed); // robot turns left
        	}
    	} else { // when angle is achieved
    		Robot.driveTrain.fullSpeedDrive(0, 0); // full stop
    		isAngleToTurnToReached = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isAngleToTurnToReached;
    }

    // Called once after isFinished returns true
    protected void end() {
    	isAngleToTurnToReached = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
