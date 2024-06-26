# Design

## Class Diagram
The following is a Class Diagram for the classes contained in package [is.hi.hbv202g.tictactoe](../../main/java/is/hi/hbv202g/tictactoe).
![Class Diagram for project](Design.png)
The methods `makeMove` and `isValidMove` in `TicTacToeController` were originally private, but were made public for testing purposes.

### Design Patterns
The project uses the Observer pattern twice, once for the state of the GameBoard and once for the player's scores.
 * The GameBoard extends the GameBoardObservable, and TicTacToeView implements the GameBoardObserver.
 * The TicTacToeController extends the ScoreObservable, and TicTacToeView implements the ScoreObserver.

The project also uses the Strategy pattern, where the TicTacToeController has a UserInputStrategy interface that is implemented by the TicTacToeView.
* This was used to decouple the Controller from the View, and enable multiple implementations of the UserInputStrategy.
* The UserInputStrategy could be used to implement a CPU player, or a networked player.