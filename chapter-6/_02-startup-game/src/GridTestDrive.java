import java.util.*;

public class GridTestDrive {

    public static void main(String[] args) {
        System.out.println("Test Grid");
        Grid testGrid = new Grid();
        ArrayList<String> locations = new ArrayList<String>();

        // generate three (3) startup locations
        locations.addAll(testGrid.generateStartupLocation());
        locations.addAll(testGrid.generateStartupLocation());
        locations.addAll(testGrid.generateStartupLocation());

        ArrayList<String> occupiedSlots = testGrid.getOccupiedSlots();

        // Check the result and mark the test as "passed" or "failed"
        String testResult = "failed";

        for (String l: locations) System.out.println(l);

        if (locations.containsAll(occupiedSlots)) {
            testResult = "passed";
        }

        System.out.println(testResult);


    }
}
