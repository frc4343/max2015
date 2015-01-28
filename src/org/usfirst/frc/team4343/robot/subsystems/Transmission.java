/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDoNothing;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Transmission Subsystem
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class Transmission extends Subsystem {
	
	private final SpeedController motor = new Victor(RobotMap.TRANSMISSION_PAIR);
	
	/**
	 * By default, when no buttons are pressed, we want the transmission to stop
	 */
    public void initDefaultCommand() {
        setDefaultCommand(new TransmissionDoNothing());
    }
    
    /**
     * Raise the arm
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
}

