/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// DriveTrain
	public static final byte RIGHT_MOTOR_PAIR = 0;
	public static final byte LEFT_MOTOR_PAIR = 1;

	// Transmission
	public static final byte TRANSMISSION_PAIR = 2;
	public static final byte MAX_HEIGHT_LIMIT_SWITCH_PORT = 4;
	public static final byte MIN_HEIGHT_LIMIT_SWITCH_PORT = 5;

	// LEDs
	public static final byte RED_LED_PORT = 1;
	public static final byte GREEN_LED_PORT = 2;
	public static final byte BLUE_LED_PORT = 3;

	// ANALOG INPUT
	public static final byte GYRO_SENSOR_PORT = 0;
	public static final byte ACCELEROMETER_PORT = 1;

	// CAN IDs
	public static final byte PDP_CANID = 0;
	public static final byte PCM_CANID = 1;
	
	// CLAW
	public static final byte TOTE_FULLY_IN_CLAW_LIMIT_SWITCH_PORT = 6;
	
	// SOLENOID
	public static final byte LEFT_SOLENOID_PORT = 0;
	public static final byte RIGHT_SOLENOID_PORT = 1;	
	
	//ROLLERS
	public static final byte LEFT_ROLLER_PORT = 9;
	public static final byte RIGHT_ROLLER_PORT = 8;
}
