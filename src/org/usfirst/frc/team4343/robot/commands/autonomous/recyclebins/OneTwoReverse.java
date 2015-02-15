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
public class OneTwoReverse extends CommandGroup {
    
    public  OneTwoReverse() {
    	// Grab and reverse
    	addSequential(new ClawClose()); // grab
        addSequential(new DriveIndefinitely(0), 0.5); // delay
        addParallel(new TransmissionAscend(), 1); // lift of ground a little
        addSequential(new DriveIndefinitely(-0.8), 1.37); // reverse
        
        // rotate to face wall and drop
        addSequential(new TurnWithGyro2(0.5, 70, "RIGHT")); // overshoots to 90
        addSequential(new DriveIndefinitely(0.8), 0.1); // push bin against wall
        addParallel(new ClawOpen()); // drop
    	addSequential(new TransmissionDescend(), 1); // lower arm
        addSequential(new DriveIndefinitely(-0.6), 0.8); // reverse
        
        // Turn to face bin 2
        addSequential(new TurnWithGyro2(0.6, -20, "LEFT"));
        addSequential(new DriveIndefinitely(0.8), 1.75); // go towards bin 2
        addSequential(new DriveIndefinitely(0), 0.5); // delay
        addSequential(new ClawClose()); // grab
        addSequential(new DriveIndefinitely(0), 0.5); // delay
        addParallel(new TransmissionAscend(), 1); // lift off ground a little
        addSequential(new DriveIndefinitely(-0.8), 1.6); // reverse
        addSequential(new TurnWithGyro2(0.6, 50, "LEFT")); // turn and end
    }
}
