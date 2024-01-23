import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, len;
    static String str;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        len = n - m;
        str = br.readLine();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int now = str.charAt(i) - 48;
            if (dq.isEmpty()) {
                dq.add(now);
            } else {
                while (!dq.isEmpty() && dq.getLast() < now && m > 0) {
                    dq.pollLast();
                    m--;
                }
                dq.add(now);
            }
        }
        while(!dq.isEmpty() && len-- > 0) sb.append(dq.poll());
        System.out.println(sb);
    }
}