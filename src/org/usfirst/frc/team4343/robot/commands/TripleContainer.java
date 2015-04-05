package org.usfirst.frc.team4343.robot.commands;

import org.usfirst.frc.team4343.robot.commands.claw.ClawClose;
import org.usfirst.frc.team4343.robot.commands.claw.ClawOpen;
import org.usfirst.frc.team4343.robot.commands.drivetrain.DriveIndefinitely;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro2;
import org.usfirst.frc.team4343.robot.commands.drivetrain.TurnWithGyro4;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionAscend;
import org.usfirst.frc.team4343.robot.commands.transmission.TransmissionDescend;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TripleContainer extends CommandGroup {
    
    public  TripleContainer() {
    	/*addSequential(new TransmissionDescend()); // arm down to lift back container
        addSequential(new DriveIndefinitely(0.8), 0.40); // drive forward
        
        
        addSequential(new ClawClose()); // close claw to grab container 2
        addSequential(new DriveIndefinitely(0), 0.35); // delay for arm to close
        addSequential(new TransmissionAscend(), 0.45); // arm up to lift container
        addSequential(new DriveIndefinitely(0.8), 0.6); // drive forward
        
        
        
        //addSequential(new DriveIndefinitely(0.8), 0.7); // drive forward
        addSequential(new TurnWithGyro2(0.6, 45, true)); // resets gyro and turn 45 deg right to face other alliance
        
        addSequential(new DriveIndefinitely(0.8), 1.5); // drive forward
        
        
        addSequential(new TransmissionDescend()); // arm down 
        addSequential(new ClawOpen()); // opens claw, drops container
        addSequential(new DriveIndefinitely(0), 1); // delay for arm to open
        addSequential(new DriveIndefinitely(-0.8), 1.625); // drive bkward was 1.5
        addSequential(new TurnWithGyro2(0.6, -50, true)); // resets gyro and turn 45 deg right to face other alliance
        
        // non tested
        addSequential(new DriveIndefinitely(0.8), 0.725); // drive forward
        addSequential(new ClawClose()); // close claw to grab container 3
        addSequential(new DriveIndefinitely(0), 0.35); // delay for arm to close
        addSequential(new TransmissionAscend(), 0.45); // arm up to lift container
        addSequential(new TurnWithGyro2(0.65, -55, true)); // resets gyro and turn 45 deg right to face other (0.6 speed, -45 deg)alliance
        addSequential(new DriveIndefinitely(-0.8), 2.25); // drive backword
        addSequential(new TurnWithGyro2(0.65, 55, true)); // was 55
        */
    	addSequential(new TransmissionDescend()); // arm down to lift back container
    	addSequential(new DriveIndefinitely(0.8), 0.40); // drive forward
        
        
        addSequential(new ClawClose()); // close claw to grab container 2
        addSequential(new DriveIndefinitely(0), 0.35); // delay for arm to close
        addSequential(new TransmissionAscend(), 0.45); // arm up to lift container
        addSequential(new DriveIndefinitely(0.8), 0.6); // drive forward
        
        
        
        //addSequential(new DriveIndefinitely(0.8), 0.7); // drive forward
        addSequential(new TurnWithGyro4(0.6, 45, true)); // resets gyro and turn 45 deg right to face other alliance
        
        addSequential(new DriveIndefinitely(0.8), 1.5); // drive forward
        
        
        addSequential(new TransmissionDescend()); // arm down 
        addSequential(new ClawOpen()); // opens claw, drops container
        addSequential(new DriveIndefinitely(0), 1); // delay for arm to open
        addSequential(new DriveIndefinitely(-0.8), 1.625); // drive bkward was 1.5
        addSequential(new TurnWithGyro4(0.7, -42, true)); // resets gyro and turn 45 deg right to face other alliance
        
        // non tested
        addSequential(new DriveIndefinitely(0.8), 0.8); // drive forward
        addSequential(new ClawClose()); // close claw to grab container 3
        addSequential(new DriveIndefinitely(0), 0.35); // delay for arm to close
        addSequential(new TransmissionAscend(), 0.45); // arm up to lift container
        addSequential(new TurnWithGyro4(0.7, -60, true)); // resets gyro and turn 45 deg right to face other (0.6 speed, -45 deg)alliance
        addSequential(new DriveIndefinitely(-0.8), 2); // drive backword
        addSequential(new TurnWithGyro4(0.6, 22.5, true)); // was 55
    }
}
