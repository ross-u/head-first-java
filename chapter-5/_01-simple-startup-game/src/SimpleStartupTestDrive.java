public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        // Instantiate the object instance to test
        SimpleStartup startup = new SimpleStartup();

        // Declare test input variable(s)
        int userGuess = 4;
        int[] cells = { 2, 3, 4 };

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
