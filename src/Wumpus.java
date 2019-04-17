import java.util.ArrayList;

public class Wumpus extends Creature{

    public Wumpus(Room room, String name, String description) {
        super(room, name, description);
    }

    public void move() {
        moveAwayFromPlayer();
    }

    private boolean moveAwayFromPlayer() {
        Room playerRoom = Main.player.getCurrentRoom();

        if (isPlayerNearRoom(playerRoom, this.getCurrentRoom())) {
            runFromPlayer();
            return true;
        }

        moveToRoom(this.getCurrentRoom().getRandomNeighbor());
        return false;
    }

}
