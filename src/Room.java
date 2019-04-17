import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String name, description;
    private HashMap<String, Room> neighbors;
    private ArrayList<Item> items;
    private ArrayList<Creature> creatures;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        creatures = new ArrayList<Creature>();
        items = new ArrayList<>();
        neighbors = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addNeighbor(Room neighbor) {
        neighbors.put(neighbor.getName(), neighbor);
    }

    public Room getNeighbor(String name) {
        return neighbors.get(name);
    }

    public String getNeighborNames() {
        String result = "";
        for (String neighbor : neighbors.keySet()) {
            result += neighbor + ", ";
        }
        return result;
    }

    public Room getRandomNeighbor() {
        ArrayList<Room> list = getNeighbors();
        return list.get((int) (Math.random() * list.size()));
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public boolean removeCreature(Creature creature) {
        return creatures.remove(creature);
    }

    public String getCreatureNames() {
        String result = "";
        for (Creature c : creatures) {
            result += c.getName() + " ";
        }
        return result;
    }

    public String getItemNames() {
        String result = "";
        for (Item item : items) {
            result += item.getName() + ", ";
        }
        return result;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItem(String name) {
        items.add(new Item(name, ""));
    }

    public Item removeItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public ArrayList<Room> getNeighbors() {
        return hashMapToArrayList(neighbors);
    }

    private ArrayList<Room> hashMapToArrayList(HashMap<String, Room> neighbors) {
        ArrayList<Room> neighborList = new ArrayList<>();
        for (String name : neighbors.keySet()) {
            neighborList.add(neighbors.get(name));
        }
        return neighborList;
    }

    public boolean equals(Room room) {
        return (this.getName().equals(room.getName()));
    }
}