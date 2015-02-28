/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDoNothing;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Transmission Subsystem
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class Transmission extends Subsystem {
	
	private final SpeedController motor = new VictorSP(RobotMap.TRANSMISSION_PAIR);
	private final DigitalInput maxHeightLimitSwitch = new DigitalInput(RobotMap.MAX_HEIGHT_LIMIT_SWITCH_PORT);
	private final DigitalInput minHeightLimitSwitch = new DigitalInput(RobotMap.MIN_HEIGHT_LIMIT_SWITCH_PORT);
	
	/**
	 * By default, when no buttons are pressed, we want the transmission to stop
	 */
    public void initDefaultCommand() {
        setDefaultCommand(new TransmissionDoNothing());
    }
    
    /**
     * Raises the arm
     */
    public void ascend() {
    	motor.set(1);
    }
    
    /**
     * Lowers the arm
     */
    public void descend() {
    	motor.set(-1);
    }
    
    /**
     * Stops the transmission motor
     */
    public void stop() {
    	motor.set(0);
    }
    
    /**
     * True if transmission is at max height
     */
    public boolean isMaxHeight() {
    	return !maxHeightLimitSwitch.get();
    }
    
    /**
     * True if transmission is at min height
     */
    public boolean isMinHeight() {
    	return !minHeightLimitSwitch.get();
    }
    
    /**
     * Prints data to smart dashboard
     */
    public void log() {
    	SmartDashboard.putBoolean("Transmission Max Height: ", !maxHeightLimitSwitch.get());
    	SmartDashboard.putBoolean("Transmission Min Height: ", !minHeightLimitSwitch.get());
    }
}

