/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.drivetrain.ArcadeTriggerDriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class DriveTrain extends Subsystem {
	private boolean isFirstEnable = true; // by default this is true (when robot first turns on or enables)
    private final RobotDrive chassis = new RobotDrive(RobotMap.RIGHT_MOTOR_PAIR, RobotMap.LEFT_MOTOR_PAIR);
    
    public void initDefaultCommand() {
    	if (isFirstEnable) {
    		setDefaultCommand(new ArcadeTriggerDriveWithJoystick());
    		isFirstEnable = false;
    	}
    }
    
    /**
     * Drive the robot using tank style
     * @param left How much power to apply to left motor pairs
     * @param right How much power to apply to right motor pairs
     */
    public void tankDrive(double left, double right) {
        chassis.tankDrive(-left, -right);
    }
    
    /**
     * Drive the robot using arcade style with half speed
     * @param x Forward and backwards speed
     * @param y Left, Right Rotation speed 
     */
    public void slowDrive(double x, double y) {
    	chassis.arcadeDrive(-x/2, y/2);
    	//chassis.arcadeDrive(-(x)/1.7, (y)/1.7);        
        //chassis.arcadeDrive(-(x*x*x)/2, (y*y*y)/2);
    	//chassis.arcadeDrive(-x, y);
    }
    
    /**
     * Drive the robot using arcade style with full speed
     * @param x Forward and backwards speed
     * @param y Left, Right Rotation speed 
     */
    public void fullSpeedDrive(double x, double y) {
    	chassis.arcadeDrive(-x, y);
    }
}

