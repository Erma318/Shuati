package f5tech;

public class q2 {
    static String NameSwap(String name) {
        if (name == null || name.length() == 0) return "Invalid Input";
        String[] input = name.split(" ");
        if (input.length == 1) {
            return "Invalid Input";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(input[1]);
        sb.append(", ");
        sb.append(input[0]);
        return sb.toString();

    }
}
