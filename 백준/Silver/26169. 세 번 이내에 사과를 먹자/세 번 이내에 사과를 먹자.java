import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int dy[] = new int[]{0, 1, 0, -1};
    static int dx[] = new int[]{1, 0, -1, 0};

    static int n;
    static int y, x;

    static int map[][];
    static boolean visited[][];
    static boolean flag;

    public static void dfs(int y, int x, int depth, int value) {
        if (depth == 3) {
            if (value >= 2) flag = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nexty = y + dy[i];
            int nextx = x + dx[i];
            if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
            if (visited[nexty][nextx]) continue;
            if (map[nexty][nextx] == -1) continue;
            visited[nexty][nextx] = true;
            if (map[nexty][nextx] == 1) {
                dfs(nexty, nextx, depth + 1, value + 1);
                visited[nexty][nextx] = false;
            }
            if (map[nexty][nextx] == 0) {
                dfs(nexty, nextx, depth + 1, value);
                visited[nexty][nextx] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        n = 5;
        flag = false;
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        visited[y][x] = true;
        dfs(y, x, 0, 0);
        if (flag) System.out.println(1);
        else System.out.println(0);
    }
}