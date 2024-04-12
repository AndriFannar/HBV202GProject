package is.hi.hbv202g.tictactoe.controller;

import is.hi.hbv202g.tictactoe.model.Gameboard;
import is.hi.hbv202g.tictactoe.model.Player;
import is.hi.hbv202g.tictactoe.model.Token;
import is.hi.hbv202g.tictactoe.model.observer.Observer;

public class TicTacToeController
{
    private Player player1;
    private Player player2;
    private final Gameboard gameboard;
    private int playerTurn = 1;
    private boolean gameOver = false;

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

        Token currentPlayer = this.playerTurn == 1 ? this.player1.getToken() : this.player2.getToken();

        this.gameboard.setToken(row, col, currentPlayer);

        playerTurn = (playerTurn + 1) % 2;
    }

    /**
     * Get the current Tokens on the game board.
     *
     * @return The game board.
     */
    public Token[][] getGameboard()
    {
        return this.gameboard.getGameboard();
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
}
