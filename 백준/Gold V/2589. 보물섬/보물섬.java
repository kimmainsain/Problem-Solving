import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, answer;
    static int dy[] = new int[]{0, 1, 0, -1};
    static int dx[] = new int[]{1, 0, -1, 0};
    static Queue<int[]> qu;
    static boolean visited[][];
    static char map[][];

    public static void solve(int y, int x) {
        int max = -1;
        qu.add(new int[]{y, x, 0});
        boolean visited2[][] = new boolean[n][m];
        visited2[y][x] = true;
        while (!qu.isEmpty()) {
            int now[] = qu.poll();
            if (now[2] > max) {
                max = now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nexty = now[0] + dy[i];
                int nextx = now[1] + dx[i];
                if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
                if (visited2[nexty][nextx]) continue;
                if (map[nexty][nextx] == 'W') continue;
                visited2[nexty][nextx] = true;
                qu.add(new int[]{nexty, nextx, now[2] + 1});
            }
        }
        answer = Math.max(answer, max);
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new char[n][m];
        qu = new ArrayDeque<>();
        answer = -1;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L' && !visited[i][j]) {
                    solve(i, j);
                }
            }
        }
        System.out.println(answer);
    }
}