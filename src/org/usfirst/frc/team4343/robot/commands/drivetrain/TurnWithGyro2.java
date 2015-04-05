package org.usfirst.frc.team4343.robot.commands.drivetrain;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnWithGyro2 extends Command {
	private double toleranceInDegrees, angleToTurnTo, speed;
	private boolean isAngleToTurnToReached = false;
	private boolean resetGyro = false;
	
	/**
	 * Constructor to pass speed and angle to turn to
	 *  
	 * @param speed The speed of turn
	 * @param angleToTurnTo angle to turn to
	 */
    public TurnWithGyro2(double speed, double angleToTurnTo, boolean resetGyro) {
        requires(Robot.driveTrain);
        this.speed = Math.abs(speed); // SPEED NOT VELOCITY, NO NEED FOR DIRECTION
        this.angleToTurnTo = angleToTurnTo; // DIRECTION DETERMINED BY ANGLE VALUE
        this.resetGyro = resetGyro;
        this.toleranceInDegrees = 1;
    }
    
    public TurnWithGyro2(double speed, double angleToTurnTo, boolean resetGyro, double toleranceInDegrees) {
        this(speed, angleToTurnTo, resetGyro);
        this.toleranceInDegrees = toleranceInDegrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (resetGyro) { 
    		Robot.driveTrain.resetGyro();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!((Robot.driveTrain.getHeading() >= (angleToTurnTo - toleranceInDegrees)) && (Robot.driveTrain.getHeading() <= (angleToTurnTo + toleranceInDegrees)))) {
    		if (angleToTurnTo > 0) { // if angle is positive
        		Robot.driveTrain.fullSpeedDrive(0, -speed); // robot turns right 
        	} else { // angle is negative
        		Robot.driveTrain.fullSpeedDrive(0, speed); // robot turns left
        	}
    	} else { // when angle is achieved
    		System.out.println("ANGLE ACHIEVED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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
