package org.usfirst.frc2486.CompetitionBot.functions;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SpotChecker {
	public static NetworkTable networkTable = NetworkTable.getTable("GRIP/myContoursReport");

	static double[] center_y;
	static double[] center_x;
	static double[] width;

	public static double currentCenter_x;
	public static boolean centerX_true = false;
	public static double currentCenter_y;
	public static double currentWidth;

	static final double maxCenter_x = 399;
	static final double minCenter_x = 398;
	static final double maxCenter_y = 365;
	static final double minCenter_y = 364;
	static final double maxWidth = 300;
	static final double minWidth = 115;

	public static double chooser(double[] array)
	{
		final double sizeOfArray = array.length;
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

	public static boolean compound_inequality(double min, double max, double val){
		if(val > min && val < max)
			return true;
		else
			return false;
	}
	public static boolean run(){
		centerX_true = false;
		center_y = networkTable.getNumberArray("centerY", new double[] {0} );
		center_x = networkTable.getNumberArray("centerX", new double[] {0} );
		width = networkTable.getNumberArray("width", new double[] {0} );

		currentCenter_y = chooser(center_y);
		currentCenter_x = chooser(center_x);
		currentWidth = chooser(width);

		//SmartDashboard.putBoolean("Center X", compound_inequality(minCenter_x, maxCenter_x, currentCenter_x));
		//SmartDashboard.putBoolean("Center Y", compound_inequality(minCenter_y, maxCenter_y, currentCenter_y));
		//SmartDashboard.putBoolean("Width", compound_inequality(minWidth, maxWidth, currentWidth));
		SmartDashboard.putNumber("Current Center X", currentCenter_x);
		SmartDashboard.putNumber("Current Center Y", currentCenter_y);
		SmartDashboard.putNumber("Current Width", currentWidth);

		SmartDashboard.putBoolean("Center X Boolean", centerX_true);

		if (currentCenter_x == 0) {
			centerX_true = false;
		}

		else if (currentCenter_x < 425) {
			centerX_true = true;
			SmartDashboard.putBoolean("Center X Boolean", centerX_true);
		}

		if(compound_inequality(minCenter_x, maxCenter_x, currentCenter_x)
				|| compound_inequality(minCenter_y, maxCenter_y, currentCenter_y))
		{
			centerX_true = true;
			// SmartDashboard.putBoolean("Shoot status", true);
			// SmartDashboard.putString("Width Status", "Width is good!");
			// SmartDashboard.putString("Center X Status", "Center X is good!");
			return true;
		}
		else{
			// SmartDashboard.putBoolean("Shoot status", false);
			if(currentCenter_x < minCenter_x){
				// SmartDashboard.putString("Center X Status", "TURN LEFT");
			}
			else if(currentCenter_x > maxCenter_x){
				// SmartDashboard.putString("Center X Status", "TURN RIGHT");
			}
			else{
				// SmartDashboard.putString("Center X Status", "Center X is
				// good!");
			}
			if(center_x.length == 0){
				// SmartDashboard.putString("Center X Status", "OUTISDE OF
				// VIEWPORT");
			}
			if(currentWidth < minWidth){
				// SmartDashboard.putString("Width Status", "DRIVE FORWARD");
			}
			else if(currentWidth > minWidth){
				// SmartDashboard.putString("Width Status", "REVERSE");
			}
			else{
				// SmartDashboard.putString("Width Status", "Width is good!");
			}
			return false;
		}
	}
}
