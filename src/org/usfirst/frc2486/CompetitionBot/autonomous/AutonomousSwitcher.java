package org.usfirst.frc2486.CompetitionBot.autonomous;

import org.usfirst.frc2486.CompetitionBot.RobotMap;
import org.usfirst.frc2486.CompetitionBot.functions.EncoderHandler;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Handler for switching between the different 
 */
public class AutonomousSwitcher {
	private static int flag;
	private static long timerDelay;
	
	public static CANTalon speedControllerLeft;
	public static CANTalon speedControllerLeftSlave;
	public static CANTalon speedControllerRight;
	public static CANTalon speedControllerRightSlave;
	
	public static Encoder encoderLeft;
	public static Encoder encoderRight;
	
	public static EncoderHandler encoderHandler;
	
	public static void setFlag(int amt, long delay){
		//Sets the flag to equal the parameter.
		flag = amt;
		//Sets the timer delay.
		timerDelay = delay;
		//After setting the amount, the command will start.
		//run(timerDelay);
		
		//CUSTOM
		SmartDashboard.putString("Current operation", "Flag running! " + flag);
		if(flag == 4) {
			Line.run(delay);
		}
		if(flag == 1) {
			Disabled.run();
		}
		//END CUSTOM
		
	}
	
	//Switches between the different modes.
	private static void run(long delay){
		//Sets the two side talons to be in follower mode.
		speedControllerLeft = RobotMap.driveTrainTalonFl;
		speedControllerLeftSlave = RobotMap.driveTrainTalonRl;
		
		speedControllerRight = RobotMap.driveTrainTalonFr;
		speedControllerRightSlave = RobotMap.driveTrainTalonRr;
		
		speedControllerLeftSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		speedControllerLeftSlave.set(speedControllerLeft.get());
		
		speedControllerRightSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		speedControllerRight.set(speedControllerRight.get());
		
		//Switches between the four autonomous modes. Then executes [class].run();, which runs the command.
		switch(flag){  
		case 1:
			Disabled.run();
			break;
		case 2:
			Bar.run(delay);
			break;
		case 3:
			Spy.run(delay);
			break;
		case 4:
			Line.run(delay);
			break;
		default:
			DriverStation.reportError
			("An error occured in the AutonomousSwitcher class. Value not assigned: " + flag, true);
		}
		encoderHandler = new EncoderHandler(speedControllerRight, speedControllerLeft, encoderRight, encoderLeft);
	}
}
