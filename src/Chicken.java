public class Chicken extends Creature{

    public Chicken(Room room, String name, String description) {
        super(room, name, description);
    }

    public void move() {
        moveToRoom(this.getRandomNeighbor());
    }
}
