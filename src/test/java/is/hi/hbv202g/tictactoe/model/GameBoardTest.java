package is.hi.hbv202g.tictactoe.model;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Tests for the GameBoard.
 */
public class GameBoardTest
{

    private GameBoard gameBoard;

    /**
     * Set up a new GameBoard instance before each test.
     */
    @Before
    public void setUp() {
        gameBoard = new GameBoard(3);
    }

    /**
     * Tests the constructor of GameBoard class.
     * Checks if the size of the board is correct and
     * if all spots are initialized to EMPTY.
     */
    @Test
    public void testGameBoardConstructor()
    {
        GameBoard board = new GameBoard(3);
        assertEquals("The size of the board should be 3.", board.getSize(), 3);

        GameBoard board2 = new GameBoard(7);
        assertEquals("The size of the board should be 7.", board2.getSize(), 7);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                assertEquals("Constructor should initialize all spots to EMPTY.", board.getToken(i, j), Token.EMPTY);
            }
        }
    }

    /**
     * Test that reset() method empties the board.
     */
    @Test
    public void testReset()
    {
        gameBoard.setToken(1, 1, Token.X);
        gameBoard.reset();
        for (int i = 0; i < gameBoard.getSize(); i++)
        {
            for (int j = 0; j < gameBoard.getSize(); j++)
            {
                assertEquals("All spots in the board should have EMPTY token.",gameBoard.getToken(i, j), Token.EMPTY);
            }
        }
    }

    /**
     * Test that isFull() method returns true when the board is full.
     */
    @Test
    public void testIsFullWhenGameBoardIsFull()
    {
        for (int i = 0; i < gameBoard.getSize(); i++)
        {
            for (int j = 0; j < gameBoard.getSize(); j++)
            {
                gameBoard.setToken(i, j, Token.X);
            }
        }
        assertTrue("GameBoard should be full.", gameBoard.isFull());

    }

    /**
     * Test that isFull() method returns false when the board is empty.
     */
    @Test
    public void testIsFullWhenGameBoardIsEmpty()
    {
        for (int i = 0; i < gameBoard.getSize(); i++)
        {
            for (int j = 0; j < gameBoard.getSize(); j++)
            {
                gameBoard.setToken(i, j, Token.EMPTY);
            }
        }

        assertFalse("GameBoard should not be full.",gameBoard.isFull());
    }

    /**
     * Test that get and set token methods work as expected.
     */
    @Test
    public void testGetAndSetToken()
    {
        gameBoard.setToken(1, 1, Token.X);
        assertEquals("Token X should be in center.", gameBoard.getToken(1, 1), Token.X);

        gameBoard.setToken(0, 0, Token.O);
        assertEquals("Token O should be in top left corner.", gameBoard.getToken(0, 0), Token.O);

        gameBoard.setToken(2, 2, Token.X);
        assertEquals("Token X should be in bottom right corner.", gameBoard.getToken(2, 2), Token.X);
    }

    /**
     * Test that getBoardState() method returns the same Tokens as getToken() method.
     */
    @Test
    public void testGetBoardState()
    {
        Token[][] boardState = gameBoard.getBoardState();
        for (int i = 0; i < gameBoard.getSize(); i++)
        {
            for (int j = 0; j < gameBoard.getSize(); j++)
            {
                assertEquals("getBoardState and getToken should return the same Token.",boardState[i][j], gameBoard.getToken(i, j));
            }
        }
    }

    /**
     * Test that getSize() method returns the correct size of the board.
     */
    @Test
    public void testGetSize()
    {
        GameBoard board = new GameBoard(3);
        assertEquals("Size should be 3",board.getSize(), 3);

        GameBoard board2 = new GameBoard(7);
        assertEquals("Size should be 7",board2.getSize(), 7);
    }
}