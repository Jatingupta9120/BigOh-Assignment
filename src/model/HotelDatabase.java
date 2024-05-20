package model;

import java.util.ArrayList;
import java.util.List;

public class HotelDatabase {
    private static List<Hotel> hotels = new ArrayList<>();

    // Method to add a hotel to the database
    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    // Method to retrieve all hotels from the database
    public static List<Hotel> getAllHotels() {
        return hotels;
    }

    // Method to retrieve a specific hotel by name
    public static Hotel getHotelByName(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(name)) {
                return hotel;
            }
        }
        return null; // Hotel not found
    }

    // Method to update hotel details
    public static void updateHotelDetails(String name, String location, int numberOfRooms, List<String> facilities) {
        Hotel hotel = getHotelByName(name);
        if (hotel != null) {
            hotel.setLocation(location);
            hotel.setNumberOfRooms(numberOfRooms);
            hotel.setFacilities(facilities);
        } else {
            System.out.println("Hotel not found in the database.");
        }
    }

    // Method to delete a hotel from the database
    public static void deleteHotel(String name) {
        hotels.removeIf(hotel -> hotel.getName().equalsIgnoreCase(name));
    }
}
