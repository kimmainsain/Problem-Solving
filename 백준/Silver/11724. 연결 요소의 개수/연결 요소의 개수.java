import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean visited[] = new boolean[n + 1];
        ArrayList<Integer> list[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        Queue<Integer> qu = new ArrayDeque<>();
        int count = 0;
        for (int j = 1; j <= n; j++) {
            if (visited[j]) continue;
            qu.add(j);
            while (!qu.isEmpty()) {
                int now = qu.poll();
                for (int i = 0; i < list[now].size(); i++) {
                    int v = list[now].get(i);
                    if (visited[v]) continue;
                    qu.add(v);
                    visited[v] = true;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}