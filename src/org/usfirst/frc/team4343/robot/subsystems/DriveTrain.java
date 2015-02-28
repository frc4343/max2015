/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.drivetrain.ArcadeTriggerDriveWithJoystick;
//import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveWithEncoders;



import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class DriveTrain extends Subsystem {
	private boolean isFirstEnable = true; // by default this is true (when robot first turns on or enables)
    
	private final RobotDrive chassis = new RobotDrive(RobotMap.RIGHT_MOTOR_PAIR, RobotMap.LEFT_MOTOR_PAIR);
	private final Gyro gyro = new Gyro(RobotMap.GYRO_SENSOR_PORT);
	private final Encoder chassisRightEncoder = new Encoder(0,1, true, EncodingType.k4X);
	private final Encoder chassisLeftEncoder = new Encoder(2,3, true, EncodingType.k4X);
	
    public void initDefaultCommand() {
    	if (isFirstEnable) { // if first enable
    		setDefaultCommand(new ArcadeTriggerDriveWithJoystick()); // by default set speed to slow drive
    		isFirstEnable = false; // set first enable to false so when loops again, above line will not be run
    	}
    }
    
    /**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getAverageDistance() {
		return (getLeftDistance() + getRightDistance())/2;
	}
    
	/**
	 * Gets Encoder reading on right side of drivetrain
	 * @return
	 */
	public double getRightDistance() {
		return -chassisRightEncoder.getDistance(); // has to be neg
	}
	
	/**
	 * Gets encoder reading on left side of drivetrain
	 * @return
	 */
	public double getLeftDistance() {
		return chassisLeftEncoder.getDistance();
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
     * Drive the robot using arcade style with half speed
     * @param x Forward and backwards speed
     * @param y Left, Right Rotation speed 
     */
    public void slowDrive(double x, double y) {
    	chassis.arcadeDrive(-x/1.5, y/1.3);
    }
    
    /**
     * This method resets the right and left encoder counts
     */
    public void resetEncoders() {
    	chassisLeftEncoder.reset();
		chassisRightEncoder.reset();
    }
    
    /**
     * This method resets the gyro, "zeroes" the gyro
     */
    public void resetGyro() {
    	gyro.reset();
    }
    
    /**
     * Drive the robot using arcade style with full speed
     * @param x Forward and backwards speed
     * @param y Left, Right Rotation speed 
     */
    public void fullSpeedDrive(double x, double y) {
    	chassis.arcadeDrive(-x, y);
    }
    
    /**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
		SmartDashboard.putNumber("Left Distance", chassisLeftEncoder.getDistance());
		SmartDashboard.putNumber("Right Distance", chassisRightEncoder.getDistance());
		
		SmartDashboard.putNumber("Left Speed", chassisLeftEncoder.getRate());
		SmartDashboard.putNumber("Right Speed", chassisRightEncoder.getRate());
		
		SmartDashboard.putNumber("Robot Heading", gyro.getAngle());
	}

	/**
	 * @return The angle of the robot (gyro)
	 */
	public double getHeading() {
		return gyro.getAngle();
	}
}

