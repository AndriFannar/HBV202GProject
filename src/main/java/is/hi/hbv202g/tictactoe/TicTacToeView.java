package is.hi.hbv202g.tictactoe;

import java.util.Scanner;

public class TicTacToeView
{
    private TicTacToeController controller;

    public TicTacToeView(){}

    public void startGame()
    {
        setUpGame();
    }

    private void setUpGame()
    {
        System.out.println("Welcome to Tic Tac Toe!");

        System.out.print("Player 1, please choose a token (X or O): ");

        String playerToken = "";

        while (!playerToken.equals("X") && !playerToken.equals("O"))
        {
            playerToken = getUserInput();
        }

        Token player1 = Token.valueOf(playerToken);
        Token player2 = player1 == Token.X ? Token.O : Token.X;

        System.out.println("Player 1 has token " + player1 + " and player 2 has token " + player2 + ".");

        //controller = new TicTacToeController(player1, player2);
    }

    private void displayGameBoard()
    {

    }

    private void displayScore()
    {

    }


    /**
     * Gets an input from a user using the console and returns the result.
     *
     * @return The user input.
     */
    private String getUserInput()
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            if (scanner.hasNext())
            {
                return scanner.next();
            }
        }
    }
}
