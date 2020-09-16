import java.util.*;
import java.io.*;
class GamblingSimulation
{
//US1 Initialising stack and betting amount
	static final int STACKAMOUNT = 100 ;
	static final int BETTINGAMOUNT = 1 ;
	static final int DAYSINMONTH = 30 ;
	public static void GamblingGame()
	{
		int gameResult;
		ArrayList<Integer> luckiestDay= new ArrayList<Integer>(); 
		ArrayList<Integer> unluckiestDay= new ArrayList<Integer>();
		int monthlyInvestmentAmount = 0;
		int totalAmount = 0;
// UC4 for a month find total amount 
		for(int day = 1 ; day <= DAYSINMONTH ; day++)
		{
			gameResult = STACKAMOUNT ;
//UC3 resign for day if stack reaches more of less than 50%
			while( gameResult > (STACKAMOUNT/2) && gameResult < (STACKAMOUNT+(STACKAMOUNT/2)) )
			{
				double gameCheck = Math.floor(Math.random()*10)%2;
//UC2 Betting $1 so either wins or lose
				if( gameCheck == 1 )
				{
					gameResult = gameResult + BETTINGAMOUNT ;
				}
				else
				{
					gameResult = gameResult - BETTINGAMOUNT ;
				}
			}
			if(gameResult > STACKAMOUNT )
			{
				System.out.println("Result of day :"+day+" is  Gambler Won $"+gameResult);
				luckiestDay.add(day);
			}
			else
			{
				System.out.println("Result of day :"+day+" is Gambler loss $"+gameResult);
				unluckiestDay.add(day);
			}
//UC5 Total month result by how much amount
			monthlyInvestmentAmount = monthlyInvestmentAmount + STACKAMOUNT;
			totalAmount = totalAmount + gameResult ;
		}
		System.out.println("Total Amount after a month " +totalAmount);
		System.out.println("Total investment Amount after a month " +monthlyInvestmentAmount);
		if(totalAmount > monthlyInvestmentAmount )
		{
			System.out.println("Gambler won $"+(totalAmount-monthlyInvestmentAmount));
		}
		else
		{
			System.out.println("Gambler lost $"+(monthlyInvestmentAmount-totalAmount));
		}
//UC6 Luckiest and Unluckiest days in month
		System.out.print("Luckiest days in months are : ");
		System.out.println(" "+luckiestDay);
		System.out.print("Unluckiest days in months are : ");
		System.out.println(" "+unluckiestDay);
	}
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int user_decide = 1;
//UC7 if player would like to continuee for next month or not
		while(user_decide != 2)
		{
			GamblingGame();
			System.out.println("Press 2 for quit game or any number to continue for next month ");
			user_decide=scan.nextInt();

		}

	}
}
