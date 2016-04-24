package org.usfirst.frc2486.CompetitionBot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2486.CompetitionBot.Robot;
import org.usfirst.frc2486.CompetitionBot.RobotValues;
import org.usfirst.frc2486.CompetitionBot.autonomous.AutonomousSwitcher;

public class Autonomous extends Command {
	
	private int time = RobotValues.AutoConditionalTime;
	private int c1 = RobotValues.AutoConditional1;
	private int c2 = RobotValues.AutoConditional2;
	
	public static boolean runFlag = true;

	Joystick joystickCustom;
	
    protected void initialize() {
    	joystickCustom = Robot.oi.getJoystickCustom();
    }

    protected void execute() {
    	
    	if(runFlag){
    		long delay = 0;
        	
        	if(joystickCustom.getRawButton(time) == true){ delay = 4000;}
        	
        	if(joystickCustom.getRawButton(c1) == false && joystickCustom.getRawButton(c2) == false){
        		AutonomousSwitcher.setFlag(1, delay);
        	}
        	else if(joystickCustom.getRawButton(c1) == true && joystickCustom.getRawButton(c2) == false){
        		AutonomousSwitcher.setFlag(2, delay);
        	}
        	else if(joystickCustom.getRawButton(c1) == false && joystickCustom.getRawButton(c2) == true){
        		AutonomousSwitcher.setFlag(3, delay);
        	}
        	else if(joystickCustom.getRawButton(c1) == true && joystickCustom.getRawButton(c2) == true) {
        		DriverStation.reportError("we here",true);
    			AutonomousSwitcher.setFlag(4, delay);
    		}
    	}
    }

    protected boolean isFinished() {
        return runFlag;
    }

    protected void end() {}

    protected void interrupted() {}
}
