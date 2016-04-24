package org.usfirst.frc2486.CompetitionBot.subsystems;

import org.usfirst.frc2486.CompetitionBot.RobotMap;
import org.usfirst.frc2486.CompetitionBot.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Shooter subsystem
 */

public class Shooter extends Subsystem {

    private final CANTalon talonS1 = RobotMap.shooterTalonS1;
    private final CANTalon talonS2 = RobotMap.shooterTalonS2;

    public void initDefaultCommand() {
        setDefaultCommand(new StopShooter());

    }
    
    public void stop(){
    	talonS1.set(0);
    }
    
    //Reversal necessary here
    public void setSpeed(double val){ 
        talonS1.changeControlMode(TalonControlMode.Voltage);
        talonS2.changeControlMode(TalonControlMode.Follower);
        talonS2.set(talonS1.getDeviceID());
    	talonS1.set(-val);
    }
}

