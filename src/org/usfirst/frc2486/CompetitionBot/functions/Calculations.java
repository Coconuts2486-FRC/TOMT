package org.usfirst.frc2486.CompetitionBot.functions;

import org.usfirst.frc2486.CompetitionBot.RobotValues;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Calculations {
	private static NetworkTable table = NetworkTable.getTable("myContoursReport");
	
	private static double distanceA = RobotValues.distanceA;
	private static double distanceB = RobotValues.distanceB;
	private static double distanceC = RobotValues.distanceC;
	
	private static double encoderA = RobotValues.encoderA;
	private static double encoderB = RobotValues.encoderB;
	private static double encoderC = RobotValues.encoderC;
	
	private static double centerxA = RobotValues.centerxA;
	private static double centerxB = RobotValues.centerxB;
	private static double centerxC = RobotValues.centerxC;
	
	public static double chooser(double[] array){
		double sizeOfArray = array.length;
        double highestValue = 0;

        for (int i = 0; i < sizeOfArray; i++)
        {
            if (array[i] > highestValue)
            {
                highestValue = array[i];
            }
        }
        return highestValue;
	}
	//Returns current distance based on center y
    public static double distanceCalculations(){
		double[] center_y_raw = table.getNumberArray("center_y", new double[]{0});
		double center_y = chooser(center_y_raw);
		return (distanceA * Math.pow(center_y, 2)) + (distanceB * center_y) + distanceC;
	}
    //Center x should be at this location
    public static double centerxCalculations(){
    	return (centerxA * Math.pow(distanceCalculations(), 2)) + (centerxB * distanceCalculations()) + centerxC;
    }
    //Returns angle needed for shooting
	public static double encoderCalculation(){
		return (encoderA * Math.pow(distanceCalculations(), 2)) + (encoderB * distanceCalculations()) + encoderC;
	}

}
