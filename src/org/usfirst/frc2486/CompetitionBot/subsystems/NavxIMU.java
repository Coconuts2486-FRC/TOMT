
package org.usfirst.frc2486.CompetitionBot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc2486.CompetitionBot.RobotMap;

//import com.kauailabs.navx.frc.AHRS;

public class NavxIMU extends Subsystem{

	//private AHRS navx = RobotMap.navx;
	//private boolean state = false;
	
	protected void initDefaultCommand() {
		//if(navx != null){
			//state = true;
		//}
	}
	
	/*public float[] getangle(){
		float[] data = new float[3];
		if (state){
			data[0] = navx.getYaw();
			data[1] = navx.getPitch();
			data[2] = navx.getRoll();
		}else{
			data[0] = 0;
			data[1] = 0;
			data[2] = 0;
		}
		return data;
	}
	*/
}
