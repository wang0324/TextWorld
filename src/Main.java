import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static Player player;
    public static Level level;
    public static HashMap<String, Command> commands;

    public static void main(String[] args) {
        setupGame();

        System.out.println("Welcome to the magical castle!");

        Scanner in = new Scanner(System.in);
        String response = "";

        // Game Loop
        do {

            System.out.println("You are in the " + player.getCurrentRoom().getName());
            System.out.println(player.getCurrentRoom().getCreatureNames());
            System.out.println("You can go to " + player.getCurrentRoom().getNeighbors());

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

    private static void setupGame() {
        level = new Level();

        player = new Player(level.getRoom("hall"), "Kevin", "");

        commands.put("go", new GoCommand()); // Moves Player to room
        commands.put("add", new AddCommand()); // Adds item to room
        commands.put("lift", new LiftCommand()); // Take an item from room
        commands.put("place", new DropCommand()); // remove item from inventory and add to room
        commands.put("look", new LookCommand()); // shows neighboring rooms and items in current room

    }

    private static Command getCommand(String response) {
        for (String key : commands.keySet()) {
            if (response.contains(key)) return commands.get(key);
        }
        return null;
    }
}
