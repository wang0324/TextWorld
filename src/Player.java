import java.util.ArrayList;

public class Player {

    private String name, description;

    private Room currentRoom;

    private ArrayList<Item> inventory;

    public Player(Room currentRoom, String name, String description) {
        this.name = name;
        this.description = description;
        this.currentRoom = currentRoom;

        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public boolean takeItem(String name) {
        Item item = currentRoom.removeItem(name);
        if (item != null) {
            inventory.add(item);
            return true;
        }
        return false;
    }

    public Item removeItem(String name) {
        for (Item item : inventory) {
            if (item.getName().equals(name)) {
                inventory.remove(item);
                return item;
            }
        }
        return null;
    }

    public boolean dropItem(String name) {
        Item item = removeItem(name);
        if (item == null) return false;
        this.getCurrentRoom().addItem(item);
        return true;
    }

    public boolean destroyItem(String name) {
        for (Item item : inventory) {
            if (item.getName().equals(name)) {
                return inventory.remove(item);
            }
        }
        return false;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void displayInventory() {
        System.out.println("Items in Inventory: ");
        String result = "";
        for (Item item : inventory) {
            result += item.getName() + ": " + item.getDescription() + "\n";
        }
        System.out.println(result);
    }

    public boolean moveToRoom(String name) {
        Room room = currentRoom.getNeighbor(name);
        if (room != null) {
            this.setCurrentRoom(room);
            return true;
        }
        return false;
    }
}
