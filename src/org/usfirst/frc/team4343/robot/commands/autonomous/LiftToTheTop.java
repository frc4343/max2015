package org.usfirst.frc.team4343.robot.commands.autonomous;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LiftToTheTop extends CommandGroup {
    
    public  LiftToTheTop() {
        addSequential(new ClawClose());
        addSequential(new DriveIndefinitely(0), 1); // delay 1 second
        addSequential(new TransmissionAscend());
    }
}
