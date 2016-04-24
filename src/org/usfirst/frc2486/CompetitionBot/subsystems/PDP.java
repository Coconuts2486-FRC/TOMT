package org.usfirst.frc2486.CompetitionBot.subsystems;

import org.usfirst.frc2486.CompetitionBot.RobotMap;
import org.usfirst.frc2486.CompetitionBot.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PDP extends Subsystem {

    private final PowerDistributionPanel powerDistributionPanel = RobotMap.pDPPowerDistributionPanel;
    private final CANTalon talonS1 = RobotMap.shooterTalonS1;
    private final CANTalon talonS2 = RobotMap.shooterTalonS2;
    private final CANTalon talonG1 = RobotMap.grapplingTalonG1;
    private final CANTalon talonG2 = RobotMap.grapplingTalonG2;
    private final Compressor compressor = RobotMap.gearBoxCompressor;
    private final Solenoid gearShift = RobotMap.gearBoxGearShift;
    private final CANTalon talonRl = RobotMap.driveTrainTalonRl;
    private final CANTalon talonRr = RobotMap.driveTrainTalonRr;
    private final CANTalon talonFr = RobotMap.driveTrainTalonFr;
    private final CANTalon talonFl = RobotMap.driveTrainTalonFl;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    public void initDefaultCommand() {
    	setDefaultCommand(new ReturnData());
    }
    
    public void PDPInit() {
		powerDistributionPanel.startLiveWindowMode();
	}
    public void returnCanIndexShooter() {
		SmartDashboard.putNumber("Motor 1 Current",talonS1.getOutputCurrent());
		SmartDashboard.putNumber("Motor 1 Voltage", talonS1.getOutputVoltage());
		SmartDashboard.putNumber("Motor 2 Current", talonS2.getOutputCurrent());
		SmartDashboard.putNumber("Motor 2 Voltage", talonS2.getOutputVoltage());
	}
}
