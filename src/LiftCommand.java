public class LiftCommand extends Command {

    @Override
    public boolean execute() {
        Main.player.takeItem(name);
        return true;
    }

}
