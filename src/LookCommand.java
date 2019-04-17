public class LookCommand extends Command {

    public boolean execute() {
        System.out.println("You can go to these rooms: " + Main.player.getCurrentRoom().getNeighborNames());

        Main.player.displayInventory();
        return true;
    }

}
