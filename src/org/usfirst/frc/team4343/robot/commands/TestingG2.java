package org.usfirst.frc.team4343.robot.commands;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro2;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestingG2 extends CommandGroup {
    
    public  TestingG2() {
    	addSequential(new DriveIndefinitely(-0.5), 0.1);
    	//addSequential(new TurnWithGyro2(0.5, 90));
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
