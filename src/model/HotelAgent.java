package model;

import java.util.List;

public class HotelAgent extends User {
    public HotelAgent(String username, String password) {
        super(username, password, "Hotel Agent");
    }

    public void register() {
        System.out.println("Hotel Agent registration completed.");
        // Additional implementation for agent registration
    }

    public void addHotelDetails(String name, String location, int numberOfRooms, List<String> facilities) {
        Hotel newHotel = new Hotel(name, location, numberOfRooms, facilities);
        HotelDatabase.addHotel(newHotel);
        System.out.println("Hotel details added successfully.");
    }

    public void modifyHotelDetails(String hotelName, String newLocation, int newNumberOfRooms, List<String> newFacilities) {
        Hotel hotel = HotelDatabase.getHotelByName(hotelName);
        if (hotel != null) {
            hotel.setLocation(newLocation);
            hotel.setNumberOfRooms(newNumberOfRooms);
            hotel.setFacilities(newFacilities);
            System.out.println("Hotel details modified successfully.");
        } else {
            System.out.println("Hotel not found.");
        }
    }
}
