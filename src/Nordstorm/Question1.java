package Nordstorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Question1 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int[] pre = new int[300];
        int[] cur = new int[300];
        while ((line = in.readLine()) != null) {
            String[] nums = line.split(" ");
            for (int i = 0; i < nums.length; i++) {
                int left = i - 1;
                int right = i;
                if (left >= 0) {
                    cur[i] = pre[left] + Integer.valueOf(nums[i]);
                }
                cur[i] = Math.max(cur[i], pre[right] + Integer.valueOf(nums[i]));
            }
            pre = Arrays.copyOf(cur, cur.length);
        }
        int res = Integer.MIN_VALUE;
        for (int x : cur) {
            res = Math.max(res, x);
        }
        System.out.println(res);
    }
}