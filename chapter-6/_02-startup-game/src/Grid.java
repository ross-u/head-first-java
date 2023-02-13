import java.util.*;

/*
              *
      0 1 2 3 4 5 6
  A [ 0 0 0 0 0 0 0 ]
  B [ 0 0 0 0 0 0 0 ]
  C [ 0 X 0 0 0 0 0 ]
  D [ 0 0 0 0 0 0 0 ]
* E [ 0 0 0 0 * 0 0 ]
  F [ 0 0 0 0 0 0 0 ]
  G [ 0 0 0 0 0 0 0 ]

*___________________________
*
*
    A: 0 , B: 1, C: 2, D: 3, E: 4, F: 5, G: 6,

      0 1 2 3 4 5 6   7 8 9 0 1 2 13 14 5 6 7 8 9 20 21 2 3 4 5 6 7
  A [ 0 0 0 0 0 0 0 | 0 0 0 0 0 0 0 | 0 0 0 0 0 0 0 | 0 0 0 0 0 0 0 | 0 0 0 0 0 0 0 | 0 0 0 0 0 0 0 | 0 0 0 0 0 0 0 ]

  Max horizontal: 4
  Max  vertical : E(4)

  H C1 - 2 1  -> 16
  H D2 - 3 2  -> 16
  V E4 - 4 4

* */

public class Grid {
    Random rand = new Random();
    int DEFAULT_SIZE = 7;
    private int gridSize;
    private boolean[] linearGrid;

    public Grid() {
        gridSize = DEFAULT_SIZE;
        linearGrid = new boolean[DEFAULT_SIZE * DEFAULT_SIZE];
    }

    public Grid(int size) {
        gridSize = size;
        linearGrid = new boolean[size * size];
    }

    public ArrayList<String> generateStartupLocation() {
        int[] indexes = null;
        ArrayList startupLocations;
        boolean gridSlotsAvailable = false;

        while(!gridSlotsAvailable) {
            int upperbound = gridSize - 3;
            int randomPositionX = (rand.nextInt(0, upperbound + 1));
            int randomPositionY = (rand.nextInt(0, upperbound + 1));
            int randomStartPosition = (randomPositionX * gridSize) + randomPositionY;

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
        int step = direction == "vertical" ? 7 : 1;
        int slot1 = startIndex;
        int slot2 = startIndex + (step * 1);
        int slot3 = startIndex + (step * 2);
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
            String location = convertIndexToLocation(index);
            locations.add(location);
        }

        return locations;
    }

    private String convertIndexToLocation(int index) {
        String[] HORIZONTAL_LABELS = { "A", "B", "C", "D", "E", "F", "G" };
        int positionX = index / gridSize;
        int positionY = index % gridSize;

        String loc = HORIZONTAL_LABELS[positionX] + positionY;
        return loc;
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
                String slotLocation = convertIndexToLocation(i);
                occupiedSlots.add(slotLocation);
            }
        }
        return occupiedSlots;

    }
}
