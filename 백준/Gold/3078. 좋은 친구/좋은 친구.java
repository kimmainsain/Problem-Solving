import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> dq[] = new ArrayDeque[21];
        for (int i = 0; i < 21; i++) {
            dq[i] = new ArrayDeque<>();
        }
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int len = br.readLine().length();
            if (dq[len].isEmpty()) {
                dq[len].add(i);
                continue;
            }
            while (!dq[len].isEmpty()) {
                int front = dq[len].getFirst();
                if (i - front <= m) {
                    answer += dq[len].size();
                    break;
                } else {
                    dq[len].poll();
                }
            }
            dq[len].add(i);
        }
        System.out.println(answer);
    }
}