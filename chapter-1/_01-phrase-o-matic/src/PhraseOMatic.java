import java.util.Random;

public class PhraseOMatic {
    public static void main (String[] args) {
        // 1. Make three sets of words to chose from. Add your own!
        String[] wordListOne = {"out-of-the-box", "agnostic", "opinionated", "voice activated", "haptically driven", "extensible", "reactive", "agent based", "functional", "AI enabled", "strongly typed", "artificial", "functional"};
        String[] wordListTwo = {"leveraged", "targeted", "loosely coupled", "six sigma", "browser based", "web", "asynchronous", "event driven", "pub-sub", "IoT", "cloud native", "service oriented", "containerized", "serverless", "microservices", "distributed ledger"};
        String[] wordListThree = {"paradigm", "framework", "library", "DSL", "REST API", "repository", "pipeline", "service mesh", "architecture", "perspective", "design", "orientation", "middleware", "system", "intelligence"};

        // 2. Find out how many words are in each list
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        // 3. Generate three random numbers
        Random randomGenerator = new Random();
        int randomOne = randomGenerator.nextInt(oneLength);
        int randomTwo= randomGenerator.nextInt(twoLength);
        int randomThree = randomGenerator.nextInt(threeLength);

        // 4. Create a random phrase
        String phrase = wordListOne[randomOne] + " " + wordListTwo[randomTwo] + " " + wordListThree[randomThree];

        System.out.println("What we need is a " + phrase);
    }
}
