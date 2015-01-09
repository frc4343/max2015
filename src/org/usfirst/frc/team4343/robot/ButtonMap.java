/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot;

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
	public static final Joystick xbox1 = new Joystick(1);
	public static final Joystick xbox2 = new Joystick(2);

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

	// Buttons on joystick 2
	public static final Button xbox2_A = new JoystickButton(xbox2, 1);
	public static final Button xbox2_B = new JoystickButton(xbox2, 2);
	public static final Button xbox2_X = new JoystickButton(xbox2, 3);
	public static final Button xbox2_Y = new JoystickButton(xbox2, 4);
	public static final Button xbox2_L3 = new JoystickButton(xbox2, 9);
	public static final Button xbox2_R3 = new JoystickButton(xbox2, 10);
	public static final Button xbox2_START = new JoystickButton(xbox2, 8);
	public static final Button xbox2_SELECT = new JoystickButton(xbox2, 7);
	public static final Button xbox2_L1 = new JoystickButton(xbox2, 5);
	public static final Button xbox2_R1 = new JoystickButton(xbox2, 6);
}
