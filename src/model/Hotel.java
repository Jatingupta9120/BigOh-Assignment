package model;

import enums.RoomType;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String location;
    private int numberOfRooms;
    private List<Room> rooms;
    private List<String> facilities;
    private boolean approved;
    private List<String> feedbacks;
    private List<Integer> ratings;

    public Hotel(String name, String location, int numberOfRooms, List<String> facilities) {
        this.name = name;
        this.location = location;
        this.numberOfRooms = numberOfRooms;
        this.facilities = facilities;
        this.rooms = new ArrayList<>();
        this.approved = false;
        this.feedbacks = new ArrayList<>();
        this.ratings = new ArrayList<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.add(new Room(i, RoomType.SINGLE)); // Simplified to SINGLE type for example
        }
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void addFeedback(String feedback) {
        feedbacks.add(feedback);
    }

    public List<String> getFeedbacks() {
        return feedbacks;
    }

    public void addRating(int rating) {
        ratings.add(rating);
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return (double) sum / ratings.size();
    }
}
