import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int dy[] = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int dx[] = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    static boolean visited[][];
    static Queue<int[]> qu;
    static int targetY, targetX;

    public static void bfs() {
        while(!qu.isEmpty()) {
            int now[] = qu.poll();
            if (now[0] == targetY && now[1] == targetX) {
                sb.append(now[2]).append("\n");
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nexty = now[0] + dy[i];
                int nextx = now[1] + dx[i];
                if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
                if (visited[nexty][nextx]) continue;
                visited[nexty][nextx] = true;
                qu.add(new int [] {nexty, nextx, now[2] + 1});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++){
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];
            qu = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int nowY = Integer.parseInt(st.nextToken());
            int nowX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetY = Integer.parseInt(st.nextToken());
            targetX = Integer.parseInt(st.nextToken());
            qu.add(new int [] {nowY, nowX, 0});
            visited[nowY][nowX] = true;
            bfs();
        }
        System.out.println(sb);
    }
}