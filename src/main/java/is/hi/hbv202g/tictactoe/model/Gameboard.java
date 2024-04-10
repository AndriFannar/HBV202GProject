package is.hi.hbv202g.tictactoe.model;

import is.hi.hbv202g.tictactoe.model.observer.Observable;

public class Gameboard extends Observable
{
    private final int BOARD_SIZE = 3;
    private Token[][] board;

    public Gameboard()
    {
        board = new Token[BOARD_SIZE][BOARD_SIZE];
        // set öll stökin sem empty, kannski er það óþarfi
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            for (int j = 0; j < BOARD_SIZE; j++)
            {
                board[i][j] = Token.EMPTY;
            }
        }
    }

    // fall sem TicTacToeView getur kallað á tila prenta svo borðið
    public Token[][] getGameboard()
    {
        return board;
    }

    // ef við viljum geta resettað borðið (nýr leikur)
    public void reset()
    {
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            for (int j = 0; j < BOARD_SIZE; j++)
            {
                board[i][j] = Token.EMPTY;
            }
        }

        notifyObservers();
    }

    // tékka hvort búið sé að setja í alla reitina (jafntefli)
    public boolean isFull()
    {
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            for (int j = 0; j < BOARD_SIZE; j++)
            {
                if (board[i][j] == Token.EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }

    // fall sem skilar hvaða token er í reitnum i,j
    public Token getToken(int i, int j)
    {
        return board[i][j];
    }

    // setja token í reitinn
    public void setToken(int i, int j, Token token)
    {
        board[i][j] = token;
        notifyObservers();
    }
}
