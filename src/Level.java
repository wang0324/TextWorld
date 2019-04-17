import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    private HashMap<String, Room> rooms;
    private ArrayList<Creature> creatures;

    public Level() {
        rooms = new HashMap<>();
        creatures = new ArrayList<>();
        setupLevel();
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
        for (Creature creature: creatures){
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

        this.addUndirectedEdge("hall", "master bedroom");
        this.addUndirectedEdge("hall", "guest bedroom");
        this.addUndirectedEdge("hall", "bathroom");
        this.addUndirectedEdge("hall", "dungeon");
        this.addUndirectedEdge("hall", "gallery");
        this.addUndirectedEdge("master bedroom", "closet");
        this.addUndirectedEdge("master bedroom", "library");

    }

}

