import java.util.Arrays;
import java.util.List;
import java.sql.Date;

import enums.RoomType;
import model.*;


                                            

public class App {
    public static void main(String[] args) throws Exception {
        // Create hotel agent and register
        HotelAgent agent = new HotelAgent("agentUsername", "agentPassword");
        agent.register();
        // Agent adds hotel details
        List<String> facilities = Arrays.asList("WiFi", "Pool", "Gym");
        agent.addHotelDetails("Grand Plaza", "New York", 100, facilities);
        agent.modifyHotelDetails("Grand Plaza", "New York City", 150, Arrays.asList("WiFi", "Pool", "Gym", "Spa"));

         
        // Create a normal user
        NormalUser user = new NormalUser("userUsername", "userPassword");
        user.register();
        // User updates details
        user.updateDetails();



        // User books a room
        Hotel hotelToBook = HotelDatabase.getHotelByName("Grand Plaza");
        if (hotelToBook != null) {
            user.bookRoom(hotelToBook, RoomType.SINGLE, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000L));
        }

        // User leaves feedback and rating
        if (hotelToBook != null) {
            hotelToBook.addFeedback("Great stay!");
            hotelToBook.addRating(5);
        }

        // Admin operations (for demonstration purposes, assuming an admin role is also implemented)
        Admin admin = new Admin("adminUsername", "adminPassword");
        admin.approveHotel("Grand Plaza");
        admin.deleteHotel("Some Other Hotel");
        
        
        
        

       
        
        // User searches for hotels
        List<Hotel> hotels = user.searchHotels("New York", RoomType.SINGLE);
        if (!hotels.isEmpty()) {
            // User selects a hotel from the list
            Hotel selectedHotel = user.selectHotel(hotels);
            if (selectedHotel != null) {
                // Display reservation status
                user.displayReservationStatus(selectedHotel);
                user.submitFeedback(selectedHotel, "Great experience! Friendly staff.");
                // User books a room in the selected hotel
                user.bookRoom(selectedHotel, RoomType.SINGLE, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 86400000L));
                
                // Display updated reservation status
                user.displayReservationStatus(selectedHotel);
                List<String> feedbacks = selectedHotel.getFeedbacks();
                System.out.println("Feedbacks for " + selectedHotel.getName() + ":");
                for (String feedback : feedbacks) {
                    System.out.println(feedback);
                }
            }
        } else {
            System.out.println("No hotels found with the given criteria.");
        }

        admin.deleteHotel("Grand Plaza");


    }


   

        
        
}
