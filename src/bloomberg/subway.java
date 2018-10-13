package bloomberg;

import java.sql.Timestamp;

public class subway {
    public static void main(String[] args) {
        Timestamp t1 = Timestamp.valueOf("1995-03-18 12:00:00");
        Timestamp t2 = Timestamp.valueOf("1995-03-18 13:00:00");
        System.out.println(t2.getTime() - t1.getTime());
    }
}
