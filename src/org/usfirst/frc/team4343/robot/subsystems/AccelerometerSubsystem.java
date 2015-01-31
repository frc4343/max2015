/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.commands.accelerometer.ReportStatus;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 * Accelerometer Subsystem
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class AccelerometerSubsystem extends Subsystem implements Accelerometer {
	
	private final ADXL345_I2C accelerometer = new ADXL345_I2C(I2C.Port.kOnboard, Range.k2G); // I have no idea if this works, they changed this with roboRio
	
    public void initDefaultCommand() {
        setDefaultCommand(new ReportStatus());
    }

	@Override
	public void setRange(Range range) {
		accelerometer.setRange(range);
	}

	@Override
	public double getX() {
		return accelerometer.getX();
	}

	@Override
	public double getY() {
		return accelerometer.getY();
	}

	@Override
	public double getZ() {
		return accelerometer.getZ();
	}
}

