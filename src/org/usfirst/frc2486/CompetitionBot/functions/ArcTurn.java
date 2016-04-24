package org.usfirst.frc2486.CompetitionBot.functions;

	class ArcTurn
	{
		private final FunctionGenerator functionGenerator;
		private final double rate;

		public ArcTurn(FunctionGenerator functionGenerator, double rate)
		{
			this.functionGenerator = functionGenerator;
			this.rate = rate;
		}

		public double forLoop()
		{
			final double interval = functionGenerator.getInterval();
			for (double x = interval; x >= -interval; x = x - rate)
				return functionGenerator.function(x);
			return 0;
		}
	}