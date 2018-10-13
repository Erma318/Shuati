package past.Capitalogix;

public class Q1 {

    public static Answer count(float[] input) {
        int res = 1;
        float preHigh = input[0];
        int[] arr = new int[input.length];
        arr[0] = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] > preHigh) {
                res++;
                arr[i] = 1;
                preHigh = input[i];
            } else {
                arr[i] = 0;
            }
        }
        Answer aws = new Answer();
        aws.num = res;
        aws.binary = arr;
        return aws;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//        float[] input = new float[]{3, 2, 2, 3, 4, 5, 5, 4, 6};
        float[] input = null;
        System.out.println(count(input).num);
        for (int num : count(input).binary)
            System.out.println(num);
    }

    static class Answer {
        int num;
        int[] binary;

        public Answer() {
            this.num = num;
            this.binary = binary;
        }
    }

}