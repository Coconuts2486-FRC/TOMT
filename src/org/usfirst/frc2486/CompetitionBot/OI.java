package org.usfirst.frc2486.CompetitionBot;

import org.usfirst.frc2486.CompetitionBot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * OI class
 */

public class OI {
	
	
	public JoystickButton revLowButton;
    public JoystickButton shiftLButton;
    public Joystick joystickLeft;
    public JoystickButton shiftRButton;
    public Joystick joystickRight;
    public JoystickButton revUpButton;
    public JoystickButton revBackButton;
    public JoystickButton revFullButton;
    public JoystickButton armUpButton;
    public JoystickButton armDownButton;
    public JoystickButton fireButton;
    public Joystick joystickCustom;
    
    private int JL = RobotValues.JoystickLeft;
    private int JR = RobotValues.JoystickRight;
    private int JC = RobotValues.JoystickCustom;
    
    private int RVU = RobotValues.RevUpButton;
    private int RVB = RobotValues.RevBackButton;
    private int FB = RobotValues.FireButton;
    private int GR = RobotValues.GearShiftButton;
    private int AU = RobotValues.ArmUpButton;
    private int AD = RobotValues.ArmDownButton;
    private int RL = RobotValues.RevSlow;

    public OI() {

        joystickCustom = new Joystick(JC);
        
        fireButton = new JoystickButton(joystickCustom, FB);
        fireButton.whenPressed(new Fire());
        //armDownButton = new JoystickButton(joystickCustom, AD);
        //armDownButton.whileHeld(new ArmDown());
        //armUpButton = new JoystickButton(joystickCustom, AU);
        //armUpButton.whileHeld(new ArmUp());
        revFullButton = new JoystickButton(joystickCustom, RVU);
        revFullButton.whileHeld(new RevFull());
        revBackButton = new JoystickButton(joystickCustom, RVB);
        revBackButton.whileHeld(new RevBack());
        joystickRight = new Joystick(JR);
        
        shiftRButton = new JoystickButton(joystickRight, GR);
        shiftRButton.whenPressed(new ShiftGears());
        joystickLeft = new Joystick(JL);
        
        shiftLButton = new JoystickButton(joystickLeft, GR);
        shiftLButton.whenPressed(new ShiftGears());
        
        revLowButton = new JoystickButton(joystickCustom, RL);
        revLowButton.whileHeld(new RevLow());

    }

    public Joystick getJoystickLeft() {
        return joystickLeft;
    }

    public Joystick getJoystickRight() {
        return joystickRight;
    }

    public Joystick getJoystickCustom() {
        return joystickCustom;
    }
}