/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Pneumatic Claw Subsystem
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class Claw extends Subsystem {
    
    private final Solenoid left = new Solenoid(1,0);
    private final Solenoid right = new Solenoid(1,7);
    
    public void initDefaultCommand() {
        setDefaultCommand(new ClawClose());
    }
    
    /**
     * Opens the claw by retracting pistons
     */
    public void open() {
    	left.set(false);
    	right.set(true);
    }
    
    /**
     * Closes the claw by extending pistons
     */
    public void close() {
    	right.set(false);
    	left.set(true);
    }
}

