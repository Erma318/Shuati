//package viagogo;
//
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class Q3 {
//    public static void main (String[] args) throws java.lang.Exception
//    {
//        Map<String, String> map = new HashMap<>();
//        ViagogoApi viagogo = new ViagogoApi();
//        SupplierAApi supplierA = new SupplierAApi();
//        SupplierBApi supplierB = new SupplierBApi();
//
//        List<Event> events = viagogo.getEvents();
//        List<Listing> listings = new ArrayList<Listing>();
//
//        map.put("supplierA", "SupplierAApi");
//        map.put("supplierB", "SupplierBApi");
//
//        for (Event event:events)
//        {
//            int eventId = supplierA.getEventId(event.getName());
//            List<SupplierAListing> aListings = supplierA.getAvailableListings(eventId);
//            for (SupplierAListing l : aListings)
//            {
//                listings.add(new Listing(event, l.getTicketQuantity(), l.getTicketPrice(), l.getId(), "Supplier A"));
//            }
//
//            List<SupplierBListing> bListings = supplierB.getListings(event.getName());
//            for (SupplierBListing l : bListings)
//            {
//                double price = l.getTotalPrice() / l.getAvailableTickets();
//                listings.add(new Listing(event, l.getAvailableTickets(), price, l.getListingId(), "Supplier B"));
//            }
//        }
//
//        viagogo.CreateListings(listings);
//    }
//
//    private void addToList (List<Listing> listings, Map<String, String> map, String name) {
//        String type = map.get(name);
//        switch (type) {
//            case "SupplierAApi":
//
//            case "SupplierBApi":
//        }
//    }
//}
