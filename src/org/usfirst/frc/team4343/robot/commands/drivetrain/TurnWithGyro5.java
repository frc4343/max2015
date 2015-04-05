package org.usfirst.frc.team4343.robot.commands.drivetrain;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnWithGyro5 extends Command {
	private double angleToTurnTo, speed;
	private boolean stage1 = false, stage2 = false;
	private boolean resetGyro = false;
	
	/**
	 * Constructor to pass speed and angle to turn to
	 *  
	 * @param speed The speed of turn
	 * @param angleToTurnTo angle to turn to
	 */
    public TurnWithGyro5(double speed, double angleToTurnTo, boolean resetGyro) {
        requires(Robot.driveTrain);
        this.speed = Math.abs(speed); // SPEED NOT VELOCITY, NO NEED FOR DIRECTION
        this.angleToTurnTo = angleToTurnTo; // DIRECTION DETERMINED BY ANGLE VALUE
        this.resetGyro = resetGyro;
    }

    // Called just before this Command runs
    protected void initialize() {
    	if (resetGyro) { 
    		Robot.driveTrain.resetGyro();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (angleToTurnTo > 0 && !(Robot.driveTrain.getHeading() >= angleToTurnTo)) { // if angle is positive
        	Robot.driveTrain.fullSpeedDrive(0, -speed); // robot turns right 
        } else if (angleToTurnTo < 0 && !(Robot.driveTrain.getHeading() <= angleToTurnTo)){ // angle is negative
        	Robot.driveTrain.fullSpeedDrive(0, speed); // robot turns left
        } else { // when angle is achieved
        	Robot.driveTrain.fullSpeedDrive(0, 0); // full stop
        	stage1 = true;
        }
    	
    	if (stage1) {
    		if (angleToTurnTo > 0 && !(Robot.driveTrain.getHeading() >= angleToTurnTo)) { // if angle is positive
            	Robot.driveTrain.fullSpeedDrive(0, -0.5); // robot turns right 
            } else if (angleToTurnTo < 0 && !(Robot.driveTrain.getHeading() <= angleToTurnTo)){ // angle is negative
            	Robot.driveTrain.fullSpeedDrive(0, 0.5); // robot turns left
            } else { // when angle is achieved
            	Robot.driveTrain.fullSpeedDrive(0, 0); // full stop
            	stage2 = true;
            }
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stage2;
    }

    // Called once after isFinished returns true
    protected void end() {
    	stage1 = false;
    	stage2 = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
