import java.util.*;

public class SimpleStartupGame {
    private boolean gameInProgress;
    private SimpleStartup startup;
    private int boardSize = 7;
    private int numberOfGuesses;
    private final Scanner scanner = new Scanner(System.in);


    public void start() {
        gameInProgress = true;
        startup = new SimpleStartup();

        int[] randomLocation = getRandomLocation();
        startup.setLocationCells(randomLocation);

        while(gameInProgress) {
            int userGuess = getUserInput("enter a number");
            numberOfGuesses++;

            String result = startup.checkYourself(userGuess);
            if (result == "Kill") {
                System.out.println("Good job! It took you " + numberOfGuesses + " guesses to sink the start-up.");
                setGameInProgress(false);
            }
        }

    }

    private int getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextInt();
    }

    private int[] getRandomLocation() {
        int randomNum = new Random().nextInt(0, 4);
        int[] randomLocationCells = { randomNum, randomNum + 1, randomNum + 2 };
        return randomLocationCells;
    }

    public void setGameInProgress(boolean status) {
        gameInProgress = status;
    }
}
