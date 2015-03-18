package org.usfirst.frc.team4343.robot.commands.encoder;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnWithEncoder extends Command {
	private boolean finished;
	private double speed, distance;
	private String whichSideToTurn;

	public TurnWithEncoder(double speed, double distance, String whichSideToTurn) {
		requires(Robot.driveTrain);
		this.speed = speed;
		this.distance = distance;
		this.whichSideToTurn = whichSideToTurn;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.resetEncoders();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!finished) {
		 if (whichSideToTurn.equalsIgnoreCase("RIGHT")) { // turn right 
			 if (Robot.driveTrain.getLeftDistance() < distance) { 
				 Robot.driveTrain.tankDrive(speed, -speed); 
			 } else {
				 Robot.driveTrain.tankDrive(0, 0);
				 finished = true; 
			 }
		 } else { // LEFT
			if (Robot.driveTrain.getRightDistance() < distance) {
				Robot.driveTrain.tankDrive(-speed, speed);
			} else {
				Robot.driveTrain.tankDrive(0, 0);
				finished = true;
			}
		 }
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
		//Robot.driveTrain.resetEncoders(); // this may be reason of causing problems
		finished = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
