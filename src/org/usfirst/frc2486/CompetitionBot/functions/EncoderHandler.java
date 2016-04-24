package org.usfirst.frc2486.CompetitionBot.functions;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class EncoderHandler {
	private CANTalon talon;
	private CANTalon talon2;
	private Encoder encoder;
	private Encoder encoder2;
	
	int basevalue;
	int basevalue2;
	
	public EncoderHandler(CANTalon driveEncoderMotor, CANTalon driveEncoderMotor2, Encoder encoder, Encoder encoder2){
		this.talon = driveEncoderMotor;
		this.talon2 = driveEncoderMotor;
		this.encoder = encoder;
		this.encoder2 = encoder2;
	}
	
	public EncoderHandler(CANTalon driveEncoderMotor, Encoder encoder){
		this.talon = driveEncoderMotor;
		this.encoder = encoder;
	}
	
	public void init(){
		talon.set(0);
		talon2.set(0);
		encoder.reset();
		encoder2.reset();
	}
	
	public int getCurrentEncoderAmount(){
		return encoder.get();
	}
	
	public int getCurrentEncoderAmount2() {
		return encoder2.get();
	}
	
	public boolean runTo(int amt, double speed){
		basevalue = encoder.get();
		basevalue2 = encoder2.get();
		
		if(amt > 0){
			while(basevalue + amt > getCurrentEncoderAmount()){
				talon.set(speed);
				talon2.set(speed);
			}	
		}
		if (amt < 0) {
			while(basevalue + amt < getCurrentEncoderAmount()) {
				talon.set(-speed);
				talon.set(speed);
			}
		}
		if(basevalue + amt == getCurrentEncoderAmount()){
			talon.set(0);
			talon.set(0);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean runTo(int amt1, int amt2, double speed) {
		basevalue = encoder2.get();
		
		if (amt1 > 0) {
			while(basevalue + amt1 > getCurrentEncoderAmount()) {
				talon.set(speed);
			}
		}
		if(amt1 < 0) {
			while(basevalue + amt1 > getCurrentEncoderAmount()) {
				talon.set(-speed);
			}
		}
				
		if (amt2 > 0) {
			while (basevalue + amt2 > getCurrentEncoderAmount2()) {
				talon2.set(speed);
			}
		}
		if (amt2 < 0) {
			while (basevalue + amt2 > getCurrentEncoderAmount2()) {
				talon2.set(-speed);
			}
		}
		if (basevalue + amt2 == getCurrentEncoderAmount2() && basevalue + amt1 == getCurrentEncoderAmount()) {
			talon2.set(0);
			return true;
		}
		else {
			return false;
		}
	}
}