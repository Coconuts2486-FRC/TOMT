package org.usfirst.frc2486.CompetitionBot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2486.CompetitionBot.Robot;

public class Fire extends Command {

    public Fire() {
        requires(Robot.shooterPiston);
    }

    protected void initialize() {
    	setTimeout(1);
    }

    protected void execute() {
    	Robot.shooterPiston.set(true);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.shooterPiston.set(false);
    }

    protected void interrupted() {
    	end();
    }
}
