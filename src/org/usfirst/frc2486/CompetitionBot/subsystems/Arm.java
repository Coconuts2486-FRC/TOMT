package org.usfirst.frc2486.CompetitionBot.subsystems;

import org.usfirst.frc2486.CompetitionBot.Robot;
import org.usfirst.frc2486.CompetitionBot.RobotMap;
import org.usfirst.frc2486.CompetitionBot.commands.*;

import edu.wpi.first.wpilibj.CANSpeedController.ControlMode;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {
    private final CANTalon talonA1 = RobotMap.armTalonA1;

    public void initDefaultCommand() {
    	setDefaultCommand(new StopArm());
    	
    	/*talonA1.reset();
        talonA1.setProfile(0);
        talonA1.setF(0.0);
        talonA1.setP(0.0);
        talonA1.setI(0.1); 
        talonA1.setD(0.0);    
    	talonA1.setAllowableClosedLoopErr(0);
        talonA1.configNominalOutputVoltage(+0f, -0f);
        talonA1.configPeakOutputVoltage(+12f, -12f);
        talonA1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        talonA1.enableControl();
        talonA1.setEncPosition(0);
        */
    }
    public void setPosition(double val){
    	talonA1.changeControlMode(TalonControlMode.Position);
    	if(Math.abs((val) - talonA1.get()) > 0.05){
    		talonA1.set(val);
    	}
    }
    public void setPower(double val){
    	talonA1.changeControlMode(TalonControlMode.PercentVbus);
    	talonA1.set(val);
    }
    public void setPower(double val, long time){
    	talonA1.changeControlMode(TalonControlMode.PercentVbus);
    	talonA1.set(val);
    	Robot.driveTrain.sleep(time);
    }
    public void reset(){
    	talonA1.reset();
        talonA1.setProfile(0);
        talonA1.setF(0.0);
        talonA1.setP(0.0);
        talonA1.setI(0.1); 
        talonA1.setD(0.0);    
    	talonA1.setAllowableClosedLoopErr(0);
        talonA1.configNominalOutputVoltage(+0f, -0f);
        talonA1.configPeakOutputVoltage(+12f, -12f);
        talonA1.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        talonA1.enableControl();
        talonA1.setEncPosition(0);
    }
    public double get(){
    	talonA1.changeControlMode(TalonControlMode.Position);
    	return talonA1.get();
    }
}

