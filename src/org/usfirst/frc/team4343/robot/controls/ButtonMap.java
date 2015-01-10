/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.controls;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Xbox Joystick Object Creation and Mappings
 * 
 * @author Brian Ho <www.4343.ca>
 * @author Tedi Papajorgji <www.4343.ca>
 */
public class ButtonMap {
	// Joystick Objects
	public static final Joystick xbox0 = new Joystick(0);
	public static final Joystick xbox1 = new Joystick(1);

	// Buttons on joystick 0
	public static final Button xbox0_A = new JoystickButton(xbox0, 1);
	public static final Button xbox0_B = new JoystickButton(xbox0, 2);
	public static final Button xbox0_X = new JoystickButton(xbox0, 3);
	public static final Button xbox0_Y = new JoystickButton(xbox0, 4);
	public static final Button xbox0_L3 = new JoystickButton(xbox0, 9);
	public static final Button xbox0_R3 = new JoystickButton(xbox0, 10);
	public static final Button xbox0_START = new JoystickButton(xbox0, 8);
	public static final Button xbox0_SELECT = new JoystickButton(xbox0, 7);
	public static final Button xbox0_L1 = new JoystickButton(xbox0, 5);
	public static final Button xbox0_R1 = new JoystickButton(xbox0, 6);

	// Buttons on joystick 1
	public static final Button xbox1_A = new JoystickButton(xbox1, 1);
	public static final Button xbox1_B = new JoystickButton(xbox1, 2);
	public static final Button xbox1_X = new JoystickButton(xbox1, 3);
	public static final Button xbox1_Y = new JoystickButton(xbox1, 4);
	public static final Button xbox1_L3 = new JoystickButton(xbox1, 9);
	public static final Button xbox1_R3 = new JoystickButton(xbox1, 10);
	public static final Button xbox1_START = new JoystickButton(xbox1, 8);
	public static final Button xbox1_SELECT = new JoystickButton(xbox1, 7);
	public static final Button xbox1_L1 = new JoystickButton(xbox1, 5);
	public static final Button xbox1_R1 = new JoystickButton(xbox1, 6);
}
