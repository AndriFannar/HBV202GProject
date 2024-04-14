package is.hi.hbv202g.tictactoe.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class for a game board observable.
 * Notifies observers when the game board is updated.
 */
public abstract class GameBoardObservable
{
    private List<GameBoardObserver> gameBoardObservers;

    /**
     * Construct a new GameBoardObservable instance.
     */
    public GameBoardObservable()
    {
        this.gameBoardObservers = new ArrayList<>();
    }

    /**
     * Attach a game board observer to this observable.
     *
     * @param gameBoardObserver The game board observer to attach.
     */
    public void attach(GameBoardObserver gameBoardObserver)
    {
        this.gameBoardObservers.add(gameBoardObserver);
    }

    /**
     * Detach a game board observer from this observable.
     *
     * @param gameBoardObserver The game board observer to detach.
     */
    public void detach(GameBoardObserver gameBoardObserver)
    {
        this.gameBoardObservers.remove(gameBoardObserver);
    }

    /**
     * Notify all observers that the game board has been updated.
     */
    public void notifyObservers()
    {
        for (GameBoardObserver gameBoardObserver : this.gameBoardObservers)
        {
            gameBoardObserver.onGameBoardUpdated();
        }
    }
}
