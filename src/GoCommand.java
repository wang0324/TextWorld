public class GoCommand extends Command {

    public boolean execute() {
        if (Main.level.getRoom(name) == null) return false;
        Main.player.moveToRoom(name);
        return true;
    }


}
