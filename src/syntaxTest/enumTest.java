package syntaxTest;

public class enumTest {
    enum Color {
        Red, Green, Blue;
    }

    public static void main(String[] args) {
        Color c1 = Color.Red;
        System.out.println(c1);
        if (c1 == Color.Red) {
            System.out.println("this is red");
        }
        System.out.println(Color.valueOf("Red"));
    }
}
