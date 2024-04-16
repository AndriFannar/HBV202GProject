package is.hi.hbv202g.tictactoe.model;

import is.hi.hbv202g.tictactoe.model.observer.GameBoardObservable;

import java.util.Arrays;

/**
 * A Game board class that represents the game board in a Tic Tac Toe game.
 */
public class GameBoard extends GameBoardObservable
{
    private Token[][] board;

    /**
     * Construct a new GameBoard instance.
     *
     * @param size The size of the game board.
     */
    public GameBoard(int size)
    {
        board = new Token[size][size];

        for (Token[] row : board)
        {
            Arrays.fill(row, Token.EMPTY);
        }
    }

    /**
     * Reset the game board to an empty state.
     */
    public void reset()
    {
        for (Token[] row : board)
        {
            Arrays.fill(row, Token.EMPTY);
        }

        notifyObservers();
    }

    /**
     * Check if the game board is full.
     *
     * @return True if the game board is full, false otherwise.
     */
    public boolean isFull()
    {
        for (Token[] row : board)
        {
            for (Token token : row)
            {
                if (token == Token.EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Get the token in the specified position.
     *
     * @param row The row of the token.
     * @param col The column of the token.
     * @return    The token in the specified position.
     */
    public Token getToken(int row, int col)
    {
        return board[row][col];
    }

    /**
     * Set the token in the specified position.
     *
     * @param row   The row of the token.
     * @param col   The column of the token.
     * @param token The token to set.
     */
    public void setToken(int row, int col, Token token)
    {
        board[row][col] = token;
        notifyObservers();
    }

    /**
     * Get the current state of the game board.
     *
     * @return The current state of the game board.
     */
    public Token[][] getBoardState()
    {
        return board;
    }

    /**
     * Get the size of the game board.
     *
     * @return The size of the game board.
     */
    public int getSize() {
        return board.length;
    }
}
