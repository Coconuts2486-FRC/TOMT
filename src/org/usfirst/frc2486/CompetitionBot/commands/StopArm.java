package org.usfirst.frc2486.CompetitionBot.commands;

import org.usfirst.frc2486.CompetitionBot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StopArm extends Command {

	private Joystick JoystickCustom;

	public StopArm() {
		requires(Robot.arm);
		//Robot.arm.reset();
	}

	@Override
	protected void end() {}

	@Override
	protected void execute() {
		SmartDashboard.putDouble("Enc", Robot.arm.get());
		if(JoystickCustom.getPOV() == 0){
			Robot.arm.setPower(0.35);
		}else if(JoystickCustom.getPOV() == 180){
			Robot.arm.setPower(-0.65);
		}else{
			Robot.arm.setPower(0);
		}
	}

	@Override
	protected void initialize() {
		JoystickCustom = Robot.oi.joystickCustom;
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
