package is.hi.hbv202g.tictactoe.controller;

import is.hi.hbv202g.tictactoe.model.GameBoard;
import is.hi.hbv202g.tictactoe.model.Player;
import is.hi.hbv202g.tictactoe.model.UserInputCallback;
import is.hi.hbv202g.tictactoe.model.Token;
import is.hi.hbv202g.tictactoe.model.observer.GameBoardObserver;
import is.hi.hbv202g.tictactoe.model.observer.ScoreObservable;
import is.hi.hbv202g.tictactoe.model.observer.ScoreObserver;

/**
 * A controller for a Tic Tac Toe game.
 */
public class TicTacToeController extends ScoreObservable
{
    // Entities
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;

    // Attributes
    private int winner        = 0;
    private int currentPlayer = 1;
    private boolean gameOver  = false;

    private UserInputCallback callback;

    /**
     * Construct a new TicTacToeController.
     *
     * @param player1                The game token for Player 1.
     * @param player2                The game token for Player 2.
     * @param boardSize              The size of the game board.
     * @param callback               Callback to get User Input from View.
     * @param gameBoardObserver The observer for the game board.
     * @param scoreObserver          The observer for the score.
     */
    public TicTacToeController(Token player1, Token player2, int boardSize, UserInputCallback callback, GameBoardObserver gameBoardObserver, ScoreObserver scoreObserver)
    {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        this.gameBoard = new GameBoard(boardSize);

        this.callback = callback;

        if (gameBoardObserver != null)
            this.gameBoard.attach(gameBoardObserver);

        if (scoreObserver != null)
            this.attach(scoreObserver);
    }

    /**
     * Start a new game of Tic Tac Toe.
     */
    public void startNewGame()
    {
        gameBoard.reset();
        gameOver = false;
        currentPlayer = 1;

        while (!gameOver)
        {
            String move = callback.getUserMove();
            makeMove(move);
        }
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

        gameBoard.setToken(row, col, getCurrentPlayerToken());
        switchPlayer();
        checkForWinner();
    }

    /**
     * Check if a move is valid.
     *
     * @param row The row the move is in.
     * @param col The column the move is in.
     * @return    True if the move is valid, false otherwise.
     */
    public boolean isValidMove(int row, int col)
    {
        int size = gameBoard.getSize();

        if (gameOver || row < 0 || row > size - 1 || col < 0 || col > size - 1)
        {
            return false;
        }

        return gameBoard.getToken(row, col) == Token.EMPTY;
    }

    /**
     * Switch the player making the next move.
     */
    private void switchPlayer()
    {
        currentPlayer = (currentPlayer + 1) % 2;
    }

    /**
     * Check if the game has been won.
     */
    private void checkForWinner()
    {
        Token[] winner = new Token[3];
        winner[0] = checkRows();
        winner[1] = checkColumns();
        winner[2] = checkDiagonals();

        for (Token token : winner)
        {
            if (token != Token.EMPTY)
            {
                endGame(token);
                return;
            }
        }

        if (gameBoard.isFull())
        {
            endGame(Token.EMPTY);
        }
    }

    /**
     * Check the rows of the game board for a winner.
     *
     * @return The winning token, or Token.EMPTY if there is no winner.
     */
    private Token checkRows()
    {
        for (Token[] tokenRow : gameBoard.getBoardState())
        {
            Token firstToken = tokenRow[0];
            
            if (firstToken != Token.EMPTY)
            {
                for (Token token : tokenRow)
                {
                    if (!token.getSymbol().equals(firstToken.getSymbol()))
                    {
                        firstToken = Token.EMPTY;
                        break;
                    }
                }

                if (firstToken != Token.EMPTY)
                    return firstToken;
            }
        }

        return Token.EMPTY;
    }

    /**
     * Check the columns of the game board for a winner.
     *
     * @return The winning token, or Token.EMPTY if there is no winner.
     */
    private Token checkColumns()
    {
        for (int i = 0; i < gameBoard.getSize(); i++)
        {
            Token firstToken = gameBoard.getToken(0, i);
            
            if (firstToken != Token.EMPTY)
            {
                for (int j = 0; j < gameBoard.getSize(); j++)
                {
                    if (!gameBoard.getToken(j, i).getSymbol().equals(firstToken.getSymbol()))
                    {
                        firstToken = Token.EMPTY;
                        break;
                    }
                }
            }

            if (firstToken != Token.EMPTY)
                return firstToken;
        }
        return Token.EMPTY;
    }

    /**
     * Check the diagonals of the game board for a winner.
     *
     * @return The winning token, or Token.EMPTY if there is no winner.
     */
    private Token checkDiagonals()
    {
        Token firstTokenUL = gameBoard.getToken(0, 0);
        Token firstTokenUR = gameBoard.getToken(0, gameBoard.getSize() - 1);

        if (firstTokenUL == Token.EMPTY && firstTokenUR == Token.EMPTY)
        {
            return firstTokenUL;
        }

        for (int i = 0; i < gameBoard.getSize(); i++)
        {
            if (!gameBoard.getToken(i, i).getSymbol().equals(firstTokenUL.getSymbol()))
            {
                firstTokenUL = Token.EMPTY;
            }
            if (!gameBoard.getToken(i, gameBoard.getSize() - i - 1).getSymbol().equals(firstTokenUR.getSymbol()))
            {
                firstTokenUR = Token.EMPTY;
            }
        }

        if (firstTokenUL != Token.EMPTY)
        {
            return firstTokenUL;
        }

        return firstTokenUR;
    }

    /**
     * End the game and declare a winner (or a tie).
     *
     * @param winnerToken The token of the winning player, or Token.EMPTY if there is a tie.
     */
    private void endGame(Token winnerToken)
    {
        if (winnerToken != Token.EMPTY)
        {
            if (winnerToken == player1.getToken())
            {
                player1.addWin();
                winner = 1;
            }
            else
            {
                player2.addWin();
                winner = 2;
            }

            notifyObservers();
        }
        else
        {
            winner = 0;
        }

        gameOver = true;
    }

    /**
     * Get the current Tokens on the game board.
     *
     * @return The game board.
     */
    public Token[][] getGameboardState()
    {
        return gameBoard.getBoardState();
    }

    /**
     * Get the current player's token.
     *
     * @return The current player's token.
     */
    public Token getCurrentPlayerToken()
    {
        return currentPlayer == 1 ? player1.getToken() : player2.getToken();
    }

    /**
     * Get the number of wins for each player.
     *
     * @return An array containing the number of wins for each player.
     */
    public int[] getPlayersScore()
    {
        return new int[] {player1.getWins(), player2.getWins()};
    }

    /**
     * Get the number for the winner of the game.
     *
     * @return The winner of the game.
     */
    public int getWinner()
    {
        return winner;
    }
}
