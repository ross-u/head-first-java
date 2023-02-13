import java.util.*;

public class Console {
    private final Scanner scanner = new Scanner(System.in);

    public String getUserInput(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }
}
