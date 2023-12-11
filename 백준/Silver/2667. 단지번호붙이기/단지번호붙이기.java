import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int dy[] = new int[]{0, 1, 0, -1};
    static int dx[] = new int[]{1, 0, -1, 0};
    static int map[][];
    static boolean visited[][];

    static int n;
    static Queue<int[]> qu;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        qu = new ArrayDeque<>();
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - 48;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == 0) continue;
                bfs(i, j);
            }
        }
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int y, int x) {
        qu.add(new int [] {y, x});
        visited[y][x] = true;
        int count = 1;
        while(!qu.isEmpty()) {
            int now[] = qu.poll();
            for (int i = 0; i < 4; i++) {
                int nexty = now[0] + dy[i];
                int nextx = now[1] + dx[i];
                if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
                if (visited[nexty][nextx]) continue;
                if (map[nexty][nextx] == 0) continue;
                visited[nexty][nextx] = true;
                qu.add(new int [] {nexty, nextx});
                count++;
            }
        }
        pq.add(count);
    }

}