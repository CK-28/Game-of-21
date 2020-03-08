/**
 * Deals with the Hands dealt to the players and the process of the game choices and results.
 */
public class Hand
{
    private int card_one, card_two, card_three, total;

    /**
     * Constructor for objects of class Hand (The hands dealt to the players).
     */
    public Hand ()
    {
        card_one = (int) ((Math.random() * 13) + 1);
        card_two = (int) ((Math.random() * 13) + 1);
    }

    /**
     * Adds a third card to the player's hand upon request.
     */
    public void hit ()
    {
        card_three = (int) ((Math.random() * 13) + 1);
    }

    /**
     * Returns the first card in the hand.
     */
    public int get_first ()
    {
        return (card_one);
    }

    /**
     * Returns the second card in the hand.
     */
    public int get_second ()
    {
        return (card_two);
    }

    /**
     * Returns the third card in the hand.
     */
    public int get_third ()
    {
        return (card_three);
    }

    /**
     * Returns the total value of the hand.
     */
    public int get_total ()
    {
        total = card_one + card_two + card_three;
        return (total);
    }

    /**
     * Mutates the value of ace cards depending on evaluation.
     */
    public void ace ()
    {
        int temp_total = get_total();

        //Locate the ace card and mutate it into an 11 if the total allows.
        if (card_one == 1 && temp_total + 10 <= 21)
        {
            card_one = 11;
            temp_total = temp_total + 10;
        }
        else if (card_two == 1 && temp_total + 10 <= 21)
        {
            card_two = 11;
            temp_total = temp_total + 10;
        }
        else if (card_three == 1 && temp_total + 10 <= 21)
        {
            card_three = 11;
            temp_total = temp_total + 10;
        }
    }

    /**
     * Displays the outcome of the match by evaluating every possible condition.
     */
    public void outcome (Hand computer)
    {
        if (total > 21)
        {
            System.out.println ("\nYour total has exceeded 21. Dealer Wins!");
        }
        else if (computer.get_total() > 21)
        {
            System.out.println ("\nYour dealer's total has exceeded 21. You Win!");
        }
        else if (total == 21)
        {
            System.out.println ("\nYour total is 21! You Win!");
        }
        else if (computer.get_total() == 21)
        {
            System.out.println ("\nYour dealer's total is 21! Dealer Wins!");
        }
        else if (total < computer.get_total())
        {
            System.out.println ("\nYour dealer has the higher total. Dealer Wins!");
        }
        else if (total > computer.get_total())
        {
            System.out.println ("\nYou have the higher total. You Win!");
        }
        else if (total == computer.get_total())
        {
            System.out.println ("\nThe game is a tie. No winners!");
        }
    }
} // Hand class