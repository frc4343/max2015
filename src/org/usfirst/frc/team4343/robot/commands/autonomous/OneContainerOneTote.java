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
public class OneContainerOneTote extends CommandGroup {
    
    public  OneContainerOneTote() {
    	addParallel(new DriveIndefinitely(0.5), 0.01); // bkwd
    	addSequential(new TransmissionDescend(), 4.95); // arm down
    	
    	
    	addSequential(new DriveIndefinitely(-0.5), 0.27); // - is fwd
    	addParallel(new ClawClose()); // clozw claw
    	addSequential(new TransmissionAscend(), 1); // arm up
    	addSequential(new DriveIndefinitely(-0.5), 0.7); // - is fwd
    	
    	
    	addSequential(new TurnWithGyro(-0.9, 0.5));
    	
    	// addSequential(new TransmissionAscend(),0.01);
    	
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
