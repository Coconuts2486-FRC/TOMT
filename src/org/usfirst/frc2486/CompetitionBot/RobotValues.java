package org.usfirst.frc2486.CompetitionBot;

/**
 * Robot Value Map
 * This enables easy editing of all port id's associated with the robot
 * & drive station
 */

public final class RobotValues {

	//AVAILABLE TALONS: 1 - 12

	//Drive train talons
	public static final int TalonFR = 1;
	public static final int TalonFL = 3;
	public static final int TalonRR = 2;
	public static final int TalonRL = 4;

	//Arm talon
	public static final int TalonA1 = 9;

	//Shooter talons
	public static final int TalonS1 = 6;
	public static final int TalonS2 = 8;

	// Roller encoder
	public static final int shooterEncoderChannelA = 2;
	public static final int shooterEncoderChannelB = 3;

	//Grappling talons
	public static final int TalonG1 = 5;
	public static final int TalonG2 = 7;

	//PDP
	public static final int PDP = 0;

	//Pneumatics
	public static final int PCM = 13;
	public static final int Compressor = 13;
	public static final int GearShift = 0;
	public static final int Fire = 1;

	//Camera
	public static final String CameraID = "cam2";

	//Joysticks
	public static final int JoystickLeft = 0;
	public static final int JoystickRight = 1;
	public static final int JoystickCustom = 2;

	//Joystick Buttons
	public static final int ArmUpButton = 5;
	public static final int ArmDownButton = 6;
	public static final int GearShiftButton = 1;
	public static final int RevUpButton = 4;
	public static final int FireButton = 6;
	public static final int GrappleButton = 8;
	public static final int RevBackButton = 1;
	public static final int TrackingSwitch = 9;
	public static final int AutoConditional1 = 4;
	public static final int AutoConditional2 = 6;
	public static final int AutoConditionalTime = 12;
	public static final int RevSlow = 3;

	//Joystick DIO
	public static final int DONotify = 1;
	public static final int DOWarning = 2;

	//Coefficients
	public static double distanceA;
	public static double distanceB;
	public static double distanceC;
	public static double encoderA;
	public static double encoderB;
	public static double encoderC;
	public static double centerxA;
	public static double centerxC;
	public static double centerxB;
}
