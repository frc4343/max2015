/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.commands.autonomous;

import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TurnAndGo extends CommandGroup {
    
    public TurnAndGo() {
    	addSequential(new TurnWithGyro(0.50, 2.4));
    	addSequential(new DriveIndefinitely(1), 1);
    }
}
