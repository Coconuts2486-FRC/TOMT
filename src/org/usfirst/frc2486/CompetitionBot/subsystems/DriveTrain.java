package org.usfirst.frc2486.CompetitionBot.subsystems;

import org.usfirst.frc2486.CompetitionBot.RobotMap;
import org.usfirst.frc2486.CompetitionBot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	private final CANTalon talonRl = RobotMap.driveTrainTalonRl;
	private final CANTalon talonRr = RobotMap.driveTrainTalonRr;
	private final CANTalon talonFr = RobotMap.driveTrainTalonFr;
	private final CANTalon talonFl = RobotMap.driveTrainTalonFl;
	private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

	public void drive(double left, double right) {
		robotDrive.tankDrive(left, right);
	}

	public void drive(double left, double right, long time){
		robotDrive.tankDrive(left, right);
		sleep(time);
	}

	public void init(){
		robotDrive.setSafetyEnabled(false);
		talonFl.enableBrakeMode(true);
		talonFr.enableBrakeMode(true);
		talonRl.enableBrakeMode(true);
		talonRr.enableBrakeMode(true);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
		talonFl.enableBrakeMode(true);
		talonFr.enableBrakeMode(true);
		talonRl.enableBrakeMode(true);
		talonRr.enableBrakeMode(true);
	}

	public void setBrakeMode(boolean state) {
		talonFl.enableBrakeMode(state);
		talonFr.enableBrakeMode(state);
		talonRl.enableBrakeMode(state);
		talonRr.enableBrakeMode(state);
	}
	public void sleep(long time){
		try{ Thread.sleep(time);}
		catch(final InterruptedException ex){};
	}
	public void stop(){
		robotDrive.stopMotor();
	}
}
