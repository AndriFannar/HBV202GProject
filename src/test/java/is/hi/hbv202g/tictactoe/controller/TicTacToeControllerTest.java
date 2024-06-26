package is.hi.hbv202g.tictactoe.controller;

import is.hi.hbv202g.tictactoe.model.Token;
import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests for the TicTacToeController.
 */
public class TicTacToeControllerTest
{
    TicTacToeController controller;
    Token player1 = Token.X;
    Token player2 = Token.O;

    /**
     * Set up the test environment.
     */
    @Before
    public void setUp()
    {
        // Set up the controller.
        controller = new TicTacToeController(player1, player2, 3, null, null, null);
    }

    /**
     * Tear down the test environment.
     */
    @After
    public void tearDown()
    {
        // Tear down the controller.
        controller = null;
    }

    /**
     * Test that the makeMove method works for valid inputs.
     */
    @Test
    public void testMakeMoveIsValid()
    {
        String move = "1A";
        controller.makeMove(move);
        assertSame("Player 1's token should be in the top-left corner", controller.getGameboardState()[0][0], player1);
    }

    /**
     * Test that the makeMove method rejects invalid inputs.
     */
    @Test
    public void testMakeMoveIsInvalid()
    {
        String move = "5V";
        controller.makeMove(move);
        assertTrue("Invalid move should not be accepted", Arrays.stream(controller.getGameboardState()).allMatch(row -> Arrays.stream(row).allMatch(cell -> cell == Token.EMPTY)));
    }

    /**
     * Test that the makeMove method rejects occupied inputs.
     */
    @Test
    public void testMakeMoveIsOccupied()
    {
        String move = "1A";
        controller.makeMove(move);
        controller.makeMove(move);
        assertNotSame("Player 2's token should not replace Player 1's token in the top-left corner", controller.getGameboardState()[0][0], player2);
    }

    /**
     * Test that the makeMove method switches players.
     */
    @Test
    public void testMakeMoveSwitchPlayer()
    {
        String move = "1A";
        controller.makeMove(move);
        String moveP2 = "1B";
        controller.makeMove(moveP2);
        assertSame("The Token in the top-middle should be Player 2's token", controller.getGameboardState()[0][1], player2);
    }

    /**
     * Tests that the isValidMove method returns true for valid inputs.
     */
    @Test
    public void testIsValidMoveValid()
    {
        int row = 0;
        int col = 0;
        assertTrue("Valid move should be valid", controller.isValidMove(row, col));
    }

    /**
     * Tests that the isValidMove method returns false for invalid inputs.
     */
    @Test
    public void testIsValidMoveInvalid()
    {
        int row = 3;
        int col = 3;
        assertFalse("Invalid move out of bounds should return false", controller.isValidMove(row, col));
    }

    /**
     * Tests that the isValidMove method returns false for occupied inputs.
     */
    @Test
    public void testIsValidMoveOccupied()
    {
        String move = "1A";
        controller.makeMove(move);
        int row = 0;
        int col = 0;
        assertFalse("Move on a occupied space should return false", controller.isValidMove(row, col));
    }

    /**
     * Tests that X wins when a row is filled with X tokens.
     */
    @Test
    public void testWinRowX()
    {
        String[] moves = new String[] {"1A", "2A", "1B", "2B", "1C"};

        for (String move : moves)
        {
            controller.makeMove(move);
        }

        assertSame("Player 1 should win after row has been filled with X", controller.getWinner(), 1);
    }

    /**
     * Tests that O wins when a row is filled with O tokens.
     */
    @Test
    public void testWinRowO()
    {
        String[] moves = new String[] {"1A", "2A", "1B", "2B", "3A", "2C"};

        for (String move : moves)
        {
            controller.makeMove(move);
        }

        assertSame("Player 2 should win after row has been filled with O", controller.getWinner(), 2);
    }

    /**
     * Tests that X wins when a row is filled with X tokens on a board larger than 3x3.
     */
    @Test
    public void testWinRowXLargerThan3()
    {
        controller = new TicTacToeController(player1, player2, 5, null, null, null);

        String[] moves = new String[] {"1A", "2A", "1B", "2B", "1C", "2C", "1D", "2D", "1E"};

        for (String move : moves)
        {
            controller.makeMove(move);
        }

        assertSame("Player 1 should win after a row has been filled even on a larger board", controller.getWinner(), 1);
    }

    /**
     * Tests that X wins when a column is filled with X tokens.
     */
    @Test
    public void testWinColumnX()
    {
        String[] moves = new String[] {"1A", "1B", "2A", "2B", "3A"};

        for (String move : moves)
        {
            controller.makeMove(move);
        }

        assertSame("Player 1 should win after column has been filled with X", controller.getWinner(), 1);
    }

    /**
     * Tests that O wins when a column is filled with O tokens.
     */
    @Test
    public void testWinColumnO()
    {
        String[] moves = new String[] {"1A", "1B", "2A", "2B", "3C", "3B"};

        for (String move : moves)
        {
            controller.makeMove(move);
        }

        assertSame("Player 2 should win after column has been filled with O", controller.getWinner(), 2);
    }

    /**
     * Tests that X wins when a diagonal is filled with X tokens.
     */
    @Test
    public void testWinDiagonalX()
    {
        String[] moves = new String[] {"1A", "1B", "2B", "2A", "3C"};

        for (String move : moves)
        {
            controller.makeMove(move);
        }

        assertSame("Player 1 should win after diagonal has been filled with X", controller.getWinner(), 1);
    }

    /**
     * Tests that O wins when a diagonal is filled with O tokens.
     */
    @Test
    public void testWinDiagonalO()
    {
        String[] moves = new String[] {"1A", "1C", "3B", "2B", "3C", "3A"};

        for (String move : moves)
        {
            controller.makeMove(move);
        }

        assertSame("Player 2 should win after diagonal has been filled with O", controller.getWinner(), 2);
    }

    /**
     * Tests that the game ends in a tie when the board is full.
     */
    @Test
    public void testTie()
    {
        String[] moves = new String[] {"1B", "1A", "1C", "2B", "2A", "2C", "3B", "3A", "3C"};

        for (String move : moves)
        {
            controller.makeMove(move);
        }

        assertSame("No player should win when the gameboard has been filled", controller.getWinner(), 0);
    }

    /**
     * Tests that the getCurrentPlayerToken method returns the correct token.
     */
    @Test
    public void testGetCurrentPlayerToken()
    {
        assertSame("Player 1 should be the current player at the start", controller.getCurrentPlayerToken(), player1);
    }

    /**
     * Tests that the getCurrentPlayerToken method returns the correct Token after a move has been made.
     */
    @Test
    public void testGetCurrentPlayerTokenSwitch()
    {
        assertSame("Player 1 should be the current player at the start", controller.getCurrentPlayerToken(), player1);
        String move = "1A";
        controller.makeMove(move);
        assertSame("Player 2 should be the current after player 1 has made a move", controller.getCurrentPlayerToken(), player2);
    }
}
