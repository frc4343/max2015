/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.autonomous;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro;
//import org.usfirst.frc.team4343.robot.commands.gyro.PrintAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FasterAuto extends CommandGroup {
    
    public  FasterAuto() {
    	addSequential(new TurnWithGyro(0.70, -0.80));
    	//addSequential(new PrintAngle());
    	
    	addSequential(new DriveIndefinitely(0.7), 0.1);
    	addSequential(new TurnWithGyro(1, 1.60));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(0.8), 0.3);

    	addSequential(new TurnWithGyro(0.50, -0.70));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(0.5), 0.35);
    	
    	addSequential(new DriveIndefinitely(0), 2);
    	addSequential(new TurnWithGyro(1, -0.80));
    	//addSequential(new PrintAngle());
    	
    	addSequential(new DriveIndefinitely(0.7), 0.1);
    	addSequential(new TurnWithGyro(1, 1.60));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(0.8), 0.3);

    	addSequential(new TurnWithGyro(0.50, -0.70));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(0.5), 0.35);
    	
    	addSequential(new DriveIndefinitely(0), 2);
    	addSequential(new TurnWithGyro(1, 2.2));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(1), 1);
    }
}
