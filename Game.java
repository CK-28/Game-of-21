/*Name: Crestena Khidhir
 *Date: 03/11/2020
 *Purpose: Starts a Game of 21. Deals with all surface level game components such as promting the user, dispalying game status, and calling on the Hand class
 */

 public class Game
 {
    int outcome;
    Hand player, computer;

    //Constructor for objects of class Game
    public Game()
    {
        player = new Hand();
        computer = new Hand();
        
        outcome = "Game Still In Progress.";    //Saftey net in case the outcome is returned before it was set
    }


 }