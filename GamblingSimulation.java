import java.util.*;

class GamblingSimulation
{
//US1 Initialising stack and betting amount
	static final int STACK_AMOUNT = 100 ;
	static final int BETTING_AMOUNT = 1 ;
	static final int DAYS_IN_MONTH = 20 ;

	public static void GamblingGame()
	{
		int game_result;
		int total_amount = 0;
//UC4 perform whole operation for a month
		for(int day = 1 ; day < DAYS_IN_MONTH ; day++)
			{
				game_result = STACK_AMOUNT ;
//UC3 resign for day if stack reaches more of less than 50%
				while( game_result > (STACK_AMOUNT/2) && game_result < (STACK_AMOUNT+(STACK_AMOUNT/2)) )
				{
					double game_check = Math.floor(Math.random()*10)%2;
//UC2 Betting $1 so either wins or lose
					if( game_check == 1 )
					{
						game_result = game_result + BETTING_AMOUNT ;
					}
					else
					{
						game_result = game_result - BETTING_AMOUNT ;
					}
				}
				if(game_result > STACK_AMOUNT )
				{
					System.out.println("Result of day :"+day+" is  Gambler Won $"+game_result);
				}
				else
				{
					System.out.println("Result of day :"+day+" is Gambler loss $"+game_result);
				}
				total_amount = total_amount + game_result ;
			}
			System.out.println("Total Amount after 20 days " +total_amount);
	}

	public static void main(String args[])
	{
		GamblingSimulation GamSim = new GamblingSimulation();
		GamblingGame();

	}
}
