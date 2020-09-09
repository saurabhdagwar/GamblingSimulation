import java.util.*;

class GamblingSimulation
{
//US1 Initialising stack and betting amount
	static final int STACK_AMOUNT = 100 ;
	static final int BETTING_AMOUNT = 1 ;

	public static void GamblingGame()
	{
		int game_result;
		game_result = STACK_AMOUNT ;
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
		System.out.println("Result of the game :"+game_result);
	}

	public static void main(String args[])
	{
		GamblingSimulation GamSim = new GamblingSimulation();
		GamblingGame();

	}
}
