import java.util.*;

public class StartupTestDrive {
    public static void main(String[] args) {
        // Instantiate the object instance to test
        Startup startup = new Startup();

        // Declare test input variable(s)
        String userGuess = "A0";
        ArrayList cells = new ArrayList(Arrays.asList("A1", "A2", "A3"));

        // Prepare the class for testing
        startup.setLocationCells(cells);

        // Test the method or class, and save the result
        String result = startup.checkYourself(userGuess);

        // Check the result and mark the test as "passed" or "failed"
        String testResult = "failed";
        if (result == "Hit") {
            testResult = "passed";
        }

        System.out.println(testResult);

    }
}
