import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int n = 0;
        boolean flag = false;
        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            n += c - 48;
            pq.add(c);
            if (c - 48 == 0) flag = true;
        }
        if (!flag || n % 3 != 0) {
            System.out.println(-1);
            return;
        }
        while (!pq.isEmpty()) sb.append(pq.poll());
        System.out.println(sb);
    }
}