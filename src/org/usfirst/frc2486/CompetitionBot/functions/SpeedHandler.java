package org.usfirst.frc2486.CompetitionBot.functions;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class SpeedHandler {
	
	private CANTalon Talon1;
	private CANTalon Talon2;
	private boolean mode;
	
	public SpeedHandler(CANTalon TalonMaster, CANTalon TalonSlave){
		this.mode = true;
		this.Talon1 = TalonMaster;
		this.Talon2 = TalonSlave;
	}
	
	public SpeedHandler(CANTalon talon){
		this.mode = false;
		this.Talon1 = talon;
	}
	
	public void init(){
		if(mode){
			Talon2.changeControlMode(TalonControlMode.Follower);
			Talon2.set(Talon1.getDeviceID());
		}
		Talon1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		Talon1.set(0);
	}

	public void setSpeed(double Target){
		Talon1.changeControlMode(TalonControlMode.Speed);
		Talon1.set(Target);
	}
}
