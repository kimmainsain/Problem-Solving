import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static Map<Integer, Integer> hm;
    static boolean visited[];
    static Queue<int[]> qu;

    private static void solve() {
        visited[1] = true;
        qu.add(new int[]{1, 0});
        while (!qu.isEmpty()) {
            int now[] = qu.poll();
            for (int i = 1; i < 7; i++) {
                int next = now[0] + i;
                if (next > 100) continue;
                if (visited[next]) continue;
                if (next == 100) {
                    System.out.println(now[1] + 1);
                    return;
                }
                if (hm.containsKey(next)) {
                    int teleport = hm.get(next);
                    qu.add(new int [] {teleport, now[1] + 1});
                    visited[teleport] = true;
                    continue;
                }
                qu.add(new int [] {next, now[1] + 1});
                visited[next] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        hm = new HashMap<>();
        qu = new ArrayDeque<>();
        visited = new boolean[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            hm.put(a, b);
        }
        solve();
    }
}