package org.usfirst.frc2486.CompetitionBot.subsystems;

import org.usfirst.frc2486.CompetitionBot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterPiston extends Subsystem {
	
    private final Solenoid fireSol = RobotMap.shooterPistonFireSol;
    
    public void initDefaultCommand() {}
    
    public void set(boolean state){
    	fireSol.set(state);
    }
}
