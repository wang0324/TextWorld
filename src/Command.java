public abstract class Command {

    protected String name;

    public void init(String userString) {
        name = getName(userString);
    }

    private String getName(String input) {
        if (input.split(" ").length > 1) {
            return input.substring(input.indexOf(" ") + 1);
        }
        return "";
    }

    public abstract boolean execute();
}
