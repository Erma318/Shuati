package bnyOA;

public class HTMLEntityCodes {
    public String replace(String in) {
        if (in == null || in.length() == 0) return in;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '<') {
                sb.append("&lt;");
            } else if (in.charAt(i) == '>') {
                sb.append("&gt;");
            } else if (in.charAt(i) == '&') {
                sb.append("&amp;");
            } else {
                sb.append(in.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HTMLEntityCodes here = new HTMLEntityCodes();
        System.out.println(here.replace("Hello < World > Goodbye & World"));
    }
}
