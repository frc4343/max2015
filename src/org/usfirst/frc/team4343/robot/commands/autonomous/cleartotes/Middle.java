/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.autonomous.cleartotes;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Middle extends CommandGroup {
    
    public  Middle() {
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    	addSequential(new DriveIndefinitely(1), 0.25);
    	addSequential(new Spin("LEFT"));
    }
}
