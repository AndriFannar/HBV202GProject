package is.hi.hbv202g.tictactoe.model;

/**
 * A simple Player class.
 * Represents a player in a Tic Tac Toe game, with a token and a number of wins.
 */
public class Player
{
    private Token token;
    private int wins = 0;

    /**
     * Construct a new Player instance.
     *
     * @param token The player's token.
     */
    public Player(Token token)
    {
        this.token = token;
    }

    /**
     * Get the player's token.
     *
     * @return The player's token.
     */
    public Token getToken()
    {
        return this.token;
    }

    /**
     * Get the number of wins the player has.
     *
     * @return The number of wins the player has.
     */
    public int getWins()
    {
        return this.wins;
    }

    /**
     * Add a win to the player's win count.
     */
    public void addWin()
    {
        this.wins++;
    }
}
