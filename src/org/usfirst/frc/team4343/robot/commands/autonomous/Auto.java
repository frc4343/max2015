package org.usfirst.frc.team4343.robot.commands.autonomous;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveWithTimer;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto extends CommandGroup {
    
    public  Auto() {
    	addSequential(new TurnWithGyro(-0.8));
    	addSequential(new DriveWithTimer(-1, 0.25));
    	addSequential(new TurnWithGyro(0.35));
    	addSequential(new DriveWithTimer(-1, 0.50));
    	addSequential(new TurnWithGyro(0.01));
    	
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
