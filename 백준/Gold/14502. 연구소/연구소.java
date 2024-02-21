import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int map[][];
    static int dy[] = new int[]{0, 1, 0, -1};
    static int dx[] = new int[]{1, 0, -1, 0};
    static boolean visited[][];
    static int answer = 0;

    static int arrPerY[];
    static int arrPerX[];

    static Queue<int[]> qu;

    public static void bfs() {
        int tempMap[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            tempMap[i] = map[i].clone();
        }
        for (int i = 0; i < 3; i++) {
            if (map[arrPerY[i]][arrPerX[i]] == 1) return;
            if (map[arrPerY[i]][arrPerX[i]] == 2) return;
            if (tempMap[arrPerY[i]][arrPerX[i]] == 1) return;
            tempMap[arrPerY[i]][arrPerX[i]] = 1;
        }
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 2) {
                    qu.add(new int[]{i, j});
                }
            }
        }
        while (!qu.isEmpty()) {
            int now[] = qu.poll();
            for (int i = 0; i < 4; i++) {
                int nexty = now[0] + dy[i];
                int nextx = now[1] + dx[i];
                if (nexty < 0 || nexty >= n || nextx < 0 || nextx >= m) continue;
                if (tempMap[nexty][nextx] == 1) continue;
                if (tempMap[nexty][nextx] == 2) continue;
                tempMap[nexty][nextx] = 2;
                qu.add(new int[]{nexty, nextx});
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }

    public static void PermutationX(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < m; i++) {
            arrPerX[depth] = i;
            PermutationX(depth + 1);
        }
    }

    public static void PermutationY(int depth) {
        if (depth == 3) {
            PermutationX(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            arrPerY[depth] = i;
            PermutationY(depth + 1);
        }
    }

    public static void solve() {
        PermutationY(0);
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        arrPerX = new int[3];
        arrPerY = new int[3];
        answer = 0;
        qu = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(answer);
    }
}