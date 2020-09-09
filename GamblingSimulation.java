import java.util.*;
import java.io.*;

class GamblingSimulation
{
//US1 Initialising stack and betting amount
	static final int STACK_AMOUNT = 100 ;
	static final int BETTING_AMOUNT = 1 ;
	static final int DAYS_IN_MONTH = 30 ;

	public static void GamblingGame()
	{
		int game_result;
		ArrayList<Integer> luckiest_day= new ArrayList<Integer>(); 
		ArrayList<Integer> unluckiest_day= new ArrayList<Integer>();
		int monthly_investment_amount = 0;
		int total_amount = 0;

// UC4 for a month find total amount 
		for(int day = 1 ; day <= DAYS_IN_MONTH ; day++)
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
					luckiest_day.add(day);
				}
				else
				{
					System.out.println("Result of day :"+day+" is Gambler loss $"+game_result);
					unluckiest_day.add(day);

				}
//UC5 Total month result by how much amount
				monthly_investment_amount = monthly_investment_amount + STACK_AMOUNT;
				total_amount = total_amount + game_result ;
			}
			System.out.println("Total Amount after a month " +total_amount);
			System.out.println("Total investment Amount after a month " +monthly_investment_amount);
			if(total_amount > monthly_investment_amount )
			{
				System.out.println("Gambler won $"+(total_amount-monthly_investment_amount));
			}
			else
			{
				System.out.println("Gambler lost $"+(monthly_investment_amount-total_amount));
			}
//UC6 Luckiest and Unluckiest days in month
			System.out.print("Luckiest days in months are : ");
			System.out.println(" "+luckiest_day);

			System.out.print("Unluckiest days in months are : ");
			System.out.println(" "+unluckiest_day);


	}

	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int user_decide = 1;
		GamblingSimulation GamSim = new GamblingSimulation();
//UC7 if player would like to continuee for next month or not
		while(user_decide != 2)
		{
			GamblingGame();
			System.out.println("Press 2 for quit game or any number to continue for next month ");
			user_decide=scan.nextInt();

		}

	}
}
