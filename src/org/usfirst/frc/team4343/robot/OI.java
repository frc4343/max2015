/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team4343.robot.commands.lights.Blue;
import org.usfirst.frc.team4343.robot.commands.lights.Green;
import org.usfirst.frc.team4343.robot.commands.lights.Red;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDescend;
import org.usfirst.frc.team4343.robot.controls.AxisMap;
import org.usfirst.frc.team4343.robot.controls.ButtonMap;

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
        // Xbox Controller 1 Buttons
    	//ButtonMap.xbox0_Y.whileHeld(new TransmissionAscend());
    	//ButtonMap.xbox0_A.whileHeld(new TransmissionDescend());
    	ButtonMap.xbox0_R1.whileHeld(new ClawClose());
    	ButtonMap.xbox0_L1.whileHeld(new ClawOpen());
    	ButtonMap.xbox0_X.whenPressed(new Blue());
    	ButtonMap.xbox0_B.whenPressed(new Red());
    	ButtonMap.xbox0_A.whenPressed(new Green());
        /*ButtonMappings.xbox1_B.toggleWhenPressed(new ExpelBall());
        ButtonMappings.xbox1_Y.toggleWhenPressed(new PickupBallSequence());
        ButtonMappings.xbox1_A.whenPressed(new FireAndReloadSequence());
        ButtonMappings.xbox1_X.whenPressed(new TransmissionDoNothing());
        ButtonMappings.xbox1_R1.whenPressed(new FireSequence());
        ButtonMappings.xbox1_L1.whenPressed(new PullDownLauncherSequence());
        ButtonMappings.xbox1_START.whileHeld(new VisionTest());
        
        // Xbox Controller 2 Buttons
        ButtonMappings.xbox2_X.whenPressed(new TransmissionDoNothing());
        ButtonMappings.xbox2_A.whenPressed(new FireSequence()); //
        ButtonMappings.xbox2_B.whenPressed(new PullDownLauncherSequence());
        ButtonMappings.xbox2_R1.whenPressed(new ExtendArm());
        ButtonMappings.xbox2_L1.whenPressed(new RetractArm());
        ButtonMappings.xbox2_START.whileHeld(new VisionTest());
        */
        
    }
    
    /**
     * @return X axis on controller 
     */
    public double getX() {
        return ButtonMap.xbox0.getRawAxis(AxisMap.RIGHT_TRIGGER) - ButtonMap.xbox0.getRawAxis(AxisMap.LEFT_TRIGGER); // One trigger forward, other reverse
    }
    
    /**
     * @return Y axis on controller with joystick dead zone compensation
     */
    public double getY() {
        return Math.abs(ButtonMap.xbox0.getRawAxis(AxisMap.LEFT_ANALOG_STICK_X_AXIS)) >= 0.2 ? -ButtonMap.xbox0.getRawAxis(AxisMap.LEFT_ANALOG_STICK_X_AXIS) : 0;
    }
}

