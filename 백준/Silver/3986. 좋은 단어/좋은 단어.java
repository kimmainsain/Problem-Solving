import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) {
                    stack.add(c);
                } else if (stack.getLast() == c) {
                    stack.pollLast();
                } else {
                    stack.addLast(c);
                }
            }
            if (stack.isEmpty()) answer++;
            stack.clear();
        }
        System.out.println(answer);
    }
}