package org.usfirst.frc.team4343.robot.commands.drivetrain;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnWithGyro extends Command {
	private double angleToTurnTo;
	private boolean finished = false;

	public TurnWithGyro(double angle) {
		requires(Robot.gyro);
		requires(Robot.driveTrain);
		angleToTurnTo = angle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gyro.reset(); // zeros the gyro
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (angleToTurnTo < 0) {
			if (Robot.gyro.getAngle() > angleToTurnTo) { // if angle is positive
				Robot.driveTrain.tankDrive(-0.5, 0);
			} else {
				Robot.driveTrain.tankDrive(0, 0);
				finished = true;
			}
		} else {
			if (Robot.gyro.getAngle() < angleToTurnTo) {
				Robot.driveTrain.tankDrive(0, -0.5);
			} else {
				Robot.driveTrain.tankDrive(0, 0);
				finished = true;
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
