package org.usfirst.frc.team4343.robot.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EncoderTest extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final Encoder encoder = new Encoder(1,2, true, EncodingType.k4X);
	private final SpeedController motor = new Victor(6);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Encoder getEncoder() {
    	return encoder;
    }
    
    public SpeedController getMotor() {
    	return motor;
    }
}

