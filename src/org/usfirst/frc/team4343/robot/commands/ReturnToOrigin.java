package org.usfirst.frc.team4343.robot.commands;

import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro3;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ReturnToOrigin extends CommandGroup {
    
    public ReturnToOrigin() {
        addSequential(new TurnWithGyro3(0.65, 45, true));
        addSequential(new TurnWithGyro3(0.65, -45, true));
    }
}
