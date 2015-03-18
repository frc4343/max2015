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

	public void initDefaultCommand() {
		//setDefaultCommand(new RunRollersWithJoystick());
	}
	
	public void setLeftRoller(double speed) {
		leftRoller.set(-speed);
	}
	
	public void setRightRoller(double speed) {
		rightRoller.set(-speed);
	}
}
