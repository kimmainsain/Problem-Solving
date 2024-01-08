import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int m = Integer.parseInt(st.nextToken());
        Set<Long> set = new HashSet<>();
        Queue<String> qu = new ArrayDeque<>();
        int count = 1;
        qu.add(n);
        if (Integer.parseInt(n) % m == 0) {
            System.out.println(count);
            return;
        }
        while (!qu.isEmpty()) {
            String now = Integer.toString(Integer.parseInt(qu.poll()) % m);
            long next = Long.parseLong(now + n) % m;
            count++;
            if (next == 0) {
                System.out.println(count);
                return;
            } else if (set.contains(next)) {
                System.out.println(-1);
                return;
            } else {
                set.add(next);
                qu.add(Long.toString(next));
            }
        }
    }
}