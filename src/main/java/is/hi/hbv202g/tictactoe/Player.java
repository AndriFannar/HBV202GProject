package is.hi.hbv202g.tictactoe;

public class Player
{
    private Token token;
    private int wins = 0;
    private int losses = 0;

    public Player(Token token)
    {
        this.token = token;
    }

    public Token getToken()
    {
        return this.token;
    }

    public void setToken(Token token)
    {
        this.token = token;
    }

    public int getWins()
    {
        return this.wins;
    }

    public int getLosses()
    {
        return this.losses;
    }

    public void addWin()
    {
        this.wins++;
    }

    public void addLoss()
    {
        this.losses++;
    }

    public void reset()
    {
        this.wins = 0;
        this.losses = 0;
    }
}
