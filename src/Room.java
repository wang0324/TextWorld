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
        ArrayList<Room> list = convertMaptoArrayList();
        return list.get((int)(Math.random() * list.size()));
    }

    public Room getRandomNeighbor(ArrayList <Room> roomsToAvoid) {
        for (Room neighbor:) {

        }
    }

    private ArrayList<Room> convertMaptoArrayList() {
        ArrayList<Room> arr = new ArrayList<>();
        for (String key : neighbors.keySet()) {
            arr.add(neighbors.get(key));
        }
        return arr;
    }


    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public boolean removeCreature(Creature creature) {
        return creatures.remove(creature);
    }

    public String getCreatureNames() {
        String result = "";
        for (String name : creatures.keySet()) {
            result += name + ", ";
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

    public void removeItem(String item) {
        items.remove(item);
    }

    public boolean containsNeighbor(Room neighbor) {
        if (neighbors.get(neighbor.getName()) == null) {
            return false;
        }
        return true;
    }

    public boolean containsNeighbor(String name) {
        for (String neighbor : neighbors.keySet()) {
            if (name.equals(neighbor)) return true;
        }
        return false;
    }


    public ArrayList<Room> getNeighbors() {
        return hashMapToArrayList(neighbors);
    }

    private ArrayList<Room> hashMapToArrayList(HashMap<String,Room> neighbors) {
        ArrayList <Room> neighborList = new ArrayList<>();
        for (String name:neighbors.keySet()) {
            neighborList.add(neighbors.get(name));
        }
        return neighborList;
    }

    public boolean equals(Room room) {
        return (this.getName().equals(room.getName()));
    }
}