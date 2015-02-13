package org.usfirst.frc.team4343.robot.commands;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunRollersWithJoystick extends Command {

    public RunRollersWithJoystick() {
        requires(Robot.roller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.roller.setLeftRoller(Robot.oi.getLeftJoystickX());
    	Robot.roller.setRightRoller(Robot.oi.getRightJoystickX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
