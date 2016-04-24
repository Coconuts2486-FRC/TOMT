package org.usfirst.frc2486.CompetitionBot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2486.CompetitionBot.Robot;

public class RevFull extends Command {

    public RevFull() {
        requires(Robot.shooter);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.shooter.setSpeed(12.0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
