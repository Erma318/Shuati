package viagogo;


import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class Q2 {
    static class Event {
        int id;
        int[] location;
        int price;
        Event(int id, int x, int y, int price) {
            this.id = id;
            location = new int[2];
            location[0] = x;
            location[1] = y;
            this.price = price;
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());
        Set<Event> eventSet = new HashSet<>();
        while(numberOfEvents > 0){
            String eventLine = scan.nextLine();
// TODO: you will need to parse and store the events
            String[] info = eventLine.split(" ");
            for (int i = 3; i < info.length; i++) {
                Event event = new Event(Integer.valueOf(info[0]),Integer.valueOf(info[1]),Integer.valueOf(info[2]),
                        Integer.valueOf(info[i]));
                eventSet.add(event);
            }
            numberOfEvents--;
        }
        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        List<int[]> buyerList = new ArrayList<>();
        while(numberOfBuyers > 0){
            String buyerLine = scan.nextLine();
// TODO: you will need to parse and store the buyers
            int[] buyer = new int[2];
            String[] info = buyerLine.split(" ");
            buyer[0] = Integer.valueOf(info[0]);
            buyer[1] = Integer.valueOf(info[1]);
            numberOfBuyers--;
        }

// The solution to the first sample above would be to output the following to console:
// (Obviously, your solution will need to figure out the output and not just hard code it)
        for (int[] buyer : buyerList) {
            if (eventSet.size() == 0) {
                System.out.println("-1 0");
            } else {
                Event theOne = null;
                for (Event event : eventSet) {
                    if (theOne == null) {
                        theOne = event;
                    } else {
                        int d1 = calculateManhattanDistance(buyer[0], buyer[1], event.location[0], event.location[1]);
                        int d2 = calculateManhattanDistance(buyer[0], buyer[1], theOne.location[0], theOne.location[1]);
                        if (d1 < d2) {
                            theOne = event;
                        } else if (d1 == d2) {
                            if (event.price < theOne.price) {
                                theOne = event;
                            } else if (event.price == theOne.price) {
                                if (event.id < theOne.id) {
                                    theOne = event;
                                }
                            }
                        }
                    }
                }
                System.out.println(theOne.id + " " + theOne.price);
                eventSet.remove(theOne);
            }
        }
    }
    // The following method get the manhatten distance betwen two points (x1,y1) and (x2,y2)
    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}