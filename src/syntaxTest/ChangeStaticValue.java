package syntaxTest;

public class ChangeStaticValue {
    public static int age = 10;

    public static void main(String[] args) {
        ChangeStaticValue a = new ChangeStaticValue();
        ChangeStaticValue b = new ChangeStaticValue();
        ChangeStaticValue.age = 11;
        System.out.println(a.age);
        ChangeStaticValue.age = 12;
        System.out.println(b.age);
    }
}


