import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static ArrayList<int[]> list[];

    public static void solve(int s, int e) {
        Queue<int[]> qu = new ArrayDeque<>();
        boolean visited[] = new boolean[n + 1];
        qu.add(new int [] {s, 0});
        while (!qu.isEmpty()) {
            int now[] = qu.poll();
            if (now[0] == e) {
                sb.append(now[1]);
                sb.append("\n");
                break;
            }
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            for (int i = 0; i < list[now[0]].size(); i++) {
                int next[] = list[now[0]].get(i);
                if (visited[next[0]]) continue;
                qu.add(new int [] {next[0], next[1] + now[1]});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, v});
            list[b].add(new int[]{a, v});
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            solve(s, e);
        }
        System.out.println(sb);
    }
}