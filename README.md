## HBV202G Final Project
# Tic Tac Toe
A Java program to play a text-based game of Tic Tac Toe with two players.

### Installation
This Java program uses Maven to manage dependencies and build the project. The IDE should be able to handle the Maven dependencies automatically.
The Java version used is Java 21.

The main code is located in the [src/main/java/is/hi/hbv202g/tictactoe](src/main/java/is/hi/hbv202g/tictactoe) directory.

The tests are located in the [src/test/java/is/hi/hbv202g/tictactoe](src/test/java/is/hi/hbv202g/tictactoe) directory.

### Build
To build the project, run the following command in the root directory of the project:
```mvn compile```

If you don't have an IDE, you can also build the project using the script file [compile](compile.cmd) which is located in the root directory of the project.

### Run
To run the project and start the game, run the following command in the root directory of the project:
```mvn exec:java```

If you don't have an IDE, you can also run the project using the script file [run](run.cmd) which is located in the root directory of the project.

### Package
To package the project into a JAR file, run the following command in the root directory of the project:
```mvn package```

If you don't have an IDE, you can also package the project using the script file [package](package.cmd) which is located in the root directory of the project.
The JAR file will be located in the [target](target/TicTacToe.jar) directory.

### Run JAR
To run the JAR file created by Maven, run the script file [runmvnjar](runmvnjar.cmd) which is located in the root directory of the project.

To run the JAR file created by the script file, run the script file [runjar](runjar.cmd) which is located in the root directory of the project.

### Test
To run the tests for the project, run the following command in the root directory of the project:
```mvn test```

### Documentation
View the Maven site for the project to see design documents, dependencies and documentation.
It can be generated using ```mvn site``` and viewed in the [target/site](target/site) directory.

The JavaDoc can be generated directly by using `mvn javadoc:javadoc`.

### Design Documents
It is also possible to view the design documents [here](src/site/markdown/Design.md).

### License
This project is licensed under the MIT License - see the [LICENSE](LICENSE), and [SPDX](https://spdx.org/licenses/MIT.html)

