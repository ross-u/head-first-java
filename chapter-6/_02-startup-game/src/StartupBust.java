import java.util.*;

public class StartupBust {
    private final String[] STARTUP_NAMES = {"absolutepretzel", "kittycats", "bestbear "};
    private Grid grid = new Grid();
    private Console console = new Console();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private boolean gameInProgress;
    private int numberOfGuesses;


    public void startGame() {
        setUpGame();

        while(!startups.isEmpty()) {
            String userGuess = console.getUserInput("enter a guess");
            numberOfGuesses++;
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        String result = "";
        String message = "Miss";

        for(Startup startup: startups) {
            result = startup.checkYourself(userGuess);

            if (result == "Kill") {
                message = "Ouch! You sunk " + startup.getName() + "    :(";
                startups.remove(startup);
                break;
            }
            if (result == "Hit") {
                message = "Hit";
                break;
            }
        }

        System.out.println(message);

    }

    private void setUpGame() {
        gameInProgress = true;

        for(String name: STARTUP_NAMES) {
            Startup startup = new Startup();
            startup.setName(name);
            ArrayList<String> newLocation = grid.generateStartupLocation();

//            System.out.print("newLocation: ");
//            for(String l: newLocation) System.out.print(l + " ");
//            System.out.println("");
//            System.out.println("------------");

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
