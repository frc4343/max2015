/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot;

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
        return ButtonMap.xbox1.getRawAxis(3);
    }
    
    /**
     * @return Y axis on controller with joystick dead zone compensation
     */
    public double getY() {
        return Math.abs(ButtonMap.xbox1.getRawAxis(1)) >= 0.2 ? -ButtonMap.xbox1.getRawAxis(1) : 0;
    }
}

