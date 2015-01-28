/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class DriveTrain extends Subsystem {
	
    private final RobotDrive chassis = new RobotDrive(RobotMap.RIGHT_MOTOR_PAIR, RobotMap.LEFT_MOTOR_PAIR);
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    /**
     * Drive the robot using tank style
     * @param left How much power to apply to left motor pairs
     * @param right How much power to apply to right motor pairs
     */
    public void tankDrive(double left, double right) {
        chassis.tankDrive(left, right);
    }
    
    /**
     * Drive the robot using arcade style
     * @param x Forward and backwards speed
     * @param y Rotation speed 
     */
    public void arcadeDrive(double x, double y) {
        chassis.arcadeDrive(x, y);
    }
    
    /**
     * Disable motor safety, stops 'Robot drive not updated enough...' error
     * @param value Either true or false. 'True' to enable safety and 'False' to disable
     */
    public void toggleSafety(boolean value) {
        chassis.setSafetyEnabled(value);
    }
}

