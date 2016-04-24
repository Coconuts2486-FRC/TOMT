package org.usfirst.frc2486.CompetitionBot.autonomous;

//import org.usfirst.frc2486.CompetitionBot.functions.CameraShoot;
import org.usfirst.frc2486.CompetitionBot.functions.EncoderHandler;

import edu.wpi.first.wpilibj.DriverStation;

/*
 * This class file is for if the robot is positioned directly in front of the bar.
 */
public class Bar {
	//Instantiates EncoderHandler. Not the most efficient way of doing it.
	public static EncoderHandler encoderHandler = AutonomousSwitcher.encoderHandler;
	public static void run(long delay){
		//If a delay is present, then incorporate a delay.
		if(delay != 0){
			sleep(delay);
		}
		//Runs the robot backwards.
		encoderHandler.runTo(-3000, 0.3);
		//Turns the robot 360 degrees.
		encoderHandler.runTo(-1000, 1000, 0.3);
		//Fires the cannons.
		//CameraShoot.fireTheCannons();
	}

	//Attempts to sleep. Reports to the driver station if an internal error occurs.
	private static void sleep(long delay){
		try{ Thread.sleep(delay); }
		catch(InterruptedException ex){ DriverStation.reportError("Exception: " + ex, true); }
	}
}
