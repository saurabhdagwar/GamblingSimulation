import java.util.*;

class GamblingSimulation
{
//US1 Initialising stack and betting amount
	static final int STACKAMOUNT = 100 ;
	static final int BETTINGAMOUNT = 1 ;
	static final int DAYSINMONTH = 20 ;
	public static void GamblingGame()
	{
		int gameresult;
		int totalamount = 0;
//UC4 perform whole operation for a month
		for(int day = 1 ; day < DAYSINMONTH ; day++)
			{
				gameresult = STACKAMOUNT ;
//UC3 resign for day if stack reaches more of less than 50%
				while( gameresult > (STACKAMOUNT/2) && gameresult < (STACKAMOUNT+(STACKAMOUNT/2)) )
				{
					double gamecheck = Math.floor(Math.random()*10)%2;
//UC2 Betting $1 so either wins or lose
					if( gamecheck == 1 )
					{
						gameresult = gameresult + BETTINGAMOUNT ;
					}
					else
					{
						gameresult = gameresult - BETTINGAMOUNT ;
					}
				}
				if(gameresult > STACKAMOUNT )
				{
					System.out.println("Result of day :"+day+" is  Gambler Won $"+gameresult);
				}
				else
				{
					System.out.println("Result of day :"+day+" is Gambler loss $"+gameresult);
				}
				totalamount = totalamount + gameresult ;
			}
			System.out.println("Total Amount after 20 days " +totalamount);
	}
	public static void main(String args[])
	{
		GamblingSimulation GamSim = new GamblingSimulation();
		GamblingGame();

	}
}
