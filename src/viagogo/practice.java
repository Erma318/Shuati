package viagogo;


import java.util.*;



public class practice{
    private static class Event {
        int distance;
        int price;
        int id;
        Event (int distance, int price, int id) {
            this.distance = distance;
            this.price = price;
            this.id = id;
        }
    }

    private static Event[] range (List<Event> list) {
        Event[] res = new Event[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                if (o1.distance == o2.distance) {
                    if (o1.price == o2.price) {
                        return o1.id < o2.id ? -1 : 1;
                    } else {
                        return o1.price < o2.price ? -1 : 1;
                    }
                } else {
                    return o1.distance < o2.distance ? -1 : 1;
                }
            }
        });

        return res;
    }


    public static void main(String[] args) {
        practice machine = new practice();
        Event a = new Event(1,2,1);
        Event b = new Event(2,2,2);
        Event c = new Event(1,1,3);
        List<Event> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        Event[] ress = range(list);
        for (Event res : ress) {
            System.out.println(res.id);
        }
    }
}
