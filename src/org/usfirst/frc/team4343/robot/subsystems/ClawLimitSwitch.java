package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.claw.ToteLimitSwitchListener;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawLimitSwitch extends Subsystem {
    
    private final DigitalInput toteFullyInClawLimitSwitch = new DigitalInput(RobotMap.TOTE_FULLY_IN_CLAW_LIMIT_SWITCH_PORT);
	
    public void initDefaultCommand() {
         setDefaultCommand(new ToteLimitSwitchListener());
    }
    
    /**
     * 
     * @return True if tote limit switch is hit
     */
    public boolean isToteFullyInClaw() {
    	return !toteFullyInClawLimitSwitch.get();
    }
}

