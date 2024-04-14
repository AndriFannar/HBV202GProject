package is.hi.hbv202g.tictactoe.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class for a score observable.
 * Notifies observers when the score is updated.
 */
public abstract class ScoreObservable
{
    private List<ScoreObserver> scoreObservers;

    /**
     * Construct a new ScoreObservable instance.
     */
    public ScoreObservable()
    {
        this.scoreObservers = new ArrayList<>();
    }

    /**
     * Attach a score observer to this observable.
     *
     * @param scoreObserver The score observer to attach.
     */
    public void attach(ScoreObserver scoreObserver)
    {
        this.scoreObservers.add(scoreObserver);
    }

    /**
     * Detach a score observer from this observable.
     *
     * @param scoreObserver The score observer to detach.
     */
    public void detach(ScoreObserver scoreObserver)
    {
        this.scoreObservers.remove(scoreObserver);
    }

    /**
     * Notify all observers that the score has been updated.
     */
    public void notifyObservers()
    {
        for (ScoreObserver scoreObserver : this.scoreObservers)
        {
            scoreObserver.onScoreUpdated();
        }
    }
}
