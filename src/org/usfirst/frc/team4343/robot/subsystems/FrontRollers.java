/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.drivetrain.RunRollersWithJoystick;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Brian Ho <www.4343.ca>
 * @author Maxim Romanoff <www.4343.ca>
 */
public class FrontRollers extends Subsystem {
	private final SpeedController leftRoller = new Talon(RobotMap.LEFT_ROLLER_PORT);
	private final SpeedController rightRoller = new Talon(RobotMap.RIGHT_ROLLER_PORT);
	
	/**
	 * By default Joystick 1 (Driver 2) is able to control front green wheels
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new RunRollersWithJoystick());
	}
	
	/**
	 * Sets the speed for the left roller
	 * @param speed from -1 to 1 (Reverse or forward at 100%)
	 */
	public void setLeftRoller(double speed) {
		leftRoller.set(-speed);
	}
	
	/**
	 * Sets the speed for the right roller
	 * @param speed from -1 to 1 (Reverse or forward at 100%)
	 */
	public void setRightRoller(double speed) {
		rightRoller.set(-speed);
	}
}
