package model;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import enums.RoomType;

public class NormalUser extends User {
    public NormalUser(String username, String password) {
        super(username, password, "Normal User");
    }

    public void register() {
        System.out.println("Normal user registration completed.");
        // Additional implementation for user registration
    }

    public void updateDetails() {
        System.out.println("User details updated successfully.");
        // Additional implementation to update user details
    }

    public void bookRoom(Hotel hotel, RoomType roomType, Date checkInDate, Date checkOutDate) {
        List<Room> availableRooms = hotel.getAvailableRooms();
        for (Room room : availableRooms) {
            if (room.getType() == roomType) {
                room.book();
                System.out.println("Room " + room.getRoomNumber() + " booked successfully.");
                return;
            }
        }
        System.out.println("No available rooms of the specified type.");
    }

    public List<Hotel> searchHotels(String location, RoomType roomType) {
        List<Hotel> hotels = HotelDatabase.getAllHotels();
        hotels.removeIf(hotel -> !hotel.getLocation().equalsIgnoreCase(location) || hotel.getAvailableRooms().stream().noneMatch(room -> room.getType() == roomType));
        return hotels;
    }

    public Hotel selectHotel(List<Hotel> hotels) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available hotels:");
        for (int i = 0; i < hotels.size(); i++) {
            Hotel hotel = hotels.get(i);
            System.out.println((i + 1) + ". " + hotel.getName() + " in " + hotel.getLocation());
        }

        System.out.print("Select a hotel by number: ");
        int hotelNumber = scanner.nextInt();
        if (hotelNumber > 0 && hotelNumber <= hotels.size()) {
            return hotels.get(hotelNumber - 1);
        } else {
            System.out.println("Invalid selection.");
            return null;
        }
    }

    public void displayReservationStatus(Hotel hotel) {
        List<Room> rooms = hotel.getAvailableRooms();
        System.out.println("Reservation status for " + hotel.getName() + ":");
        for (Room room : rooms) {
            System.out.println("Room " + room.getRoomNumber() + ": " + (room.isAvailable() ? "Available" : "Booked"));
        }
    }
    public void submitFeedback(Hotel hotel, String feedback) {
        hotel.addFeedback(feedback);
        System.out.println("Feedback submitted successfully.");
    }
}
