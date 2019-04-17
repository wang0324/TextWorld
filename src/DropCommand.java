public class DropCommand extends Command {

    public boolean execute() {
        Main.player.dropItem(name);
        return true;
    }
}
