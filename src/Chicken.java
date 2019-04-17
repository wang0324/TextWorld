public class Chicken extends Creature{

    public Chicken(Room r, String name, String description) {
        super(r, name, description);
    }

    public void move() {
        moveToRoom(this.getRandomNeighbor());
    }
}
