package org.usfirst.frc.team4343.robot.commands;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DoNothing extends CommandGroup {
    
    public  DoNothing() {
        addSequential(new DriveIndefinitely(0));
    }
}
