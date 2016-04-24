package org.usfirst.frc2486.CompetitionBot.subsystems;

import org.usfirst.frc2486.CompetitionBot.Robot;
import org.usfirst.frc2486.CompetitionBot.RobotValues;
import org.usfirst.frc2486.CompetitionBot.commands.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LightManager extends Subsystem {
	
	int WL = RobotValues.DOWarning;
	int NL = RobotValues.DONotify;
	Joystick MSP;
	DriverStation DR;

    public void initDefaultCommand() {
    	
    	MSP = Robot.oi.getJoystickCustom();
    	DR = DriverStation.getInstance();
    	MSP.setOutput(NL, true);
    	MSP.setOutput(WL, true);

    }
    public void setNotify(boolean state){
    	MSP.setOutput(NL, state);
    }
    public void setWarning(boolean state){
    	MSP.setOutput(WL, state);
    }
}

