/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveFullSpeedWithJoystick;
import org.usfirst.frc.team4343.robot.commands.drivetrain.ArcadeTriggerDriveWithJoystick;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDescend;
import org.usfirst.frc.team4343.robot.joystick.AxisMap;
import org.usfirst.frc.team4343.robot.joystick.ButtonMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class OI {
    /**
     * This is where buttons are assigned a command
     */
    public OI() {
        // Xbox Controller 0 Buttons
    	ButtonMap.xbox0_Y.whileHeld(new TransmissionAscend());
    	ButtonMap.xbox0_A.whileHeld(new TransmissionDescend());
    	ButtonMap.xbox0_R1.whenPressed(new ClawClose());
    	ButtonMap.xbox0_L1.whenPressed(new ClawOpen());
    	
    	// Drive Commands
    	ButtonMap.xbox0_B.whileHeld(new DriveFullSpeedWithJoystick());
        ButtonMap.xbox0_B.whenReleased(new ArcadeTriggerDriveWithJoystick());
    	
    	// Xbox Controller 1 Buttons
    	ButtonMap.xbox1_R1.whenPressed(new ClawClose());
    	ButtonMap.xbox1_L1.whenPressed(new ClawOpen()); 
    	ButtonMap.xbox1_Y.whileHeld(new TransmissionAscend()); 
    	ButtonMap.xbox1_A.whileHeld(new TransmissionDescend()); 
    }
     
    /**
     * @return X axis on controller 0
     */
    public double getForwardBackwardDriveSpeedFromTriggers() {
        return ButtonMap.xbox0.getRawAxis(AxisMap.RIGHT_TRIGGER) - ButtonMap.xbox0.getRawAxis(AxisMap.LEFT_TRIGGER); // One trigger forward, other reverse
    }
    
    /**
     * @return Y axis on controller with joystick dead zone compensation
     */
    public double getLeftJoystickHorizontalAxis(Joystick controller) {
        return Math.abs(controller.getRawAxis(AxisMap.LEFT_ANALOG_STICK_X_AXIS)) >= 0.2 ? -controller.getRawAxis(AxisMap.LEFT_ANALOG_STICK_X_AXIS) : 0;
    }
    
    public double getRightJoystickHorizontalAxis(Joystick controller) { 
    	return Math.abs(controller.getRawAxis(AxisMap.RIGHT_ANALOG_STICK_X_AXIS)) >= 0.2 ? -controller.getRawAxis(AxisMap.RIGHT_ANALOG_STICK_X_AXIS) : 0; 
    }
    
    /**
     * Returns angle in degrees, -1 for centre position
     */
    public short getDPad() {
    	return (short) ButtonMap.xbox0.getPOV(AxisMap.DPAD);
    }
    
    public void setRumble(Joystick joystick, RumbleType type, boolean state) {
    	float value;
    	if (state) {
    		value = 1;
    	} else {
    		value = 0;
    	}
    	joystick.setRumble(type, value);
    }
}

