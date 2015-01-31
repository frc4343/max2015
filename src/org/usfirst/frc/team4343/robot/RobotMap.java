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
	public final static byte RIGHT_MOTOR_PAIR = 0;
	public final static byte LEFT_MOTOR_PAIR = 1;
	
	// Transmission
	public final static byte TRANSMISSION_PAIR = 3;
	
	// LEDs
	public final static byte RED_LED_PORT = 1;
	public final static byte GREEN_LED_PORT = 2;
	public final static byte BLUE_LED_PORT = 3;
	
	// ANALOG INPUT
	public final static byte GYRO_SENSOR_PORT = 0;
	
	// CAN IDs
	public final static byte PDP = 0;
	public final static byte PCM = 1;
}
