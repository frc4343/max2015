/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;
import org.usfirst.frc.team4343.robot.commands.claw.ToteLimitSwitchListener;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Pneumatic Claw Subsystem
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class Claw extends Subsystem {

	private final DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.PCM_CANID, RobotMap.LEFT_SOLENOID_PORT, RobotMap.RIGHT_SOLENOID_PORT);
    private final DigitalInput toteFullyInClawLimitSwitch = new DigitalInput(RobotMap.TOTE_FULLY_IN_CLAW_LIMIT_SWITCH_PORT);
    
    public void initDefaultCommand() {
        setDefaultCommand(new ToteLimitSwitchListener());
    }
    
    /**
     * Opens the claw by retracting pistons
     */
    public void open() {
    	solenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    /**
     * Closes the claw by extending pistons
     */
    public void close() {
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    /**
     * 
     * @return True if tote limit switch is hit
     */
    public boolean isToteFullyInClaw() {
    	return toteFullyInClawLimitSwitch.get();
    }
}

