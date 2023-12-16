import java.util.*;
import java.io.*;

class node {
    int number;
    String answer;

    public node(int number, String answer) {
        this.number = number;
        this.answer = answer;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Queue<node> qu;
    static int before;
    static int after;
    static boolean visited[];

    private static void solve() {
        qu.add(new node(before, ""));
        visited[before] = true;
        while (!qu.isEmpty()) {
            node now = qu.poll();
            if (now.number == after) {
                sb.append(now.answer).append("\n");
                return;
            }
            int d = now.number * 2 % 10000;
            int s = now.number - 1;
            int cheon = now.number / 1000;
            int il = now.number % 10;
            int l = now.number * 10 - cheon * 10000 + cheon;
            int r = now.number / 10 + il * 1000;
            if (s < 0) s = 9999;
            if (!visited[d]) {
                visited[d] = true;
                qu.add(new node(d, now.answer + "D"));
            }
            if (!visited[s]) {
                visited[s] = true;
                qu.add(new node(s, now.answer + "S"));
            }
            if (!visited[l]) {
                visited[l] = true;
                qu.add(new node(l, now.answer + "L"));

            }
            if (!visited[r]) {
                visited[r] = true;
                qu.add(new node(r, now.answer + "R"));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            qu = new ArrayDeque<>();
            before = Integer.parseInt(st.nextToken());
            after = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            solve();
        }
        System.out.println(sb);
    }
}