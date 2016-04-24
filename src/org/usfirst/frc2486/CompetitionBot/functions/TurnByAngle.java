package org.usfirst.frc2486.CompetitionBot.functions;

import org.usfirst.frc2486.CompetitionBot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnByAngle {
	public static double trigAngle(double theta) {
		return Math.cos(theta) * Robot.ahrs.getYaw();
	}

	public static void turn(double desiredAngle) {
		// left: true, right: false
		while (true) {
			final double currentAngle = trigAngle(0);
			SmartDashboard.putNumber("Yaw", Robot.ahrs.getYaw());
			SmartDashboard.putNumber("Pitch", Robot.ahrs.getPitch());
			SmartDashboard.putNumber("Roll", Robot.ahrs.getRoll());
			if (currentAngle < desiredAngle) {
				Robot.driveTrain.drive(-0.25, 0.25);
			} else if (currentAngle > desiredAngle) {
				Robot.driveTrain.drive(0, 0);
				break;
			}
		}
	}
}
