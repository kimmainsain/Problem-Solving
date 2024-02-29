import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int a, b, c;
    static boolean flag;
    static Set<Integer> set;
    static PriorityQueue<Integer> pq;

    public static void dfs(int a, int b, int c) {
        if (flag) return;
        if (a == b && b == c) {
            flag = true;
            return;
        }
        if (a == 0 || b == 0 || c == 0) return;
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int sum = 0;
        while (!pq.isEmpty()) {
            int now = pq.poll();
            if (now > 999) {
                sum *= 10000;
            } else if (now > 99) {
                sum *= 1000;
            } else if (now > 9) {
                sum *= 100;
            } else {
                sum *= 10;
            }
            sum += now;
        }
        if (set.contains(sum)) {
            return;
        }
        set.add(sum);

        if (a < b) {
            dfs(a + a, b - a, c);
        }
        if (b < a) {
            dfs(a - b, b + b, c);
        }
        if (a < c) {
            dfs(a + a, b, c - a);
        }
        if (c < a) {
            dfs(a - c, b, c + c);
        }
        if (b < c) {
            dfs(a, b + b, c - b);
        }
        if (c < b) {
            dfs(a, b - c, c + c);
        }
    }

    public static void main(String[] args) throws Exception {
        flag = false;
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        if ((a + b + c) % 3 == 0) {
            dfs(a, b, c);
        }
        if (flag) System.out.println(1);
        else System.out.println(0);
    }
}