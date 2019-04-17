public interface Command {

    public void init(String userString);

    public boolean execute();
}
