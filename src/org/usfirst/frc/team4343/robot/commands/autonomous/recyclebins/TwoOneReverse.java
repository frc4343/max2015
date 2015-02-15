package org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro2;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDescend;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TwoOneReverse extends CommandGroup {
    
    public  TwoOneReverse() {
    	addSequential(new ClawClose());
        addSequential(new DriveIndefinitely(0), 0.5);
        
        addParallel(new TransmissionAscend(), 1);
        addSequential(new DriveIndefinitely(-1), 1);
        addSequential(new TurnWithGyro2(0.5, 120, "RIGHT"));
        
        addSequential(new DriveIndefinitely(0.8), 0.25);
        
        addParallel(new ClawOpen());
    	addSequential(new TransmissionDescend(), 1);
    	
    	addSequential(new DriveIndefinitely(-0.8), 0.4);
    	addSequential(new TurnWithGyro2(0.5, 20, "LEFT")); // needs to be 30 degrees robot must turn right though
    	addSequential(new DriveIndefinitely(0.8), 1);
    	addSequential(new DriveIndefinitely(0), 0.5);
        addSequential(new ClawClose());
        addSequential(new DriveIndefinitely(0), 0.5);
        addParallel(new TransmissionAscend(), 1);
        addSequential(new DriveIndefinitely(-0.8), 1.6);
    	
    }
}
