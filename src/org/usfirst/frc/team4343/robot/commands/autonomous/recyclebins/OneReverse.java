package org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro2;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OneReverse extends CommandGroup {
    
    public  OneReverse() {
    	addSequential(new ClawClose());
        addSequential(new DriveIndefinitely(0), 0.5);
        
        addParallel(new TransmissionAscend(), 1);
        addSequential(new DriveIndefinitely(-0.8), 1.37);
        addSequential(new TurnWithGyro2(0.5, 70, false));
    }
}
