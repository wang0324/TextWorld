public class Wumpus extends Creature {

    public Wumpus(Room room, String name, String description) {
        super(room, name, description);
    }

    public void move() {
        moveAwayFromPlayer();
    }

    private boolean moveAwayFromPlayer() {
        Room playerRoom = Main.player.getCurrentRoom();

        if (isPlayerNearRoom(this.getCurrentRoom())) {
            runFromPlayer();
            return true;
        }

        moveToRoom(this.getRandomNeighbor());
        return false;
    }

    private void runFromPlayer() {
        for (Room neighbor : this.getCurrentRoom().getNeighbors()) {
            if (!isPlayerNearRoom(neighbor)) {
                moveToRoom(neighbor);
                return;
            }
        }
        moveToRoom(this.getRandomNeighbor());
    }

}
