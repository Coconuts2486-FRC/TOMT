package org.usfirst.frc2486.CompetitionBot.commands;

import org.usfirst.frc2486.CompetitionBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RevLow extends Command{

	public RevLow() {
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.shooter.setSpeed(8.0);
		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
