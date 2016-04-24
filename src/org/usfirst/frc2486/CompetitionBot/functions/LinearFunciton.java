package org.usfirst.frc2486.CompetitionBot.functions;

public class LinearFunciton {

	private final double x1;
	private final double x2;
	private final double y1;
	private final double y2;
	private final double slope;
	private final double yIntercept;

	public LinearFunciton(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;

		slope = m();
		yIntercept = b();

	}

	private double b() {
		return y1 - (slope * x1);
	}

	private double m() {
		return (y2 - y1) / (x2 - x1);
	}

	public double y(double x) {
		return slope * x + yIntercept;
	}

}
