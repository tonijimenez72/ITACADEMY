package scapeRoom.room;

import scapeRoom.clue.Clue;
import scapeRoom.decoration.Decoration;

import java.util.ArrayList;

class Room {
    private static int idCounter = 0;
    private final int id;
    private String name;
    private DifficultyLevel level;
    private double roomPrice;
    private ArrayList<Clue> clues;
    private ArrayList<Decoration> decorations;

    public Room(int id, String name, DifficultyLevel level, double roomPrice, ArrayList<Clue> clues, ArrayList<Decoration> decorations) {
        this.id = ++idCounter;
        this.name = name;
        this.level = level;
        this.roomPrice = roomPrice;
        this.clues = clues;
        this.decorations = decorations;
   }

    public static int getIdCounter() {
        return idCounter;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public DifficultyLevel getLevel() {
        return level;
    }
    public double getRoomPrice() {
        return roomPrice;
    }
    public ArrayList<Clue> getClues() {
        return clues;
    }
    public ArrayList<Decoration> getDecorations() {
        return decorations;
    }

    public static void setIdCounter(int idCounter) {
        Room.idCounter = idCounter;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLevel(DifficultyLevel level) {
        this.level = level;
    }
    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }
    public void setClues(ArrayList<Clue> clues) {
        this.clues = clues;
    }
    public void setDecorations(ArrayList<Decoration> decorations) {
        this.decorations = decorations;
    }

    @Override
    public String toString() {
        return "Room" +
                "\n ID: " + id +
                "\n Name: " + name +
                "\n Difficulty Level: " + level +
                "\n Room Price: " + roomPrice +
                "\n Clues: " + clues +
                "\n Decorations: " + decorations;
    }
}
