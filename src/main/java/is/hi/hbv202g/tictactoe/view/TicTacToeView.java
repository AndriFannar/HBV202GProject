package is.hi.hbv202g.tictactoe.view;

import is.hi.hbv202g.tictactoe.controller.TicTacToeController;
import is.hi.hbv202g.tictactoe.model.Gameboard;
import is.hi.hbv202g.tictactoe.model.Token;
import is.hi.hbv202g.tictactoe.model.observer.Observer;

import java.util.Scanner;

public class TicTacToeView implements Observer
{
    private TicTacToeController controller;
    private Scanner scanner;
    private int game;

    /**
     * Construct a new TicTacToeView instance.
     */
    public TicTacToeView()
    {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Start a game of Tic Tac Toe.
     */
    public void startGame()
    {
        if (game == 0) {
            setUpGame();
            game++;
        }
        while (!controller.isGameOver()) {
            update();
            String move = getUserMove();
            controller.makeMove(move);
        }
        restartGame();
    }

    /**
     * Sets up the game by asking the user for their token and creating a new controller.
     */
    private void setUpGame()
    {
        System.out.println("Welcome to Tic Tac Toe!");

        Token player1 = getPlayerToken();
        Token player2 = player1 == Token.X ? Token.O : Token.X;

        System.out.println("Player 1 has token " + player1 + " and player 2 has token " + player2 + ".");

        controller = new TicTacToeController(player1, player2, this);
    }

    private Token getPlayerToken() {
        System.out.print("Player 1, please choose a token (X or O): ");

        String playerToken = "";
        while (!playerToken.equalsIgnoreCase("x") && !playerToken.equalsIgnoreCase("o")) {
            playerToken = getUserInput().toUpperCase();
        }

        return Token.valueOf(playerToken);
    }

    /**
     * Gets the user's move and returns it.
     *
     * @return The user's move.
     */
    private String getUserMove()
    {
        String move = "";

        while (move.length() != 2 || !Character.isDigit(move.charAt(0))  || !Character.isLetter(move.charAt(1)))
        {
            System.out.print("Player " + controller.getCurrentPlayerToken() + " - Enter your move (row column): ");
            move = getUserInput();
        }

        return move;
    }


    /**
     * Gets an input from a user using the console and returns the result.
     *
     * @return The user input.
     */
    private String getUserInput()
    {
        while (true)
        {
            if (scanner.hasNextLine())
                return scanner.nextLine();
        }
    }

    /**
     * Prints out the game board when it updates.
     */
    public void update()
    {
        Gameboard gameboard = controller.getGameboard();
        int boardSize = gameboard.getSize();

        printHorizontalDividers(boardSize);

        for (int i = 0; i < boardSize; i++)
        {
            System.out.print(i + 1 + " |");

            for (int j = 0; j < boardSize; j++)
            {
                Token token = gameboard.getToken(i, j);
                System.out.print(" " + token.getSymbol() + " |");
            }
            printHorizontalDividers(boardSize);
        }

        System.out.print(" ");

        for (int i = 0; i < boardSize; i++)
        {
            String location = String.valueOf((char)(i + 65));
            
            System.out.print("   " + location);
        }

        System.out.println();
    }

    private void restartGame() {
        displayScores();
        System.out.println("Would you like to play again? (Y/N)");
        if ("Y".equalsIgnoreCase(getUserInput())) {
            controller.startNewGame();
            startGame();
        }
        else {
            System.out.println("Thanks for playing!");
        }
    }

    /**
     * Prints out the horizontal dividers for the game board.
     *
     * @param length The length of the game board.
     */
    private void printHorizontalDividers(int length)
    {
        System.out.print("\n  +");

        for (int j = 0; j < length; j++) {
            System.out.print("---+");
        }

        System.out.println();
    }
}
