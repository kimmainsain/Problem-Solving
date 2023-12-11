import java.sql.Array;
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

    static int n, m;
    static int count;
    static Queue<int[]> qu;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        qu = new ArrayDeque<>();
        int y = 0;
        int x = 0;
        count = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    y = i;
                    x = j;
                }
            }
        }
        bfs(y, x);
        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    private static void bfs(int y, int x) {
        qu.add(new int[]{y, x});
        visited[y][x] = true;
        while (!qu.isEmpty()) {
            int now[] = qu.poll();
            for (int i = 0; i < 4; i++) {
                int nexty = now[0] + dy[i];
                int nextx = now[1] + dx[i];
                if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
                if (visited[nexty][nextx]) continue;
                if (map[nexty][nextx] == 'X') continue;
                if (map[nexty][nextx] == 'P') count++;
                visited[nexty][nextx] = true;
                qu.add(new int[]{nexty, nextx});
            }
        }
    }

}