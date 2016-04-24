package org.usfirst.frc2486.CompetitionBot.subsystems;

import org.usfirst.frc2486.CompetitionBot.RobotMap;
import org.usfirst.frc2486.CompetitionBot.commands.*;
import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Grappling extends Subsystem {

    private final CANTalon talonG1 = RobotMap.grapplingTalonG1;
    private final CANTalon talonG2 = RobotMap.grapplingTalonG2;

    public void initDefaultCommand() {
        setDefaultCommand(new StopGrapple());
    }
}
