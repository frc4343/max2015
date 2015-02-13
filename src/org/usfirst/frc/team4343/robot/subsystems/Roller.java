package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.RunRollersWithJoystick;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {
	private final SpeedController leftRoller = new Talon(RobotMap.LEFT_ROLLER_PORT);
	private final SpeedController rightRoller = new Talon(RobotMap.RIGHT_ROLLER_PORT);

	public void initDefaultCommand() {
		setDefaultCommand(new RunRollersWithJoystick());
	}
	
	public void setLeftRoller(double speed) {
		leftRoller.set(-speed);
	}
	
	public void setRightRoller(double speed) {
		rightRoller.set(-speed);
	}
}
