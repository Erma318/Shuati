package syntaxTest;

public class generic<T> { // 肯定要在class声明<T>
    public static <T> void test1(T tt) {// 对于静态的test21来说，无需new syntaxTest.generic（）；就可以使用它。
        // 那么如果在test1中不再重新声明T，那么Java还是不知道T是某种type。

    }

    public void test2(T tt) {// 对于非静态的test2来说，我要使用它必须去new syntaxTest.generic（）；
        // 所以对于test2来说它里面用到的T已经被声明过了。Java直到T是某种type。

    }

    public static void main(String[] args) {
        test1(3);
        generic here = new generic();
        here.test2(3);
    }
}
