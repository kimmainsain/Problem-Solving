import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int dy[] = new int[]{0, 1, 0, -1};
    static int dx[] = new int[]{1, 0, -1, 0};

    static char map[][];
    static boolean visited[][];

    static Queue<int[]> fireQu;
    static Queue<int[]> jihun;

    static int n, m;

    private static int moveJihun() {
        int size = jihun.size();
        while (size-- > 0) {
            int now[] = jihun.poll();
            visited[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nexty = now[0] + dy[i];
                int nextx = now[1] + dx[i];
                if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
                    return now[2] + 1;
                }
                if (map[nexty][nextx] == '#') continue;
                if (visited[nexty][nextx]) continue;
                if (map[nexty][nextx] == 'F') continue;
                visited[nexty][nextx] = true;

                jihun.add(new int[]{nexty, nextx, now[2] + 1});
            }
        }
        return 0;
    }

    private static void moveFire() {
        int size = fireQu.size();
        while (size-- > 0) {
            int now[] = fireQu.poll();
            for (int i = 0; i < 4; i++) {
                int nexty = now[0] + dy[i];
                int nextx = now[1] + dx[i];
                if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
                if (map[nexty][nextx] == '#') continue;
                if (map[nexty][nextx] == 'F') continue;
                map[nexty][nextx] = 'F';
                fireQu.add(new int[]{nexty, nextx});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        fireQu = new ArrayDeque<>();
        jihun = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if (c == 'J') jihun.add(new int[]{i, j, 0});
                if (c == 'F') fireQu.add(new int[]{i, j});
                map[i][j] = c;
            }
        }
        int answer = 0;
        while (!jihun.isEmpty()) {
            moveFire();
            answer = moveJihun();
            if (answer != 0) {
                break;
            }
        }
        if (answer == 0) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }
}