import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, answer;
    static int map[][];
    static int dp[][];
    static final int dy[] = new int[]{0, 1, 0, -1};
    static final int dx[] = new int[]{1, 0, -1, 0};

    public static int dfs(int y, int x, int weight) {
        if (y == n - 1 && x == m - 1) {
            return 1;
        }
        if (dp[y][x] != -1) return dp[y][x];
        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nexty = y + dy[i];
            int nextx = x + dx[i];
            if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
            if (map[nexty][nextx] >= weight) continue;
            dp[y][x] += dfs(nexty, nextx, map[nexty][nextx]);
        }
        return dp[y][x];
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(dfs(0, 0, map[0][0]));
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
    }
}