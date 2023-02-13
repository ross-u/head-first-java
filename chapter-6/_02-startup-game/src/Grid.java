import java.util.*;

public class Grid {
    private static final String ALPHABET_LABELS = "ABCDEFG";
    private static final int GRID_SIZE = 49;
    private static final int ROW_LENGTH = 7;
    private static final int HORIZONTAL_INCREMENT = 1;
    private static final int VERTICAL_INCREMENT = ROW_LENGTH;

    private final boolean[] linearGrid = new boolean[GRID_SIZE];
    private final Random rand = new Random();



    public ArrayList<String> generateStartupLocation() {
        int[] indexes = null;
        ArrayList startupLocations;
        boolean gridSlotsAvailable = false;

        while(!gridSlotsAvailable) {
            int upperbound = ROW_LENGTH - 3;
            int randomPositionX = rand.nextInt(0, upperbound + 1);
            int randomPositionY = rand.nextInt(0, upperbound + 1);
            int randomStartPosition = (randomPositionX * ROW_LENGTH) + randomPositionY;

            int randomNumber = (int) (Math.random() * 1);
            String direction = randomNumber == 0 ? "horizontal" : "vertical";

            indexes = getPositionIndexes(randomStartPosition, direction);
            gridSlotsAvailable = areIndexesAvailable(indexes);
        }


        if (gridSlotsAvailable) {
            placeOnGrid(indexes);
            startupLocations = convertToLocationStrings(indexes);
            return startupLocations;
        }
        else {
            return null;
        }

    }

    private static int[] getPositionIndexes(int startIndex, String direction) {
        int increment = direction == "vertical" ? VERTICAL_INCREMENT : HORIZONTAL_INCREMENT;
        int slot1 = startIndex;
        int slot2 = startIndex + (increment * 1);
        int slot3 = startIndex + (increment * 2);
        int[] indexes = { slot1 , slot2, slot3 };
        return indexes;
    }

    private int[] placeOnGrid(int[] indexes) {
        boolean gridSlotsAvailable = false;

        gridSlotsAvailable = areIndexesAvailable(indexes);
        if (gridSlotsAvailable) {
            setSlotsOccupied(indexes);
            return indexes;
        }
        else {
            return null;
        }

    }

    private boolean areIndexesAvailable(int[] slots) {
        boolean allAvailable = true;
        for(int slot: slots) {
            boolean slotOccupied = slotOccupied(slot);

            if (slotOccupied) {
                allAvailable = false;
                break;
            }
        }

        return allAvailable;
    }

    private ArrayList<String> convertToLocationStrings(int[] indexes) {
        ArrayList<String> locations = new ArrayList<>();

        for(int index: indexes) {
            String location = convertIndexToAlphaNumericLocation(index);
            locations.add(location);
        }

        return locations;
    }

    private String convertIndexToAlphaNumericLocation(int index) {
        int positionY = index / ROW_LENGTH;
        int positionX = index % ROW_LENGTH;

        String positionYLetter = ALPHABET_LABELS.substring(positionY, positionY + 1);
        return positionYLetter + positionX;
    }

    private void setSlotsOccupied(int[] indexes) {
        for (int index: indexes) {
            linearGrid[index] = true;
        }
    }

    private boolean slotOccupied(int index) {
        return linearGrid[index] == true;
    }

    public ArrayList<String> getOccupiedSlots() {
        ArrayList<String> occupiedSlots = new ArrayList<String>();

        for (int i = 0; i < linearGrid.length; i++) {
            boolean slotIsOccupied = linearGrid[i] == true;
            if (slotIsOccupied) {
                String slotLocation = convertIndexToAlphaNumericLocation(i);
                occupiedSlots.add(slotLocation);
            }
        }
        return occupiedSlots;

    }
}
