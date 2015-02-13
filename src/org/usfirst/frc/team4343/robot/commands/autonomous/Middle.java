package org.usfirst.frc.team4343.robot.commands.autonomous;

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
