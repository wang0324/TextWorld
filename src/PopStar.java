import java.util.ArrayList;

public class PopStar extends Creature {

    public PopStar(Room r, String name, String description) {
        super(r, name, description);
    }

    @Override
    public void move() {
        moveTowardsPlayer();
    }

    /**
     * Moves the PopStar to the player if it's within 2 rooms away
     * Otherwise, it moves randomly.
     *
     * The boolean is for debugging purposes
     * @return True if it moved to player, false if it moved randomly
     */
    private boolean moveTowardsPlayer() {
        Room playerRoom = Main.player.getCurrentRoom();

        if (this.isPlayerNearRoom(playerRoom, this.getCurrentRoom())) {
            this.moveToRoom(playerRoom);
            return true;
        }

        moveToRoom(this.getCurrentRoom().getRandomNeighbor());
        return false;
    }
}
