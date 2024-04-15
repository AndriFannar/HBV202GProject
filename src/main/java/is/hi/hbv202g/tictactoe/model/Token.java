package is.hi.hbv202g.tictactoe.model;

/**
 * Represents a token in a Tic Tac Toe game.
 */
public enum Token
{
    /**
     * The X token.
     */
    X,
    /**
     * The O token.
     */
    O,
    /**
     * A token that represents an empty cell.
     */
    EMPTY;

    /**
     * Get the symbol of the token.
     *
     * @return The Token's symbol.
     */
    public String getSymbol()
    {
        return switch (this)
        {
            case X     -> "X";
            case O     -> "O";
            case EMPTY -> " ";
        };
    }
}
