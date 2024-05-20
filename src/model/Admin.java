package model;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password, "Admin");
    }

    public void approveHotel(String hotelName) {
        Hotel hotel = HotelDatabase.getHotelByName(hotelName);
        if (hotel != null) {
            hotel.setApproved(true);
            System.out.println("Hotel '" + hotelName + "' approved successfully.");
        } else {
            System.out.println("Hotel not found.");
        }
    }

    public void deleteUser(String username) {
        // Assuming a method to delete user by username
        System.out.println("User '" + username + "' deleted successfully.");
    }

    public void deleteHotel(String hotelName) {
        // Assuming a method to delete hotel by name
        System.out.println("Hotel '" + hotelName + "' deleted successfully.");
    }
}
