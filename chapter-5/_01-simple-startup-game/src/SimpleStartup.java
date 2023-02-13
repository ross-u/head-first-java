public class SimpleStartup {
    private int[] locationCells;
    private int numberOfHits;

    public void setLocationCells(int[] cells) {

        this.locationCells = cells;
    }

    public String checkYourself(int userGuess) {
        String result = "Miss";

        for (int cell: locationCells) {
            if (userGuess == cell) {
                numberOfHits++;
                result = "Hit";
                break;
            }

        }

        if (numberOfHits == locationCells.length) {
            result = "Kill";
        }
        System.out.println(result);
        return result;
    }

}
