package bnyOA;

public class HTMLEntityCodes {
    public String replace(String original) {
        if (original == null || original.length() == 0) return original;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == '<') {
                sb.append("&lt;");
            } else if (original.charAt(i) == '>') {
                sb.append("&gt;");
            } else if (original.charAt(i) == '&') {
                sb.append("&amp;");
            } else {
                sb.append(original.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HTMLEntityCodes here = new HTMLEntityCodes();
        System.out.println(here.replace("Hello < World > Goodbye & World"));
    }
}
