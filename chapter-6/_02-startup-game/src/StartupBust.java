import java.util.*;

public class StartupBust {
    private Grid grid = new Grid();
    private Console console = new Console();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    String[] startupData = {"absolutepretzel", "kittycats", "bestbear "};
    private boolean gameInProgress;
    private int numberOfGuesses;


    public void startGame() {
        setUpGame();

        while(gameInProgress) {
            String userGuess = console.getUserInput("enter a guess");
            numberOfGuesses++;
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        String result = "";

        for(Startup startup: startups) {
            result = startup.checkYourself(userGuess);
            if (result == "Kill") {
                System.out.println("Ouch! You sunk " + startup.getName() + "    :(");
                startups.remove(startup);
                break;
            }
            else if (result == "Hit") {
                System.out.println("Hit");
                break;
            }
            else {
                System.out.println("Miss");
            }
        }

    }

    private void setUpGame() {
        gameInProgress = true;

        for(String name: startupData) {
            Startup startup = new Startup();
            startup.setName(name);
            ArrayList<String> newLocation = grid.generateStartupLocation();
            
            startup.setLocationCells(newLocation);
            startups.add(startup);
        }
    }

    private void finishGame() {
        gameInProgress = false;

        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numberOfGuesses <= 18) {
            System.out.println("It only took you " + numberOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numberOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }
    
}
