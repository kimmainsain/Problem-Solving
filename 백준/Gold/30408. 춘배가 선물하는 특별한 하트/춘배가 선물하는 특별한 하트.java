import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        Queue<Long> qu = new ArrayDeque<>();
        Set<Long> set = new HashSet<>();
        qu.add(n);
        while (!qu.isEmpty()) {
            long value = qu.poll();
            if (value == m) {
                System.out.println("YES");
                return;
            } else if (value < m) continue;
            if (value % 2 == 0) {
                if (set.contains(value / 2)) continue;
                qu.add(value / 2);
                set.add(value / 2);
            } else {
                if (!set.contains(value / 2)) {
                    qu.add(value / 2);
                    set.add(value / 2);
                }
                if (!set.contains(value / 2 + 1)) {
                    qu.add(value / 2 + 1);
                    set.add(value / 2 + 1);
                }
            }
        }
        System.out.println("NO");
    }
}