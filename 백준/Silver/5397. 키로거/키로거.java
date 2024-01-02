import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            ArrayDeque<Character> alpha = new ArrayDeque<>();
            ArrayDeque<Character> beta = new ArrayDeque<>();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '<') {
                    if (!alpha.isEmpty()) beta.add(alpha.pollLast());
                } else if (c == '>') {
                    if (!beta.isEmpty()) alpha.add(beta.pollLast());
                } else if (c == '-') {
                    if (!alpha.isEmpty()) alpha.pollLast();
                } else {
                    alpha.add(c);
                }
            }
            while (!alpha.isEmpty()) sb.append(alpha.pollFirst());
            while (!beta.isEmpty()) sb.append(beta.pollLast());
            sb.append("\n");
        }
        System.out.println(sb);
    }

}