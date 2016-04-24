package org.usfirst.frc2486.CompetitionBot.functions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.usfirst.frc2486.CompetitionBot.RobotValues;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CoefficientDataHandler {
	public static String fileName = "coefficients.txt";
	public static String line = null;
	
	public static int caseSwitchGet = 0;
	
	public static void getData(){
		try {
			//FileReader reads the stuff.
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null){
				SmartDashboard.putString("Current line being read", line);
				caseSwitchGet++;
			}
			
			switch(caseSwitchGet){
			case 1:
				RobotValues.distanceA = Double.parseDouble(line);
				break;
			case 2:
				RobotValues.distanceB = Double.parseDouble(line);
				break;
			case 3:
				RobotValues.distanceC = Double.parseDouble(line);
				break;
			}
			
			bufferedReader.close();
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
