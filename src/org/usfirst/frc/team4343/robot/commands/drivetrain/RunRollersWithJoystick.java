/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.drivetrain;

import org.usfirst.frc.team4343.robot.Robot;
import org.usfirst.frc.team4343.robot.joystick.ButtonMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Brian Ho <www.4343.ca>
 * @author Maxim Romanoff <www.4343.ca>
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
    	Robot.roller.setLeftRoller(Robot.oi.getLeftJoystickHorizontalAxis(ButtonMap.xbox1));
    	Robot.roller.setRightRoller(Robot.oi.getRightJoystickHorizontalAxis(ButtonMap.xbox1));
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
