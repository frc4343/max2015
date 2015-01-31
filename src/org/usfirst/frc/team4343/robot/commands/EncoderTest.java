package org.usfirst.frc.team4343.robot.commands;

import org.usfirst.frc.team4343.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderTest extends Command {
	
    public EncoderTest() {
        requires(Robot.encoderTest);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.encoderTest.getEncoder().reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.encoderTest.getMotor().set(1);
    	System.out.println("COUNT: " +Robot.encoderTest.getEncoder().get() + "\n DISTANCE: " + Robot.encoderTest.getEncoder().getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.encoderTest.getEncoder().get() >= 1295;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.encoderTest.getMotor().set(0);
    	Robot.encoderTest.getEncoder().reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
