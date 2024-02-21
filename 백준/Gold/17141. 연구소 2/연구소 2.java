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
    static int zeroCnt;
    static int arr[];
    static int checkCnt;

    static Queue<int[]> qu;
    static ArrayList<int[]> virus;

    public static void bfs() {
        visited = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            qu.add(new int[]{virus.get(arr[i])[0], virus.get(arr[i])[1], 0});
            visited[virus.get(arr[i])[0]][virus.get(arr[i])[1]] = true;
        }
        int count = 0;
        int tempZeroCnt = zeroCnt;
        while (!qu.isEmpty()) {
            int size = qu.size();
            while (size-- > 0) {
                int now[] = qu.poll();
                for (int i = 0; i < 4; i++) {
                    int nexty = now[0] + dy[i];
                    int nextx = now[1] + dx[i];
                    if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
                    if (visited[nexty][nextx]) continue;
                    if (map[nexty][nextx] == 1) continue;
                    visited[nexty][nextx] = true;
                    if (map[nexty][nextx] == 0) tempZeroCnt--;
                    qu.add(new int[]{nexty, nextx, now[2] + 1});
                }
            }
            if (qu.isEmpty()) break;
            count++;
        }
        if (tempZeroCnt == 0) answer = Math.min(count, answer);
    }

    public static void solve(int depth, int start) {
        if (depth == m) {
            bfs();
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            arr[depth] = i;
            solve(depth + 1, i + 1);
        }
    }

    public static void check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || map[i][j] == 2) check2(i, j);
            }
        }
    }

    public static void check2(int y, int x) {
        boolean visited[][] = new boolean[n][n];
        qu.add(new int[]{y, x});
        while (!qu.isEmpty()) {
            int now[] = qu.poll();
            for (int i = 0; i < 4; i++) {
                int nexty = now[0] + dy[i];
                int nextx = now[1] + dx[i];
                if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
                if (visited[nexty][nextx]) continue;
                if (map[nexty][nextx] == 1) continue;
                visited[nexty][nextx] = true;
                map[nexty][nextx] = 1;
                qu.add(new int [] {nexty, nextx});
            }
        }
        checkCnt++;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        answer = 2147483647;
        qu = new ArrayDeque<>();
        virus = new ArrayList<>();
        arr = new int[m];
        zeroCnt = 0;
        checkCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                if (v == 0) zeroCnt++;
                if (v == 2) virus.add(new int[]{i, j});
            }
        }
        solve(0, 0);
        check();
        if (answer == 2147483647 || checkCnt > m) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}