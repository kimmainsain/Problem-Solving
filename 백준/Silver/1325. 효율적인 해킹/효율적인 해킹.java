import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Queue<Integer> qu;
    static ArrayList<Integer> list[];
    static int n, m, max;
    static int answer[];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = -1;
        answer = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i < n + 1; i++) {
            qu = new ArrayDeque<>();
            qu.add(i);
            boolean vv[] = new boolean[n + 1];
            vv[i] = true;
            while (!qu.isEmpty()) {
                int now = qu.poll();
                for (int next : list[now]) {
                    if (vv[next]) continue;
                    vv[next] = true;
                    qu.add(next);
                    answer[next]++;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, answer[i]);
        }
        for (int i = 1; i < n + 1; i++) {
            if (answer[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}