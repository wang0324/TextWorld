import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static Player player;
    public static Level level;
    public static HashMap<String, Command> commands;

    public static void main(String[] args) {
        setupGame();

        displayWelcomeMessage();
        Scanner in = new Scanner(System.in);
        String response = "";

        // Game Loop
        do {

            System.out.println("You are in the " + player.getCurrentRoom().getName());
            System.out.println(player.getCurrentRoom().getCreatureNames());
            System.out.println("You can go to " + player.getCurrentRoom().getNeighbors());

            player.displayCommands();

            System.out.print("What would you like to do? >");
            response = in.nextLine();

            Command command = getCommand(response);
            command.init(response);
            command.execute();

            level.moveCreatures();
        } while (!response.equals("quit"));

        System.out.println("Thanks for playing!");
        System.exit(0);
    }

    private static void displayWelcomeMessage() {

    }

    private static void setupGame() {
        level = new Level();

    }

    private static Command getCommand(String response) {

    }
}
