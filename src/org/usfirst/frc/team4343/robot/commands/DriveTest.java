/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveTest extends CommandGroup {
    
    public  DriveTest() {
        //addSequential(new DriveToDistance(200));
        
        addSequential(new TurnWithEncoder(.5, 200, "LEFT"));
        //addSequential(new DriveIndefinitely(0), 0.5);
        addSequential(new TurnWithEncoder(.5, 150, "RIGHT"));
        //addSequential(new TurnWithEncoder(0.5, 200, "LEFT"));
    }
}
