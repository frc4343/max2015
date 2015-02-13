/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro;
import org.usfirst.frc.team4343.robot.commands.gyro.PrintAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Alt extends CommandGroup {
    
    public  Alt() {
    	addSequential(new DriveIndefinitely(0), 1.0); //grab
    	addSequential(new DriveIndefinitely(-1), 0.8); // reverse 
        addSequential(new TurnWithGyro(0.8, 2.6)); // turn 90
        addSequential(new PrintAngle()); 
        addSequential(new DriveIndefinitely(0), .5); //delay
        addSequential(new DriveIndefinitely(-1), 0.4); 
        addSequential(new TurnWithGyro(0.8, -4.2)); // turn 180        
        addSequential(new DriveIndefinitely(.9), .85); // forward
        addSequential(new DriveIndefinitely(0), 1.0); //delay
        addSequential(new DriveIndefinitely(-0.8), .5); // reverse 
        addSequential(new TurnWithGyro(0.8, .65)); // turn 90
        addSequential(new DriveIndefinitely(-0.8), 1.75); // reverse 
        
        //addSequential(new DriveIndefinitely(-0.5), 0.5); // reverse
    }
}
