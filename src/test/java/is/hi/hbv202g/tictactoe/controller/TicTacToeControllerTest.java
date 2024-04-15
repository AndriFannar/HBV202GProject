package is.hi.hbv202g.tictactoe.controller;

import is.hi.hbv202g.tictactoe.model.Token;
import org.junit.*;

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
        assert controller.getGameboardState()[0][0] == player1;
    }

    /**
     * Test that the makeMove method rejects invalid inputs.
     */
    @Test
    public void testMakeMoveIsInvalid()
    {
        String move = "5V";
        controller.makeMove(move);
        assert controller.getGameboardState()[0][0] == Token.EMPTY;
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
        assert controller.getGameboardState()[0][0] != player2;
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
        assert controller.getGameboardState()[0][1] == player2;
    }

    /**
     * Tests that the isValidMove method returns true for valid inputs.
     */
    @Test
    public void testIsValidMoveValid()
    {
        int row = 0;
        int col = 0;
        assert controller.isValidMove(row, col);
    }

    /**
     * Tests that the isValidMove method returns false for invalid inputs.
     */
    @Test
    public void testIsValidMoveInvalid()
    {
        int row = 3;
        int col = 3;
        assert !controller.isValidMove(row, col);
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
        assert !controller.isValidMove(row, col);
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

        assert controller.getWinner() == 1;
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

        assert controller.getWinner() == 2;
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

        assert controller.getWinner() == 1;
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

        assert controller.getWinner() == 2;
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

        assert controller.getWinner() == 1;
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

        assert controller.getWinner() == 2;
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

        assert controller.getWinner() == 0;
    }

    /**
     * Tests that the getCurrentPlayerToken method returns the correct token.
     */
    @Test
    public void testGetCurrentPlayerToken()
    {
        assert controller.getCurrentPlayerToken() == player1;
    }

    /**
     * Tests that the getCurrentPlayerToken method returns the correct Token after a move has been made.
     */
    @Test
    public void testGetCurrentPlayerTokenSwitch()
    {
        assert controller.getCurrentPlayerToken() == player1;
        String move = "1A";
        controller.makeMove(move);
        assert controller.getCurrentPlayerToken() == player2;
    }
}
