package org.usfirst.frc2486.CompetitionBot.autonomous;

import org.usfirst.frc2486.CompetitionBot.Robot;
import org.usfirst.frc2486.CompetitionBot.RobotMap;
import org.usfirst.frc2486.CompetitionBot.commands.Autonomous;
//import org.usfirst.frc2486.CompetitionBot.functions.CameraShoot;
import org.usfirst.frc2486.CompetitionBot.functions.EncoderHandler;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * This class file is for if the robot must be placed at the center alignment line.
 */
//Instantiates EncoderHandler. Not the most efficient way of doing it.
public class Line {
	//public static EncoderHandler encoderHandler = AutonomousSwitcher.encoderHandler;
	public static void run(long delay){
		//If a delay is present, then incorporate a delay.
		if(delay != 0){
			sleep(delay);
		}
		//Moves the robot back far enough to clear other robots.
		//encoderHandler.runTo(-800, 0.3);
		//Turns the robot to face perpendicular to the bar.
		//encoderHandler.runTo(-350, 350, 0.3);
		//Drives to the wall.
		//encoderHandler.runTo(3000, 0.3);
		//Turns the robot to face the bar.
		//encoderHandler.runTo(350, -350, 0.3);
		//Drives through the bar.
		//encoderHandler.runTo(1000, 0.3);
		//CameraShoot.fireTheCannons();
		AutonomousSwitcher.speedControllerLeft = RobotMap.driveTrainTalonFl;
		AutonomousSwitcher.speedControllerLeft.reverseOutput(true);
		AutonomousSwitcher.speedControllerLeftSlave = RobotMap.driveTrainTalonRl;
		
		AutonomousSwitcher.speedControllerRight = RobotMap.driveTrainTalonFr;
		AutonomousSwitcher.speedControllerRightSlave = RobotMap.driveTrainTalonRr;
		/*
		AutonomousSwitcher.speedControllerLeftSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		AutonomousSwitcher.speedControllerLeftSlave.set(AutonomousSwitcher.speedControllerLeft.get());
		
		AutonomousSwitcher.speedControllerRightSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		AutonomousSwitcher.speedControllerRight.set(AutonomousSwitcher.speedControllerRight.get());
		*/
		
		//CUSTOM
		SmartDashboard.putString("Current operation", "Motors set to 0.5");
		AutonomousSwitcher.speedControllerLeft.set(-0.5);
		AutonomousSwitcher.speedControllerLeftSlave.set(-0.5);
		AutonomousSwitcher.speedControllerRight.set(0.5);
		AutonomousSwitcher.speedControllerRightSlave.set(0.5);
		sleep(5000);
		SmartDashboard.putString("Current operation", "Motors set to 0");
		AutonomousSwitcher.speedControllerLeft.set(0);
		AutonomousSwitcher.speedControllerLeftSlave.set(0);
		AutonomousSwitcher.speedControllerRight.set(0);
		AutonomousSwitcher.speedControllerRightSlave.set(0);
		sleep(5000);
		Autonomous.runFlag = false;
		//END CUSTOM
	}
	
	//Attempts to sleep. Reports to the driver station if an internal error occurs.
	private static void sleep(long delay){
		try{ Thread.sleep(delay); }
		catch(InterruptedException ex){ DriverStation.reportError("Exception: " + ex, true); }
	}
}
