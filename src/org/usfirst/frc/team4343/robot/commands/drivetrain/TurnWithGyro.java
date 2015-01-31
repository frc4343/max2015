package org.usfirst.frc.team4343.robot.commands.drivetrain;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Brian Ho <www.4343.ca>
 */
public class TurnWithGyro extends Command {
	private double angleToTurnTo;
	private boolean finished = false;
	private String turnRightOrLeftToReturnToZero;
	private double speed;

	public TurnWithGyro(double speed, double angle) {
		requires(Robot.gyro);
		requires(Robot.driveTrain);
		this.speed = speed;
		angleToTurnTo = angle;
	}
	
	public TurnWithGyro(double speed, String turnRightOrLeftToReturnToZero) {
		this(speed, 0);
		this.turnRightOrLeftToReturnToZero = turnRightOrLeftToReturnToZero;
	}

	// Called just before this Command runs the first time (robotInit)
	protected void initialize() {
		Robot.gyro.reset(); // zeros the gyro
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (angleToTurnTo < 0) { // if angle is negative
			if (Robot.gyro.getAngle() > angleToTurnTo) {
				Robot.driveTrain.tankDrive(-speed, 0);
			} else {
				Robot.driveTrain.tankDrive(0, 0);
				finished = true;
			}
		} else if (angleToTurnTo > 0) {
			if (Robot.gyro.getAngle() < angleToTurnTo) {
				Robot.driveTrain.tankDrive(0, -speed);
			} else {
				Robot.driveTrain.tankDrive(0, 0);
				finished = true;
			}
		} else { // return to ZERO
			if (turnRightOrLeftToReturnToZero.equalsIgnoreCase("LEFT")) {
				if (Robot.gyro.getAngle() > angleToTurnTo) {
					Robot.driveTrain.tankDrive(-speed, 0);
				} else {
					Robot.driveTrain.tankDrive(0, 0);
					finished = true;
				}
			} else { // RIGHT
				if (Robot.gyro.getAngle() < angleToTurnTo) {
					Robot.driveTrain.tankDrive(0, -speed);
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
		finished = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
