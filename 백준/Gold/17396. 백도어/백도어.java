import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static boolean visited[];
    static PriorityQueue<long[]> pq;
    static long range[];
    static ArrayList<long[]> list[];
    static int n, m;

    private static void solve() {
        pq.add(new long[]{0, 0});
        visited[n - 1] = false;
        while (!pq.isEmpty()) {
            long now[] = pq.poll();
            if (now[0] == n - 1) break;
            if (visited[(int)now[0]]) continue;
            visited[(int)now[0]] = true;
            for (int i = 0; i < list[(int)now[0]].size(); i++) {
                int nexty = (int)list[(int)now[0]].get(i)[0];
                long nextv = list[(int)now[0]].get(i)[1];
                if (visited[nexty]) continue;
                if (range[nexty] > nextv + now[1]) {
                    range[nexty] = nextv + now[1];
                    pq.add(new long[]{nexty, range[nexty]});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        visited = new boolean[n];
        range = new long[n];
        st = new StringTokenizer(br.readLine());
        pq = new PriorityQueue<>((o1, o2) -> (int)(o1[1] - o2[1]));
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (t == 1) visited[i] = true;
            list[i] = new ArrayList<>();
            range[i] = Long.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            list[a].add(new long[]{b, v});
            list[b].add(new long[]{a, v});
        }
        solve();
        if (range[n - 1] == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(range[n - 1]);
    }
}