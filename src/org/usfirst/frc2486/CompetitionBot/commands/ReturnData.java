package org.usfirst.frc2486.CompetitionBot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2486.CompetitionBot.Robot;

public class ReturnData extends Command {

    public ReturnData() {
        requires(Robot.pDP);
    }

    protected void initialize() {}

    protected void execute() {}

    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {}

    protected void interrupted() {}
}
