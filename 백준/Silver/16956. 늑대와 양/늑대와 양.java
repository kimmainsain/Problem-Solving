import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int dy[] = new int[]{0, 1, 0, -1};
    static int dx[] = new int[]{1, 0, -1, 0};
    static char map[][];
    static int n, m;

    public static boolean solve(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nexty = y + dy[i];
            int nextx = x + dx[i];
            if (nexty > n - 1 || nexty < 0 || nextx > m - 1 || nextx < 0) continue;
            if (map[nexty][nextx] == 'S') return false;
            if (map[nexty][nextx] == 'W') continue;
            map[nexty][nextx] = 'D';
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'W') {
                    if (!solve(i, j)) {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        sb.append(1).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}