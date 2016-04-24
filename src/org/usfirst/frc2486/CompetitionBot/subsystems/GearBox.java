package org.usfirst.frc2486.CompetitionBot.subsystems;

import org.usfirst.frc2486.CompetitionBot.RobotMap;
import org.usfirst.frc2486.CompetitionBot.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class GearBox extends Subsystem {
	
    private final Compressor compressor = RobotMap.gearBoxCompressor;
    private final Solenoid gearShift = RobotMap.gearBoxGearShift;

    public void initDefaultCommand() {
        setDefaultCommand(new StartCompressor());
    }
    
    public void setClosedLoopControl(){
    	compressor.clearAllPCMStickyFaults();
    	gearShift.clearAllPCMStickyFaults();
    	compressor.setClosedLoopControl(true);
    }
    
    public void setSolenoid(boolean mode){
    	gearShift.set(mode);
    }
    
    public void toggleSolenoid(){
    	if(gearShift.get()){
    		gearShift.set(false);
    	}else{
    		gearShift.set(true);
    	}
    }  
}

