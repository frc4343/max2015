package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    
    static final Solenoid left = new Solenoid(1,0);
    static final Solenoid right = new Solenoid(1,7);
    
    public void initDefaultCommand() {
        setDefaultCommand(new ClawClose());
    }
    
    public void open() {
    	left.set(false);
    	right.set(true);
    }
    
    public void close() {
    	right.set(false);
    	left.set(true);
    }
}

