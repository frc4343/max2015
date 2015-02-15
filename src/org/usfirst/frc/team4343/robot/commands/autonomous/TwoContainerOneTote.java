package org.usfirst.frc.team4343.robot.commands.autonomous;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDescend;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TwoContainerOneTote extends CommandGroup {
    
    public  TwoContainerOneTote() {
    	addParallel(new DriveIndefinitely(0.5), 0.01); // bkwd
    	addSequential(new TransmissionDescend(), 4.95); // arm down
    	
    	
    	addSequential(new DriveIndefinitely(-0.5), 0.27); // - is fwd
    	addParallel(new ClawClose()); // clozw claw
    	addSequential(new TransmissionAscend(), 1); // arm up
    	addSequential(new DriveIndefinitely(-0.5), 0.7); // - is fwd
    	
    	
    	//addSequential(new TurnWithGyro(-0.9, 0.5));
    	
    	// addSequential(new TransmissionAscend(), 0.00);
    }
}
