package org.usfirst.frc.team4343.robot.commands.autonomous.recyclebins;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnToAngle;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDescend;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OneTwoReverse extends CommandGroup {
    
    public  OneTwoReverse() {
    	addSequential(new ClawClose());
        addSequential(new DriveIndefinitely(0), 0.5);
        
        addParallel(new TransmissionAscend(), 1);
        addSequential(new DriveIndefinitely(-0.8), 1.3); // was 1.37
        addSequential(new TurnToAngle(0.5, 81, true)); // was 70
        addSequential(new DriveIndefinitely(0.8), 0.1);
        
        addParallel(new ClawOpen());
    	addSequential(new TransmissionDescend(), 1);
        addSequential(new DriveIndefinitely(-0.6), 0.8);
        addSequential(new TurnToAngle(0.6, -23, false)); // was true
        addSequential(new DriveIndefinitely(0.8), 1.5); // changed
        addSequential(new DriveIndefinitely(0), 0.5);
        addSequential(new ClawClose());
        addSequential(new DriveIndefinitely(0), 0.5);
        addParallel(new TransmissionAscend(), 1);
        addSequential(new DriveIndefinitely(-0.8), 1.65);
        //addSequential(new ClawOpen());
        addSequential(new TurnToAngle(0.6, 60, false)); // was true
        // changed
    }
}
