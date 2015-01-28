package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDoNothing;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Transmission extends Subsystem {
	final private SpeedController motor = new Victor(RobotMap.TRANSMISSION_PAIR);
	
    public void initDefaultCommand() {
        setDefaultCommand(new TransmissionDoNothing());
    }
    
    public void stop() {
    	motor.set(0);
    }
    
    public void ascend() {
    	motor.set(1);
    }
    
    public void descend() {
    	motor.set(-1);
    }
}

