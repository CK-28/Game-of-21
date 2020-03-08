/*Name: Christina Khidhir
 *Date: 06/12/2017
 *Purpose: Simulate a game of 21
 */
import java.awt.*;
import java.io.*;
import java.util.*;

public class gameOf21
{
    public static void main (String[] args)
    {
        //Welcome Message
        System.out.println ("****************************************************************************************************");
        System.out.println ("                                        Welcome To Game Of 21!                                      ");
        System.out.println ("****************************************************************************************************");
        System.out.println ("                                                Rules                                               ");
        System.out.println ("             Win instantly by getting a total of 21 OR win by aquiring the highest total            ");
        System.out.println ("                              If you exceed 21 you will lose right away                             ");
        System.out.println ("                 Jack = 11                   Queen = 12                   King = 13                 ");
        System.out.println ("                    To make a choice enter the corrosponding number and hit enter                   ");
        System.out.println ("****************************************************************************************************");

        //Variable Declaration
        Scanner kbscanner = new Scanner (System.in);

        int choice;

        //Input and Processing and Output
        do                                                                                                               //Runs through the game as long as the player chooses to do so.
        {
            //Create the hands for both the player and the computer (dealer).
            Hand player = new Hand ();
            Hand computer = new Hand ();

            //Shows the player the starting hands.
            System.out.println ("\nYour Hand:\n" + player.get_first() + " " + player.get_second() + " total: " + player.get_total());
            System.out.println ("Dealer's Hand:\n" + computer.get_first() + " " + computer.get_second() + " total: " + computer.get_total());                              //Dealer's second hand is only shown after the player makes a choice. (As per normal game rules).

            if (player.get_total() < 21)                                                                                 //As long as the player's hand does not exceed 21 the game carries on.
            {
                System.out.println ("\nWhat would you like to do?");
                System.out.println ("1. Hit Me");
                System.out.println ("2. Stay");
                System.out.print   ("Choice: ");
                choice = kbscanner.nextInt();
                if (choice == 1)                                                                                         //If the player chooses to recieve another card then the Hand class does so. Updated hands are outputed.
                {
                    player.hit();
                    System.out.println ("\nYour Hand:\n" + player.get_first() + " " + player.get_second() + " " + player.get_third() + " total: " + player.get_total());
                    System.out.println ("Dealer's Hand:\n" + computer.get_first() + " " + computer.get_second() + " total: " + computer.get_total());

                    if (player.get_first() == 1 || player.get_second() == 1 || player.get_third() == 1)                  //If there is an ace then the Hand class is called in order to mutate the ace into whatever aids the player the most.
                    {
                        player.ace();
                        System.out.println ("\nYour Ace(s) have been converted into 11s where possible in order to maximize your score!");
                        System.out.println ("\nYour Hand is now:\n" + player.get_first() + " " + player.get_second() + " " + player.get_third() + " total: " + player.get_total());
                    }
                }
                else                                                                                                     //If the player chooses to stay then the hands are displayed.
                {
                    System.out.println ("\nYour Hand:\n" + player.get_first() + " " + player.get_second() + " total: " + player.get_total());
                    System.out.println ("Dealer's Hand:\n" + computer.get_first() + " " + computer.get_second() + " total: " + computer.get_total());

                    if (player.get_first() == 1 || player.get_second() == 1)                                             //If there is an ace then the Hand class is called in order to mutate the ace into whatever aids the player the most.
                    {
                        player.ace();
                        System.out.println ("\nYour Ace(s) have been converted into 11s where possible in order to maximize your score!");
                        System.out.println ("\nYour Hand is now:\n" + player.get_first() + " " + player.get_second() + " total: " + player.get_total());
                    }
                }
            }

            if (player.get_total() < 21 && computer.get_total() < 21)                                                    //As long as the Dealer's hand does not exceed 21 the game carries on.
            {
                //The dealer's choice to get another card or stay is done through evaluating their chances. For example, if the dealer is currently losing then they might as well draw another card in hopes of exceeding the player's total yet remaining under or equal to 21.
                if (computer.get_total() < player.get_total())                                                          //If the dealer chooses to recieve another card then the Hand class does so. Updated hands are outputed.
                {
                    computer.hit();
                    System.out.println ("\nDealer chooses Hit Me");
                    System.out.println ("\nYour Hand:\n" + player.get_first() + " " + player.get_second() + " " + player.get_third() + " total: " + player.get_total());
                    System.out.println ("Dealer's Hand:\n" + computer.get_first() + " " + computer.get_second() + " " + computer.get_third() + " total: " + computer.get_total());

                    if (computer.get_first() == 1 || computer.get_second() == 1 || computer.get_third() == 1)            //If there is an ace then the Hand class is called in order to mutate the ace into whatever aids the dealer the most.
                    {
                        computer.ace();
                        System.out.println ("\nDealer's Ace(s) have been converted into 11s where possible in order to maximize their score!");
                        System.out.println ("\nDealer's Hand is now:\n" + computer.get_first() + " " + computer.get_second() + " " + computer.get_third() + " total: " + computer.get_total());
                    }
                }
                else                                                                                                     //If the dealer chooses to stay then the hands are displayed.
                {
                    System.out.println ("\nDealer chooses to stay");
                    System.out.println ("\nYour Hand:\n" + player.get_first() + " " + player.get_second() + " total: " + player.get_total());
                    System.out.println ("Dealer's Hand:\n" + computer.get_first() + " " + computer.get_second() + " total: " + computer.get_total());

                    if (computer.get_first() == 1 || computer.get_second() == 1)                                         //If there is an ace then the Hand class is called in order to mutate the ace into whatever aids the dealer the most.
                    {
                        computer.ace();
                        System.out.println ("\nDealer's Ace(s) have been converted into 11s where possible in order to maximize their score!");
                        System.out.println ("\nDealer's Hand is now:\n" + computer.get_first() + " " + computer.get_second() + " total: " + computer.get_total());
                    }
                }
            }

            player.outcome(computer);                                                                                    //Calls the outcome method in order to display the game's outcome.
            System.out.println ("\nWould you like to play again?");                                                      //Asks the player if they would like to play another round.
            System.out.println ("1. Yes");
            System.out.println ("2. No");
            System.out.print   ("Choice: ");
            choice = kbscanner.nextInt();
        }
        while(choice == 1);

        //Goodbye Message
        System.out.println ("\n****************************************************************************************************");
        System.out.println ("                                         Thanks For Playing                                         ");
        System.out.println ("****************************************************************************************************");
    } // main method
} // Khidhir_codegame21 class