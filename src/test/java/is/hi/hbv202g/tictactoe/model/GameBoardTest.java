package is.hi.hbv202g.tictactoe.model;

import org.junit.*;

import static org.junit.Assert.*;

public class GameBoardTest {

    private GameBoard gameBoard;

    /**
     * Set up a new GameBoard instance before each test.
     */
    @Before
    public void setUp() {
        gameBoard = new GameBoard(3);
    }

    /**
     * Test that reset() method empties the board.
     */
    @Test
    public void testReset() {
        // empty the board
        gameBoard.reset();
        // check if the board is empty
        for (int i = 0; i < gameBoard.getSize(); i++) {
            for (int j = 0; j < gameBoard.getSize(); j++) {
                assertSame("All spots in the board should have EMPTY token.",gameBoard.getToken(i, j), Token.EMPTY);
            }
        }
    }

    /**
     * Test that isFull() method returns true when the board is full and false otherwise.
     */
    @Test
    public void testIsFull() {
        // fill the board
        for (int i = 0; i < gameBoard.getSize(); i++) {
            for (int j = 0; j < gameBoard.getSize(); j++) {
                gameBoard.setToken(i, j, Token.X);
            }
        }
        // check if the board is full
        assertTrue("Board should be full.", gameBoard.isFull());

        // reset the board and add a few Tokens to it
        gameBoard.reset();
        gameBoard.setToken(0, 0, Token.X);
        gameBoard.setToken(2, 0, Token.O);
        gameBoard.setToken(1, 2, Token.X);

        // check if the board is full
        assertFalse("Board should not be full.",gameBoard.isFull());
    }

    /**
     * Test that get and set token methods work as expected.
     */
    @Test
    public void testGetAndSetToken() {
        gameBoard.setToken(1, 1, Token.X);
        assertSame("Token X should be in center.", gameBoard.getToken(1, 1), Token.X);

        // set and get token in top left corner
        gameBoard.setToken(0, 0, Token.O);
        assertSame("Token O should be in top left corner.", gameBoard.getToken(0, 0), Token.O);

        // set and get token in bottom right corner
        gameBoard.setToken(2, 2, Token.X);
        assertSame("Token X should be in bottom right corner.", gameBoard.getToken(2, 2), Token.X);
    }

    /**
     * Test that getBoardState() method returns the same Tokens as getToken() method.
     */
    @Test
    public void testGetBoardState() {
        Token[][] boardState = gameBoard.getBoardState();
        for (int i = 0; i < gameBoard.getSize(); i++) {
            for (int j = 0; j < gameBoard.getSize(); j++) {
                assertSame("getBoardState and getToken should return the same Tokens.",boardState[i][j], gameBoard.getToken(i, j));
            }
        }
    }

    /**
     * Test that getSize() method returns the correct size of the board.
     */
    @Test
    public void testGetSize() {
        GameBoard board = new GameBoard(3);
        assertEquals("Size should be 3",board.getSize(), 3);
        GameBoard board2 = new GameBoard(7);
        assertEquals("Size should be 7",board2.getSize(), 7);
        GameBoard board3 = new GameBoard(10);
        assertEquals("Size should be 3 when number entered is not between 3 and 9.",board3.getSize(), 3);
    }
}