package is.hi.hbv202g.tictactoe;

import is.hi.hbv202g.tictactoe.view.TicTacToeView;

/**
 * The main Application for TicTacToe.
 * Responsible for starting the game.
 *
 * @author Andri Fannar Kristjánsson, afk6@hi.is
 * @author Sigríður H. Halldórsdóttir, shh60@hi.is
 * @since 09/04/2024
 * @version 1.0
 */
public class TicTacToeApplication
{
    /**
     * Start a game of TicTacToe.
     *
     * @param args Command line arguments. Not used.
     */
    public static void main( String[] args )
    {
        TicTacToeView view = new TicTacToeView();
        view.startGame();
    }
}
