package is.hi.hbv202g.tictactoe.model;

public class Player
{
    private Token token;
    private int wins = 0;

    public Player(Token token)
    {
        this.token = token;
    }

    public Token getToken()
    {
        return this.token;
    }

    public int getWins()
    {
        return this.wins;
    }

    public void addWin()
    {
        this.wins++;
    }
}
