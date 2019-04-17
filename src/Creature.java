import java.util.ArrayList;

public abstract class Creature {
    protected Room currentRoom;
    protected String name, description;

    public Creature(Room room, String name, String description) {
        currentRoom = room;
        this.name = name;
        this.description = description;

        currentRoom.addCreature(this);
    }

    public abstract void move();

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
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

    public Room getRandomNeighbor() {
        return currentRoom.getRandomNeighbor();
    }

    public void moveToRoom(Room room) {
        this.currentRoom.removeCreature(this);
        this.currentRoom = room;
        currentRoom.addCreature(this);
        System.out.println("Moved " +  name + " to " + currentRoom.getName());
    }

    public boolean isPlayerNearRoom(Room playerRoom, Room creatureRoom) {
        ArrayList<Room> playerNeighbors1 = playerRoom.getNeighbors();

        for (Room neighbor:playerNeighbors1) {
            if (neighbor.equals(creatureRoom)) {
                return true;
            }
            ArrayList <Room> playerNeighbors2 = neighbor.getNeighbors();
            for (Room neighbor2:playerNeighbors2) {
                if (neighbor2.equals(creatureRoom)) {
                    return true;
                }
            }
        }

        return false;
    }
}


