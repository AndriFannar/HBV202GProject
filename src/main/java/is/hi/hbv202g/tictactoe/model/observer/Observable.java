package is.hi.hbv202g.tictactoe.model.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable
{
    private List<Observer> observers;

    public Observable()
    {
        this.observers = new ArrayList<>();
    }

    public void attach(Observer observer)
    {
        this.observers.add(observer);
    }

    public void detach(Observer observer)
    {
        this.observers.remove(observer);
    }

    public void notifyObservers()
    {
        for (Observer observer : this.observers)
        {
            observer.update();
        }
    }
}
