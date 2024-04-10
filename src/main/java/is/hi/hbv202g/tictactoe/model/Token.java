package is.hi.hbv202g.tictactoe.model;

public enum Token
{
    X,
    O,
    EMPTY;

    public String getSymbol()
    {
        return switch (this)
        {
            case X     -> "X";
            case O     -> "O";
            case EMPTY -> " ";
            default    -> "";
        };
    }
}
