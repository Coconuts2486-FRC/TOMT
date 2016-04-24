package org.usfirst.frc2486.CompetitionBot.subsystems;

import org.usfirst.frc2486.CompetitionBot.RobotMap;
import org.usfirst.frc2486.CompetitionBot.RobotValues;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {

	private static CameraServer camera = RobotMap.server;
	private String ID = RobotValues.CameraID;
	
    public void initDefaultCommand() {
    	camera = CameraServer.getInstance();
    	camera.setQuality(10);
    	camera.setSize(1);
    	camera.startAutomaticCapture(ID);
    }
}
