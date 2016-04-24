package org.usfirst.frc2486.CompetitionBot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2486.CompetitionBot.Robot;

public class TankDrive extends Command {

    public TankDrive() {
        requires(Robot.driveTrain);
    }

    Joystick left;
    Joystick right;
    
    protected void initialize() {
    	left = Robot.oi.getJoystickLeft();
    	right = Robot.oi.getJoystickRight();
    }

    
    protected void execute() {
    	double[] choody = driveStraight(left.getY(), right.getY());
    	Robot.driveTrain.drive(choody[0], choody[1]);
    	SmartDashboard.putNumber("Left Value", choody[0]);
    	SmartDashboard.putNumber("Right Value", choody[1]); 
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.driveTrain.stop();
    }

    protected void interrupted() {
    	end();
    }
    
    public static double[] driveStraight(double leftValue, double rightValue) {
    	double ratio = leftValue / rightValue;
    	double avgValue;
    	
    	if (ratio > .8 && ratio < 1.2) {
    		avgValue = (leftValue + rightValue) / 2;
    		return new double[] {avgValue, avgValue};
    	}
    	else {
    		return new double[] {leftValue, rightValue};
    	}
    }
}
