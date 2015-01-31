package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
* @author Brian Ho <www.4343.ca>
* @author Tedi Papajorgji <www.4343.ca>
*/
public class GyroSubsystem extends Subsystem {
   
   private final Gyro gyro = new Gyro(RobotMap.GYRO_SENSOR_PORT);
   
   private final double kP = 0.03; // http://wpilib.screenstepslive.com/s/3120/m/7912/l/85772-gyros-to-control-robot-driving-direction
   /**
    * Always display current angle value
    */
   public void initDefaultCommand() {
       
   }
   
   /**
    * Resets the gyro
    */
   public void reset() {
       gyro.reset();
   }
   
   /**
    * @return The angle of the robot (gyro)
    */
   public double getAngle() {
       return gyro.getAngle() * kP;
   }
}
