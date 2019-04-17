public class AddCommand extends Command {

    @Override
    public boolean execute() {
        Main.level.addRoom(name);
        return true;
    }

}
