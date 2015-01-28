package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lights extends Subsystem {
    
    private final Solenoid red = new Solenoid(1, RobotMap.RED_LED_PORT);
    private final Solenoid green = new Solenoid(1, RobotMap.GREEN_LED_PORT);
    private final Solenoid blue = new Solenoid(1, RobotMap.BLUE_LED_PORT);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new Blink());
    }
 
    /**
     * Sets the colour of the LED light strip
     * @param colour Accepts a value of red, green, or blue, case insensitive 
     */
    public void setColour(String colour) {
        if (colour.equalsIgnoreCase("red")) {
            setRed();
        } else if (colour.equalsIgnoreCase("green")) {
            setGreen();
        } else if (colour.equalsIgnoreCase("blue")) {
            setBlue();
        } else {
            turnOff();
        }
    }
    
    /**
     * Turns off other colours first to have enough voltage then turns on red
     */
    private void setRed() {
        blue.set(false);
        green.set(false);
        red.set(true);
    }
    
    /**
     * Turns off other colours first to have enough voltage then turns on red
     */
    private void setGreen() {
        blue.set(false);
        red.set(false);
        green.set(true);
    }
    
    /**
     * Turns off other colours first to have enough voltage then turns on blue
     */
    private void setBlue() {
        red.set(false);
        green.set(false);
        blue.set(true);
    }
    
    /**
     * Turns off all colours
     */
    private void turnOff() {
        red.set(false);
        green.set(false);
        blue.set(false);
    }
}

