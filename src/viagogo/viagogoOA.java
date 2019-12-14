//package viagogo;
//
//public class viagogoOA {
//    class ListingApp {
//
//        private List<Listing> create (List<Event> events, List<listing> listings, SupplierAApi supplierA, SupplierBApi supplierB) {
//
//            for (Event event : events) {
//                int eventId = supplierA.getEventId(event.getName());
//                List<SupplierAListing> aListings = supplierA.getAvailableListings(eventId);
//                for (SupplierAListing l : aListings) {
//                    listings.add(new Listing(event, l.getTicketQuantity(), l.getTicketPrice(), l.getId(), "Supplier A"));
//                }
//                List<SupplierBListing> bListings = supplierB.getListings(event.getName());
//                for (SupplierBListing l : bListings) {
//                    double price = l.getTotalPrice() / l.getAvailableTickets();
//                    listings.add(new Listing(event, l.getAvailableTickets(), price, l.getListingId(), "Supplier B"));
//                }
//            }
//
//            return listings;
//        }
//
//        public static void main (String[] args) throws java.lang.Exception {
//            ViagogoApi viagogo = new ViagogoApi();
//            SupplierAApi supplierA = new SupplierAApi();
//            SupplierBApi supplierB = new SupplierBApi();
//            List<Event> events = viagogo.getEvents();
//            List<Listing> listings = new ArrayList<Listing>();
//
//            listings = create(events, listings, supplierA, supplierB);
//
//            viagogo.CreateListings(listings);
//        }
//    }
//}
