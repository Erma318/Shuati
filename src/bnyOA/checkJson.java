package bnyOA;

public class checkJson {
    static boolean checkJSON(String jsonstring) {
        if (jsonstring.charAt(0) != '{' || jsonstring.charAt(jsonstring.length() - 1) != '}')
            return false;
        String input = jsonstring.substring(1, jsonstring.length() - 1);
        if (input.contains(",")) {
            String[] in = input.split(",");
            for (String x : in) {
                if (!check(x)) {
                    return false;
                }
            }

        } else {
            if (!check(input)) {
                return false;
            }
        }
        return true;

    }

    static boolean check(String in) {
        in = in.trim();
        String[] input = in.split(":");
        input[0] = input[0].trim();
        input[1] = input[1].trim();
        if (input[0].charAt(0) != '"' || input[0].charAt(input[0].length() - 1) != '"') {
            return false;
        }
        if (input[1].charAt(0) != '"' || input[1].charAt(input[1].length() - 1) != '"') {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkJSON("{\"test\":\"Hello\"}"));
    }
}
