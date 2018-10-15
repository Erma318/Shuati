package syntaxTest;

public class StringReplace {
    public static void main(String[] args) {
        String url = "http://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=[topic]";
        url = url.replaceAll("\\[topic\\]", "pizza");
        System.out.println(url);
        url = "http://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=[topic]";
        url = url.replace("[topic]", "pizza");
        System.out.println(url);
    }
}
