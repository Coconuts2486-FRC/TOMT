package org.usfirst.frc2486.CompetitionBot;

import org.usfirst.frc2486.CompetitionBot.commands.AutonomousTemp;
import org.usfirst.frc2486.CompetitionBot.commands.StartCompressor;
import org.usfirst.frc2486.CompetitionBot.functions.SpotChecker;
import org.usfirst.frc2486.CompetitionBot.subsystems.Arm;
import org.usfirst.frc2486.CompetitionBot.subsystems.Camera;
import org.usfirst.frc2486.CompetitionBot.subsystems.DriveTrain;
import org.usfirst.frc2486.CompetitionBot.subsystems.GearBox;
import org.usfirst.frc2486.CompetitionBot.subsystems.Grappling;
import org.usfirst.frc2486.CompetitionBot.subsystems.LightManager;
import org.usfirst.frc2486.CompetitionBot.subsystems.Shooter;
import org.usfirst.frc2486.CompetitionBot.subsystems.ShooterPiston;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;

	public static DriveTrain driveTrain;
	public static GearBox gearBox;
	public static Arm arm;
	public static Subsystem pDP;
	public static Grappling grappling;
	public static Shooter shooter;
	public static Camera camera;
	public static LightManager lightManager;
	public static ShooterPiston shooterPiston;
	public static StartCompressor startCompressor;
	public static AHRS ahrs;

	public static void putAHRSData() {
		SmartDashboard.putNumber("Yaw", ahrs.getYaw());
		SmartDashboard.putNumber("Pitch", ahrs.getPitch());
		SmartDashboard.putNumber("Roll", ahrs.getRoll());
		SmartDashboard.putNumber("Modified Yaw", trigAngle(38.2));
	}

	public static double trigAngle(double theta) {
		theta *= (180 / Math.PI);
		return Math.cos(theta) * Robot.ahrs.getYaw();
	}

	Command autonomousCommand;

	@Override
	public void autonomousInit() {
		AutonomousTemp.done = false;
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void disabledInit(){

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		putAHRSData();
		AutonomousTemp.done = false;
	}

	@Override
	public void robotInit() {
		RobotMap.init();
		driveTrain = new DriveTrain();
		gearBox = new GearBox();
		arm = new Arm();
		grappling = new Grappling();
		shooter = new Shooter();
		camera = new Camera();
		lightManager = new LightManager();
		shooterPiston = new ShooterPiston();
		oi = new OI();
		autonomousCommand = new AutonomousTemp();
		startCompressor = new StartCompressor();
		arm.reset();

		SmartDashboard.putString("x", "x");

		try {
			ahrs = new AHRS(SPI.Port.kMXP);
		} catch (final RuntimeException ex) {
			SmartDashboard.putString("Error", "Error instantiating navX MXP: " + ex.getMessage());
		}
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SpotChecker.run();

		SmartDashboard.putNumber("Yaw", ahrs.getYaw());
		SmartDashboard.putNumber("Roll", ahrs.getRoll());
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
