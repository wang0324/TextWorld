import java.util.ArrayList;
import java.util.HashMap;

public class Level {

    private HashMap<String, Room> rooms;
    private ArrayList<Creature> creatures;

    public Level() {
        rooms = new HashMap<>();
        creatures = new ArrayList<>();
        this.setupLevel();
    }

    public Room getRoom(String room) {
        return rooms.get(room);
    }

    //Both addRooms used to add rooms not connected to anything
    public void addRoom(String name, String description) {
        addRoom(new Room(name, description));
    }

    public void addRoom(Room room) {
        rooms.put(room.getName(), room);
    }

    public void addRoom(String name) {
        addRoom(new Room(name, ""));
    }

    //Connect rooms together
    public void addDirectedEdge(Room room1, Room room2) {
        room1.addNeighbor(room2);
    }

    public void addDirectedEdge(String room1, String room2) {
        addDirectedEdge(rooms.get(room1), rooms.get(room2));
    }

    public void addUndirectedEdge(Room room1, Room room2) {
        addDirectedEdge(room1, room2);
        addDirectedEdge(room2, room1);
    }

    public void addUndirectedEdge(String room1, String room2) {
        addUndirectedEdge(rooms.get(room1), rooms.get(room2));
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public void moveCreatures() {
        for (Creature creature : creatures) {
            creature.move();
        }
    }

    private void setupLevel() {
        this.addRoom("hall");
        this.addRoom("master bedroom");
        this.addRoom("guest bedroom");
        this.addRoom("bathroom");
        this.addRoom("closet");
        this.addRoom("dungeon");
        this.addRoom("library");
        this.addRoom("gallery");
        this.addRoom("living room");
        this.addRoom("classroom");
        this.addRoom("store");
        this.addRoom("office");
        this.addRoom("basement");
        this.addRoom("attic");
        this.addRoom("sunroom");
        this.addRoom("gym");

        this.addUndirectedEdge("hall", "master bedroom");
        this.addUndirectedEdge("hall", "guest bedroom");
        this.addUndirectedEdge("hall", "bathroom");
        this.addUndirectedEdge("hall", "dungeon");
        this.addUndirectedEdge("hall", "gallery");
        this.addUndirectedEdge("master bedroom", "closet");
        this.addUndirectedEdge("master bedroom", "library");
        this.addUndirectedEdge("hall", "gallery");
        this.addUndirectedEdge("hall", "living room");
        this.addUndirectedEdge("hall", "classroom");
        this.addUndirectedEdge("hall", "store");
        this.addUndirectedEdge("hall", "office");
        this.addUndirectedEdge("hall", "attic");
        this.addUndirectedEdge("hall", "gym");
        this.addUndirectedEdge("hall", "sunroom");

        this.addDirectedEdge("hall", "dungeon");
        this.addDirectedEdge("closet", "dungeon");
        this.addDirectedEdge("attic", "dungeon");
        this.addDirectedEdge("basement", "dungeon");

        this.makeAllCreatures();

        this.addAllItems();
    }

    private void makeAllCreatures() {
        for (int i = 0; i < 4; i++) {
            creatures.add(new Chicken(this.getRoom("hall"), "chicken" + i, "A Chicken"));
        }

        creatures.add(new PopStar(getRoom("dungeon"), "Bunty", "A Bunty that plays fatal music"));
        creatures.add(new Wumpus(getRoom("dungeon"), "Wumpus", "The creature you're trying to hunt"));
    }

    private void addAllItems() {
        this.getRoom("closet").addItem("umbrella");

        this.getRoom("library").addItem("book");

        this.getRoom("bathroom").addItem("sword");

        this.getRoom("sunroom").addItem("spear of destiny");

        this.getRoom("gym").addItem("shield of valor");

        this.getRoom("office").addItem("printer of satisfaction");
    }

}

