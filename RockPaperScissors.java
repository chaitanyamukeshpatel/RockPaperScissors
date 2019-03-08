/* Name: Chaitanya Mukesh Patel
   ID: A15346478 
   Email: c2patel@ucsd.edu
*/

/** 
 * Class RockPaperScissors.  Plays repeated games of Rock Paper Scissors with a user 
 * @author Chaitanya Mukesh Patel
 * @date 10/06/2017
 * */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors
{
  
  public static void main( String[] args )
  {
    int initialCapacity = 5;
    // Store the user's move history
    String[] userMoves = new String[initialCapacity];  
    // Store the System's move history
    LinkedList<String> systemMoves = new LinkedList<String>();  
    int round=0;
    double user_wins=0;
    double system_wins=0;
    double ties=0;
    char userinput = 'a';
    
    /*Do-while loop keeps the program running until the user asks to quit*/
    do {
    	
    	try {
    		systemMoves.add(computer_move());
        	input(round, userMoves);
        	if((userMoves[round]=="rock" && systemMoves.get(round)=="scissors")||(userMoves[round]=="paper" && systemMoves.get(round)=="rock")||(userMoves[round]=="scissors" && systemMoves.get(round)=="paper"))
        	{
        		System.out.println("I pick " + systemMoves.get(round) + ". You win.");
        		user_wins++;
        	}
        	else if((userMoves[round]=="rock" && systemMoves.get(round)=="rock")||(userMoves[round]=="scissors" && systemMoves.get(round)=="scissors")||(userMoves[round]=="paper" && systemMoves.get(round)=="paper"))
        	{
        		System.out.println("I pick " + systemMoves.get(round) + ". It's a tie.");
        		ties++;
        	}
        	else
        	{
        		System.out.println("I pick " + systemMoves.get(round) + ". I win.");
        		system_wins++;
        	}
        	round++;
        	
    	}
    	catch(Exception expt)
    	{
    		if(expt.getMessage()=="Game quit!")
    		{
    			userinput='q';
    		}
    		else if(expt.getMessage()=="Invalid input!")
    		{
    			System.out.println("Invalid input!");
    		}
    	}
    	

    }while(userinput!='q');

    /*Code for displaying the stats and recent moves*/
    System.out.println("Thanks for playing!\n" + "Our most recent games (in reverse order) were:\n");
    for(int a=(round-1); a>=0 ; a--)
    {
    	System.out.println("Me: "+ userMoves[a] + "     " + "You:" + systemMoves.get(a));
    }
     
    System.out.println("Our overall stats are:");
    System.out.println("I won: " + (((system_wins)/(system_wins+user_wins+ties))*100) + "%    " + "You won: " + (((user_wins)/(system_wins+user_wins+ties))*100) + "%    " + "We tied: " + (((ties)/(system_wins+user_wins+ties))*100) + "%");	
  }
  /**
   * To get input from User
   * @param round A counter for the number of rounds which is also used as an index for the usermoves array
   * @param usermoves Array that stores user's input
   * @throws Exception Throws Exception when either the user asks to quit or when invalid input in entered
   */
  public static void input(int round, String usermoves[]) throws Exception
  {
	Scanner reader = new Scanner(System.in);
	System.out.println("Let's play! What's your move? (r=rock, p=paper, s=scissors or q to quit)");
  	char userinput = reader.next().charAt(0);
  	if(userinput=='r')
  	{
  		usermoves[round]="rock";
  	}
  	else if(userinput=='p')
  	{
  		usermoves[round]="paper";
  	}
  	else if(userinput=='s')
  	{
  		usermoves[round]="scissors";
  	}
  	else if(userinput=='q')
  	{
  		throw new Exception("Game quit!");
  	}
  	else
  	{
  		throw new Exception("Invalid input!");
  	}
  	
  }
  /**
   * To generate random system moves
   * @return Random move of the computer
   */
  public static String computer_move()
  {
	  String[] possible_moves = {"rock" , "paper" , "scissors"};
	  Random randomizer = new Random();
	  int n = randomizer.nextInt(3);
	  return possible_moves[n];
  }
}