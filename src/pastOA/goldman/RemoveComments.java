package pastOA.goldman;

public class RemoveComments {
    public static String removeComments(String[] source) {
        boolean inBlock = false; // 是否在注释块内
        StringBuilder ans = new StringBuilder();
        StringBuilder newline = new StringBuilder();

        StringBuilder buffer = new StringBuilder();

        for (String line : source) {

            int i = 0; // 从每一行的第一个字符开始
            char[] chars = line.toCharArray();

            if (!inBlock) newline = new StringBuilder(); // 如果还不在注释块内就开始新的一行

            while (i < line.length()) { // 遍历这一行的每一个字符

                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') { // 注释块开始标志，先存到 buffer
                    buffer.append("/*");
                    inBlock = true;
                    i++;
                }

                else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') { // 注释块结束标志
                    inBlock = false;
                    newline.append(" ");
                    buffer = new StringBuilder(); // 清空 buffer
                    i++;
                }

                else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') { // 注释行标志
                    break;
                }

                else if (!inBlock) {
                    newline.append(chars[i]);
                }

                else if (inBlock) { // 在 "/*" 后
                    buffer.append(chars[i]);
                }

                i++;
            }

            // 一行结束后，将有效信息存到输出
            if (!inBlock && newline.length() > 0) {
                newline.append("\n");
                ans.append(newline);
            }
            if (inBlock) {
                newline.append(" ");
                newline.append("\n");
                buffer.append("\n");

            }
        }

        // 整个结束后，如果 buffer 不为空，则加到答案
        if (buffer.length() > 0) {
            ans.append(buffer);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] input = {
                "public static void main{",
                "    System.out.print(hello,/*,world*/sdf);",
                "    /* aaaaaa",
                "    sssss*/xyz",
                "/*dfsdf",
                "}"
        };

        System.out.println(removeComments(input));
    }
}
