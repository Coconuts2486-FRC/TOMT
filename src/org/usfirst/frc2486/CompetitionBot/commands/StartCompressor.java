package org.usfirst.frc2486.CompetitionBot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2486.CompetitionBot.Robot;

public class StartCompressor extends Command {
	
    public StartCompressor() {
        requires(Robot.gearBox);
    }

    protected void initialize() {
    	Robot.gearBox.setClosedLoopControl();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
