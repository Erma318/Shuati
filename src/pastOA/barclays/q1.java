package pastOA.barclays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class q1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
    }

    public boolean validSquare(String line) {
        String[] input = line.split(", ");
        String[] p1s = input[0].split(",");
        int[] p1 = {Character.getNumericValue(p1s[0].charAt(1)),Character.getNumericValue(p1s[1].charAt(0))};
        String[] p2s = input[1].split(",");
        int[] p2 = {Character.getNumericValue(p2s[0].charAt(1)),Character.getNumericValue(p2s[1].charAt(0))};
        String[] p3s = input[2].split(",");
        int[] p3 = {Character.getNumericValue(p3s[0].charAt(1)),Character.getNumericValue(p3s[1].charAt(0))};
        String[] p4s = input[3].split(",");
        int[] p4 = {Character.getNumericValue(p4s[0].charAt(1)),Character.getNumericValue(p4s[1].charAt(0))};
        int p[][]={{p1[0],p1[1]},{p2[0],p2[1]},{p3[0],p3[1]},{p4[0],p4[1]}};
        int [] len;
        int cnt = 0;
        len=new int[6];
        for(int i = 0;i < 4;i++){
            for(int j = i + 1;j < 4;j++){
                len[cnt++]=(p[i][0] - p[j][0])*(p[i][0] - p[j][0])+(p[i][1] - p[j][1])*(p[i][1] - p[j][1]);
            }
        }
        Arrays.sort(len);
        if(len[0] == len[3] && len[4] == len[5] && len[4] > len[0]){
            return true;
        }
        else{
            return false;
        }
    }
}
