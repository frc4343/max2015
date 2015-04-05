package org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForward extends CommandGroup {
    
    public  DriveForward() {
        addSequential(new DriveIndefinitely(1), 1);
    }
}
