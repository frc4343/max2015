/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot;

import org.usfirst.frc.team4343.robot.commands.EncoderTest;
import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveFullSpeedWithJoystick;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveWithJoystick;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDescend;
import org.usfirst.frc.team4343.robot.joystick.AxisMap;
import org.usfirst.frc.team4343.robot.joystick.ButtonMap;

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
    	ButtonMap.xbox0_Y.whileHeld(new TransmissionAscend()); // changed whenPressed to whileHeld
    	ButtonMap.xbox0_A.whileHeld(new TransmissionDescend()); // change whenPressed to whileHeld
    	ButtonMap.xbox0_R1.whenPressed(new ClawClose()); // changed whileHeld to whenPressed
    	ButtonMap.xbox0_L1.whenPressed(new ClawOpen());  // changed whileHeld to whenPressed
    	
    	// Drive Commands
    	ButtonMap.xbox0_B.whileHeld(new DriveFullSpeedWithJoystick());
        ButtonMap.xbox0_B.whenReleased(new DriveWithJoystick());
    	
    	// Xbox Controller 1 Buttons
    	ButtonMap.xbox1_R1.whenPressed(new ClawClose()); // changed whileHeld to whenPressed
    	ButtonMap.xbox1_L1.whenPressed(new ClawOpen());  // changed whileHeld to whenPressed
    	ButtonMap.xbox1_Y.whileHeld(new TransmissionAscend()); // changed whenPressed to whileHeld
    	ButtonMap.xbox1_A.whileHeld(new TransmissionDescend()); // change whenPressed to whileHeld
    	//ButtonMap.xbox0_B.whenPressed(new EncoderTest());
    }


     
    /**
     * @return X axis on controller 
     */
    public double getDriveX() {
        return ButtonMap.xbox0.getRawAxis(AxisMap.RIGHT_TRIGGER) - ButtonMap.xbox0.getRawAxis(AxisMap.LEFT_TRIGGER); // One trigger forward, other reverse
    }
    
    /**
     * @return Y axis on controller with joystick dead zone compensation
     */
    public double getDriveY() {
        return Math.abs(ButtonMap.xbox0.getRawAxis(AxisMap.LEFT_ANALOG_STICK_X_AXIS)) >= 0.2 ? -ButtonMap.xbox0.getRawAxis(AxisMap.LEFT_ANALOG_STICK_X_AXIS) : 0;
    }
    
    public double getLeftJoystickX() {
    	return Math.abs(ButtonMap.xbox1.getRawAxis(AxisMap.LEFT_ANALOG_STICK_X_AXIS)) >= 0.2 ? -ButtonMap.xbox1.getRawAxis(AxisMap.LEFT_ANALOG_STICK_X_AXIS) : 0;
    }
    
    public double getRightJoystickX() {
    	return Math.abs(ButtonMap.xbox1.getRawAxis(AxisMap.RIGHT_ANALOG_STICK_X_AXIS)) >= 0.2 ? -ButtonMap.xbox1.getRawAxis(AxisMap.RIGHT_ANALOG_STICK_X_AXIS) : 0; 
    }
}

