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
public class Auto extends CommandGroup {
    
    public  Auto() {
    	addSequential(new TurnWithGyro(0.50, -0.80));
    	//addSequential(new PrintAngle());
    	
    	addSequential(new DriveIndefinitely(0.5), 0.2);
    	addSequential(new TurnWithGyro(0.50, 1.60));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(0.6), 0.3);

    	addSequential(new TurnWithGyro(0.50, -0.70));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(0.5), 0.3);
    	
    	addSequential(new DriveIndefinitely(0), 0.5);
    	addSequential(new TurnWithGyro(0.50, -0.80));
    	//addSequential(new PrintAngle());
    	
    	addSequential(new DriveIndefinitely(0.5), 0.2);
    	addSequential(new TurnWithGyro(0.50, 1.60));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(0.6), 0.3);

    	addSequential(new TurnWithGyro(0.50, -0.70));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(0.5), 0.3);
    	
    	addSequential(new DriveIndefinitely(0), 0.5);
    	addSequential(new TurnWithGyro(0.50, 2.4));
    	//addSequential(new PrintAngle());
    	addSequential(new DriveIndefinitely(0.5), 0.5);
    }
}
