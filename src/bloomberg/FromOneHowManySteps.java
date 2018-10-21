package bloomberg;


// start from 1, has operations *2, /3, return how many steps we need to get to the target n
public class FromOneHowManySteps {
    final op[] ops = {new op(3, 2) };
    static class op {
        int d;
        int n;
        op (int d, int n) {
            this.d = d;
            this.n = n;
        }
    }
    static class node {
        int n;
        int s;
        node(int n, int s) {
            this.n = n;
            this.s = s;
        }
    }
    public int find(int n) {
        int res = 0;
        return 0;
    }
}
