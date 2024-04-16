package is.hi.hbv202g.tictactoe;

import is.hi.hbv202g.tictactoe.controller.TicTacToeControllerTest;
import is.hi.hbv202g.tictactoe.model.GameBoardTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A test suite for the Tic Tac Toe game.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TicTacToeControllerTest.class, GameBoardTest.class})
public class AllTests
{
}
