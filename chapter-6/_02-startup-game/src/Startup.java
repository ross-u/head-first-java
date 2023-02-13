import java.util.ArrayList;

public class Startup {
    private ArrayList<String> locationCells;
    private String name;

    public String checkYourself(String userGuess) {
        String result = "Miss";

        int index = locationCells.indexOf(userGuess);
        boolean correctGuess = index >= 0;

        if (correctGuess) {
            locationCells.remove(index);
            result = "Hit";
        }
        if (correctGuess && locationCells.isEmpty()) {
            result = "Kill";
        }

        return result;
    }

    public void setLocationCells(ArrayList<String> cells) {
        locationCells = cells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
