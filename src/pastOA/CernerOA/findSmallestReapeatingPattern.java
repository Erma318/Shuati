package pastOA.CernerOA;

public class findSmallestReapeatingPattern {
    public String find(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < s.length() / i; j++)
                     sb.append(s.substring(0, i));
                if (s.equals(sb.toString()))
                    return s.substring(0, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        findSmallestReapeatingPattern here = new findSmallestReapeatingPattern();
        System.out.println(here.find("abcebcabcebc"));
    }

}
