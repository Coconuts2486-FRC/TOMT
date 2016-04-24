package org.usfirst.frc2486.CompetitionBot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap {

	//public static AHRS navx;

	public static CANTalon driveTrainTalonRl;
	public static CANTalon driveTrainTalonRr;
	public static CANTalon driveTrainTalonFr;
	public static CANTalon driveTrainTalonFl;
	public static RobotDrive driveTrainRobotDrive;
	public static Compressor gearBoxCompressor;
	public static Solenoid gearBoxGearShift;
	public static CANTalon armTalonA1;
	public static PowerDistributionPanel pDPPowerDistributionPanel;
	public static CANTalon grapplingTalonG1;
	public static CANTalon grapplingTalonG2;
	public static CANTalon shooterTalonS1;
	public static CANTalon shooterTalonS2;
	public static Solenoid shooterPistonFireSol;
	public static Encoder rollerEncoder;
	public static CANTalon rollerTalon;
	public static CameraServer server;

	private static int TFR = RobotValues.TalonFR;
	private static int TFL = RobotValues.TalonFL;
	private static int TRR = RobotValues.TalonRR;
	private static int TRL = RobotValues.TalonRL;
	private static int A = RobotValues.TalonA1;
	private static int G1 = RobotValues.TalonG1;
	private static int G2 = RobotValues.TalonG2;
	private static int S1 = RobotValues.TalonS1;
	private static int S2 = RobotValues.TalonS2;
	private static int PDP = RobotValues.PCM;
	private static int PCM = RobotValues.PCM;
	private static int C = RobotValues.Compressor;
	private static int GS = RobotValues.GearShift;
	private static int FS = RobotValues.Fire;
	private static int SEA = RobotValues.shooterEncoderChannelA;
	private static int SEB = RobotValues.shooterEncoderChannelB;

	public static void init() {

		/*try {
            navx = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex ) {
        	navx = null;
        }
		 */

		rollerEncoder = new Encoder(SEA, SEB);


		driveTrainTalonRl = new CANTalon(TRL);
		LiveWindow.addActuator("Drive Train", "TalonRl", driveTrainTalonRl);

		driveTrainTalonRr = new CANTalon(TRR);
		LiveWindow.addActuator("Drive Train", "TalonRr", driveTrainTalonRr);

		driveTrainTalonFr = new CANTalon(TFR);
		LiveWindow.addActuator("Drive Train", "TalonFr", driveTrainTalonFr);

		driveTrainTalonFl = new CANTalon(TFL);
		LiveWindow.addActuator("Drive Train", "TalonFl", driveTrainTalonFl);

		driveTrainRobotDrive = new RobotDrive(driveTrainTalonFl, driveTrainTalonRl,
				driveTrainTalonFr, driveTrainTalonRr);

		driveTrainRobotDrive.setSafetyEnabled(false);
		driveTrainRobotDrive.setExpiration(0.1);
		driveTrainRobotDrive.setSensitivity(0.5);
		driveTrainRobotDrive.setMaxOutput(1.0);

		gearBoxCompressor = new Compressor(C);


		gearBoxGearShift = new Solenoid(PCM, GS);
		LiveWindow.addActuator("GearBox", "GearShift", gearBoxGearShift);

		armTalonA1 = new CANTalon(A);
		LiveWindow.addActuator("Arm", "TalonA1", armTalonA1);

		pDPPowerDistributionPanel = new PowerDistributionPanel(PDP);
		LiveWindow.addSensor("PDP", "PowerDistributionPanel", pDPPowerDistributionPanel);

		grapplingTalonG1 = new CANTalon(G1);
		LiveWindow.addActuator("Grappling", "TalonG1", grapplingTalonG1);

		grapplingTalonG2 = new CANTalon(G2);
		LiveWindow.addActuator("Grappling", "TalonG2", grapplingTalonG2);

		shooterTalonS1 = new CANTalon(S1);
		LiveWindow.addActuator("Shooter", "TalonS1", shooterTalonS1);

		shooterTalonS2 = new CANTalon(S2);
		LiveWindow.addActuator("Shooter", "TalonS2", shooterTalonS2);

		shooterPistonFireSol = new Solenoid(PCM, FS);
		LiveWindow.addActuator("Shooter Piston", "FireSol", shooterPistonFireSol);
	}
}
