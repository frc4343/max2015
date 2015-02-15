package org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro2;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TwoReverse extends CommandGroup {
    
    public  TwoReverse() {
    	// Grab and reverse
    	addSequential(new ClawClose()); // grab
        addSequential(new DriveIndefinitely(0), 0.5); // delay
        addParallel(new TransmissionAscend(), 1); // lift of ground a little
        addSequential(new DriveIndefinitely(-0.8), 1.37); // reverse
        
        // rotate to face wall
        addSequential(new TurnWithGyro2(0.5, 70, "RIGHT")); // overshoots to 90
    }
}
