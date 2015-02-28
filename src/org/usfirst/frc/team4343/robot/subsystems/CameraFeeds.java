/*
 * FRC Team 4343
 * Visit us at www.4343.ca
 */
package org.usfirst.frc.team4343.robot.subsystems;

import org.usfirst.frc.team4343.robot.commands.camera.UpdateFrontCamera;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Camera Feed Subsystem
 * 
 * @author Brian Ho <www.4343.ca>
 */
public class CameraFeeds extends Subsystem {
    
	// Get camera ids by supplying camera name ex 'cam0', found on roborio web interface
	private int frontCamera = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController); 
	private final int imgQuality = 60;
	// Img that will contain camera img
	private Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	// Server that we'll give the img to
	private CameraServer server = CameraServer.getInstance();
    
	/**
	 * Always update the front camera, get image and refresh
	 */
    public void initDefaultCommand() {
        setDefaultCommand(new UpdateFrontCamera());
    }
    
    /**
     * Initialize camera code
     */
    public void init() {
    	server.setQuality(imgQuality);
    	NIVision.IMAQdxConfigureGrab(frontCamera);
    	NIVision.IMAQdxStartAcquisition(frontCamera);
    }

    
	/**
	 * Get the img from current camera and give it to the server
	 */
    public void updateCam() {
    	NIVision.IMAQdxGrab(frontCamera, frame, 1);
        server.setImage(frame);
    }
}

