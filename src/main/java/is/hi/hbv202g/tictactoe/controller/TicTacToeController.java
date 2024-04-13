package is.hi.hbv202g.tictactoe.controller;

import is.hi.hbv202g.tictactoe.model.Gameboard;
import is.hi.hbv202g.tictactoe.model.Player;
import is.hi.hbv202g.tictactoe.model.Token;
import is.hi.hbv202g.tictactoe.model.observer.Observer;

public class TicTacToeController
{
    private Gameboard gameboard;
    private Player player1;
    private Player player2;
    private int currentPlayer = 1;
    private boolean gameOver = false;
    private int winner = 0;

    /**
     * Construct a new TicTacToeController.
     *
     * @param player1       The game token for Player 1.
     * @param player2       The game token for Player 2.
     * @param boardObserver The observer for the game board.
     */
    public TicTacToeController(Token player1, Token player2, Observer boardObserver)
    {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.gameboard = new Gameboard();
        this.gameboard.attach(boardObserver);
    }

    /**
     * Make a move on the game board.
     *
     * @param move Location to place a new token.
     */
    public void makeMove(String move)
    {
        int row = Character.getNumericValue(move.charAt(0)) - 1;
        int col = Character.getNumericValue(move.charAt(1)) - 10;

        if (!isValidMove(row, col))
        {
            return;
        }

        gameboard.setToken(row, col, getCurrentPlayerToken());
        switchPlayer();
        checkForWinner();

    }
    private boolean isValidMove(int row, int col)
    {
        if (gameOver || row < 0 || row > 2 || col < 0 || col > 2)
        {
            return false;
        }
        return gameboard.getToken(row, col) == Token.EMPTY;
    }

    private void switchPlayer()
    {
        currentPlayer = (currentPlayer + 1) % 2;
    }
    public void checkForWinner()
    {
        Gameboard gameboard = getGameboard();
        Token winner = checkRows(gameboard);
        if (winner == null)
        {
            winner = checkColumns(gameboard);
        }
        if (winner == null)
        {
            winner = checkDiagonals(gameboard);
        }
        if (winner != null)
        {
            endGame(winner);
        }
        else if (gameboard.isFull())
        {
            endGame(null);
        }
    }
    private Token checkRows(Gameboard gameboard)
    {
        for (int i = 0; i < 3; i++)
        {
            if (gameboard.getToken(i, 0) != Token.EMPTY &&
                    gameboard.getToken(i, 0) == gameboard.getToken(i, 1) &&
                    gameboard.getToken(i, 1) == gameboard.getToken(i, 2))
            {
                return gameboard.getToken(i, 0);
            }
        }
        return null;
    }
    private Token checkColumns(Gameboard gameboard)
    {
        for (int i = 0; i < 3; i++)
        {
            if (gameboard.getToken(0, i) != Token.EMPTY &&
                    gameboard.getToken(0, i) == gameboard.getToken(1, i) &&
                    gameboard.getToken(1, i) == gameboard.getToken(2, i))
            {
                return gameboard.getToken(0, i);
            }
        }
        return null;
    }

    private Token checkDiagonals(Gameboard gameboard)
    {
        if (gameboard.getToken(0, 0) != Token.EMPTY &&
                gameboard.getToken(0, 0) == gameboard.getToken(1, 1) &&
                gameboard.getToken(1, 1) == gameboard.getToken(2, 2))
        {
            return gameboard.getToken(0, 0);
        }

        if (gameboard.getToken(0, 2) != Token.EMPTY &&
                gameboard.getToken(0, 2) == gameboard.getToken(1, 1) &&
                gameboard.getToken(1, 1) == gameboard.getToken(2, 0))
        {
            return gameboard.getToken(0, 2);
        }
        return null;
    }


    }

    /**
     * Check if the game is over.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean isGameOver()
    {
        return this.gameOver;
    }

    /**
     * Get the current Tokens on the game board.
     *
     * @return The game board.
     */
    public Gameboard getGameboard()
    {
        return gameboard;
    }

    public Token getCurrentPlayerToken()
    {
        return currentPlayer == 1 ? player1.getToken() : player2.getToken();
    }
    public int getPlayer1Wins() {
        return player1.getWins();
    }

    public int getPlayer2Wins() {
        return player2.getWins();
    }

    public int getWinner()
    {
        return winner;
    }
}
