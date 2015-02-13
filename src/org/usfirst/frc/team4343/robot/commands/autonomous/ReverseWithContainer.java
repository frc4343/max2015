package org.usfirst.frc.team4343.robot.commands.autonomous;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ReverseWithContainer extends CommandGroup {
    
    public ReverseWithContainer() {
        addSequential(new DriveIndefinitely(0), 1);
        addSequential(new DriveIndefinitely(-1), 1);
    }
}
