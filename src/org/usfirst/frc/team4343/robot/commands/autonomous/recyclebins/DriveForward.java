package org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro2;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForward extends CommandGroup {
    
    public  DriveForward() {
    	addSequential(new DriveIndefinitely(0.8), 1.38);
    	addSequential(new TurnWithGyro2(0.5, -150, false));
    	addSequential(new DriveIndefinitely(0.8), 1.2);
    	addSequential(new ClawClose());
    	addSequential(new TurnWithGyro2(0.5, 2, false));
    	addSequential(new DriveIndefinitely(0.5), 1.4);
    }
}
