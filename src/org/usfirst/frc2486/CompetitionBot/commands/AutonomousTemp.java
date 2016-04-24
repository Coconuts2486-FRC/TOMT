package org.usfirst.frc2486.CompetitionBot.commands;

import org.usfirst.frc2486.CompetitionBot.Robot;
import org.usfirst.frc2486.CompetitionBot.functions.FunctionGenerator;
import org.usfirst.frc2486.CompetitionBot.functions.LinearFunciton;
import org.usfirst.frc2486.CompetitionBot.functions.SpotChecker;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousTemp extends Command {

	public static boolean done = false;

	public static double currentAngle;

	public static void step1() {
		final double maxMultiplicity = 2.0;
		final double minMultiplicity = 1;
		final double interval = 100;
		final double rate = 0.2;
		SmartDashboard.putString("x", "y");
		final FunctionGenerator functionGenerator = new FunctionGenerator(maxMultiplicity, minMultiplicity,
				interval);

		for (double x = 0; x <= interval; x += rate) {
			final double speed = functionGenerator.function(x);
			SmartDashboard.putString("x", "z");
			SmartDashboard.putNumber("Speed", speed);
			SmartDashboard.putNumber("Interval", interval - x);
			SmartDashboard.putNumber("Yaw", Robot.ahrs.getYaw());
			Robot.driveTrain.drive(-0.3, -speed * 3);
			Robot.driveTrain.sleep(5);
			// 77 is a right angle
			if (interval - x < 70) {
				break;
			}
		}
		Robot.driveTrain.drive(-0.3, 0);
		Robot.driveTrain.sleep(300);
	}

	public static double trigAngle(double theta) {
		theta *= Math.PI / 180;
		return Math.cos(theta) * Robot.ahrs.getYaw();
	}

	public LinearFunciton linearFunction = new LinearFunciton(80, .5, 115, 1.5);

	Timer timer = new Timer();

	Timer timer2 = new Timer();
	Joystick joystick = Robot.oi.joystickLeft;

	public AutonomousTemp(){
		requires(Robot.shooter);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("getZ", joystick.getZ());
		SpotChecker.run();
		if (done == false) {

			if (joystick.getZ() >= 0.5) {
				// Robot.arm.setPower(-1, 1000);
				// Robot.arm.setPower(0);
				Robot.driveTrain.drive(-.85, -.85, 3500);
				Robot.driveTrain.drive(0, 0);
				// Robot.arm.setPower(0.35, 1000);
				// Robot.arm.setPower(0);
			}

			else {
				// Fire the ball
				// shoot();
				// Turn away from wall
				// step1();
				turn();
				Robot.driveTrain.drive(-0.75, -0.75);
				Robot.driveTrain.sleep(500);
				// Align to 90 degrees
				step2();
				// final Drive over low bar
				step3();
				Robot.driveTrain.sleep(350);
				// Drive back
				step4();
				Robot.driveTrain.sleep(350);
				step5();

			}
			Robot.driveTrain.drive(0, 0);
			done = true;
		}
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	public void shoot() {
		currentAngle = Robot.ahrs.getYaw();
		// Rev up motors
		Robot.shooter.setSpeed(12);
		Robot.driveTrain.sleep(300);
		// Fire the piston
		Robot.shooterPiston.set(true);
		Robot.driveTrain.sleep(350);
		Robot.shooterPiston.set(false);
		// Bring arm down
		Robot.arm.setPower(-0.5, 200);
		Robot.shooter.setSpeed(0);
	}

	public void step2() {
		SmartDashboard.putNumber("Desired Angle", 0);
		final double desiredAngle = 82 + currentAngle;
		SmartDashboard.putNumber("Desired Angle", desiredAngle);
		SmartDashboard.putNumber("Current Angle", Robot.ahrs.getYaw());
		// setBrakeMode code is experimental, use at own risk!
		Robot.driveTrain.setBrakeMode(true);
		while (Robot.ahrs.getYaw() > desiredAngle) {
			Robot.driveTrain.drive(-linearFunction.y(Robot.ahrs.getYaw()) / 1.35,
					linearFunction.y(Robot.ahrs.getYaw()) / 1.35);
			SmartDashboard.putNumber("Current Angle", Robot.ahrs.getYaw());
			SmartDashboard.putNumber("Speed", -linearFunction.y(Robot.ahrs.getYaw()) / 1.35);
		}
		Robot.driveTrain.setBrakeMode(false);
	}

	public void step3() {
		while (Robot.ahrs.getRoll() < -7) {
			Robot.driveTrain.drive(-0.7, -0.7);
			SmartDashboard.putNumber("Step", 1);
			SmartDashboard.putNumber("Roll", Robot.ahrs.getRoll());
		}
		Robot.driveTrain.drive(-0.85, -0.85);
		SmartDashboard.putNumber("Step", 2);
		SmartDashboard.putNumber("Roll", Robot.ahrs.getRoll());
		Robot.driveTrain.sleep(50);
	}

	private void step4() {
		while (Robot.ahrs.getRoll() > -17) {
			Robot.driveTrain.drive(0.7, 0.7);
		}
		Robot.driveTrain.drive(0.85, 0.85);
		SmartDashboard.putNumber("Step", 2);
		SmartDashboard.putNumber("Roll", Robot.ahrs.getRoll());
		Robot.driveTrain.sleep(100);
	}

	private void step5() {
		while (Robot.ahrs.getRoll() < -7) {
			Robot.driveTrain.drive(-0.7, -0.7);
		}
		Robot.driveTrain.drive(-0.85, -0.85);
		SmartDashboard.putNumber("Step", 2);
		SmartDashboard.putNumber("Roll", Robot.ahrs.getRoll());
		Robot.driveTrain.sleep(50);

	}

	public void turn() {
		while (Robot.ahrs.getYaw() < 83.5) {
			Robot.driveTrain.drive(0, -0.85);
		}
	}

}
