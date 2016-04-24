package org.usfirst.frc2486.CompetitionBot.functions;

public class FunctionGenerator
{
	private final double h;
	private final double k;
	private final double a;
	private final double interval;
	private final double maxMultiplicity;

	public FunctionGenerator(double maxMultiplicity, double minMultiplicity, double interval)
	{
		this.interval = interval;
		this.maxMultiplicity = maxMultiplicity;
		h = 0;
		k = minMultiplicity;
		a = findA();
	}

	private double findA()
	{
		return (maxMultiplicity - k) / Math.pow(interval, 2);
	}

	public double function(double x)
	{
		final double y = a * Math.pow((x - h), 2) + k;
		return y;
	}

	public double getInterval()
	{
		return interval;
	}
}