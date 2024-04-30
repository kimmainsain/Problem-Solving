import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int dx[] = new int[]{0, 1, 0, -1};
    static int dy[] = new int[]{1, 0, -1, 0};
    static Queue<int[]> qu;

    static char map[][];
    static int n, m;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        qu = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char v = str.charAt(j);
                if (v == 'X') qu.add(new int[]{i, j});
                map[i][j] = v;
            }
        }
        int size = qu.size();
        while (size-- > 0) {
            int now[] = qu.poll();
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nexty = now[0] + dy[i];
                int nextx = now[1] + dx[i];
                if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1 || map[nexty][nextx] == '.') count++;
            }
            if (count < 3) {
                qu.add(new int[]{now[0], now[1]});
                map[now[0]][now[1]] = 'R';
            }
        }
        int minY = 11;
        int minX = 11;
        int maxY = -1;
        int maxX = -1;
        size = qu.size();
        while (size-- > 0) {
            int now[] = qu.poll();
            minY = Math.min(minY, now[0]);
            minX = Math.min(minX, now[1]);
            maxY = Math.max(maxY, now[0]);
            maxX = Math.max(maxX, now[1]);
        }
        for (int i = minY; i < maxY + 1; i++) {
            for (int j = minX; j < maxX + 1; j++) {
                if (map[i][j] == 'R') sb.append("X");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}