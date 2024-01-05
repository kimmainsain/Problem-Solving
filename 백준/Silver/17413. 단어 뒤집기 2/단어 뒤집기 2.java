import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                flag = true;
            } else if (c == ' ' && !flag) {
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(" ");
            } else if (c == '>') {
                sb.append('>');
                flag = false;
            } else if (!flag) stack.add(c);
            if (flag) sb.append(c);
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
}