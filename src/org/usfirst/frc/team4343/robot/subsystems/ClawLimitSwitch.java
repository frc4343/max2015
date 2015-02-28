/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.claw.ToteLimitSwitchListener;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Claw Limit Switch Subsystem
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class ClawLimitSwitch extends Subsystem {
    
    private final DigitalInput toteFullyInClawLimitSwitch = new DigitalInput(RobotMap.TOTE_FULLY_IN_CLAW_LIMIT_SWITCH_PORT);
	
    /**
     * By default, wait for limit switch to be held
     */
    public void initDefaultCommand() {
         setDefaultCommand(new ToteLimitSwitchListener());
    }
    
    /**
     * Returns true if limit switch on claw is held
     * @return True if tote limit switch is held
     */
    public boolean isToteFullyInClaw() {
    	return !toteFullyInClawLimitSwitch.get();
    }
}

