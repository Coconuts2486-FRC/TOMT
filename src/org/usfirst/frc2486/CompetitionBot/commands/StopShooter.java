package org.usfirst.frc2486.CompetitionBot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2486.CompetitionBot.Robot;

public class StopShooter extends Command {

    public StopShooter() {
        requires(Robot.shooter);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.shooter.stop();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
