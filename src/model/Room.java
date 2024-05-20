package model;

import enums.RoomType;

public class Room {
    private int roomNumber;
    private RoomType type;
    private boolean availability; // Updated field to track reservation status

    public Room(int roomNumber, RoomType type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.availability = true; // Initialize to available
    }

    public boolean isAvailable() {
        return availability;
    }

    public void book() {
        availability = false;
    }

    public void cancelBooking() {
        availability = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }
}
