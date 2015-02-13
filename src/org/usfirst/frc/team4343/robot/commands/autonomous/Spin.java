package org.usfirst.frc.team4343.robot.commands.autonomous;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Spin extends CommandGroup {
    
    public  Spin(String position) {
    	addSequential(new DriveIndefinitely(1), 0.25);
    	if (position.equalsIgnoreCase("RIGHT")) {
    		addSequential(new TurnWithGyro(1, 9.6));
    	} else if (position.equalsIgnoreCase("LEFT")) {
    		addSequential(new TurnWithGyro(1, -9.6));
    	} else { // centre
    		addSequential(new TurnWithGyro(1, 9.6));
    	}
        
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
