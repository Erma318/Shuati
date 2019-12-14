package syntaxTest;

public class Enum {
    public static void main(String[] args) {
        Weekday[] list = Weekday.values();
        for (Weekday wd : list) {
            System.out.println(wd + " ");
            System.out.println(wd.ordinal());

        }
        Weekday wd = Weekday.valueOf("Mon");
        System.out.println(wd);
        Weekday wd2 = Weekday.valueOf("Monday");
        System.out.println(wd2);
    }
}

enum Weekday {
    Mon, Tue, Wed, Thu, Fri, Sat, Sun
}
