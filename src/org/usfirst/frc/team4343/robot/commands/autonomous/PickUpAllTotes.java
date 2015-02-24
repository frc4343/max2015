package org.usfirst.frc.team4343.robot.commands.autonomous;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro2;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDescend;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PickUpAllTotes extends CommandGroup {
    
    public  PickUpAllTotes() {
    	addSequential(new ClawClose());
    	
    	addParallel(new TransmissionAscend(), 2); // arm up for 2 secs
    	//addSequential(new TurnWithGyro2(0.65, 30)); // move tote 
    	
    	addParallel(new TransmissionAscend(), 1.5); // arm up for 2 secs
    	addSequential(new DriveIndefinitely(0.65), .5); // drive fwd a little
    	
    	//addSequential(new TurnWithGyro2(0.65, -7)); // drive fwd a little
    	
    	addSequential(new DriveIndefinitely(0.65), .5); // drive fwd a little
    	//addSequential(new TurnWithGyro2(0.65, 7)); // return to 0
    	
        addSequential(new DriveIndefinitely(0.65), 1.5); // drive fwd a little
        
        
        //addSequential(new DriveIndefinitely(0.5), .5); // drive fwd a little
        
        
        
        /*addSequential(new DriveIndefinitely(0.5), 1); // move fwd a little
        
        addSequential(new TurnWithGyro2(0.5, 27)); 
        addSequential(new DriveIndefinitely(0.5), 1); // move fwd a little
        
        addSequential(new TurnWithGyro2(0.5, 2)); // return to 0
        addSequential(new TransmissionDescend(), 3); // arm down for 2 secs
        addSequential(new DriveIndefinitely(0.5), 2); // move fwd a little more to stack
        addSequential(new ClawOpen());
        
        addSequential(new TransmissionDescend(), 2);
        addSequential(new ClawClose());
        
        // THIS IS AFTER PICKING UP THE 2 YELLOW TOTES STACKED ON TOP OF EACH OTHER 
        
        addSequential(new TurnWithGyro2(0.5, -27)); // move tote 
        addSequential(new TransmissionAscend(), 4); // arm up for 2 secs
        addSequential(new DriveIndefinitely(0.5), 1); // drive fwd a little
        
        addSequential(new TurnWithGyro2(0.5, 2)); // return to 0
        addSequential(new DriveIndefinitely(0.5), 1); // move fwd a little
        
        addSequential(new TurnWithGyro2(0.5, 27)); // return to 0
        addSequential(new DriveIndefinitely(0.5), 1); // move fwd a little
        
        addSequential(new TurnWithGyro2(0.5, 2)); // return to 0
        addSequential(new TransmissionDescend(), 3); // arm down for 2 secs
        addSequential(new DriveIndefinitely(0.5), 2); // move fwd a little more to stack
        addSequential(new ClawOpen());
        
        addSequential(new TransmissionDescend(), 2);
        addSequential(new ClawClose()); // grab bottom of 3 tote stack
        
        addSequential(new TransmissionAscend(), 0.5);
        addSequential(new TurnWithGyro2(0.5, 90));
        addSequential(new DriveIndefinitely(0.5), 6); // drive into auto zone
        */
    }
}
