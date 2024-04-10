package is.hi.hbv202g.tictactoe;

public class TicTacToeController
{
    private Player player1;
    private Player player2;

    public TicTacToeController(Token player1, Token player2)
    {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }


}
