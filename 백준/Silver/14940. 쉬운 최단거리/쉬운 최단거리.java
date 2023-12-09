import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        int answer[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];
        int dy[] = new int[]{0, 1, 0, -1};
        int dx[] = new int[]{1, 0, -1, 0};
        int ay = 0, ax = 0;
        Queue<int[]> qu = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    ay = i;
                    ax = j;
                }
            }
        }
        qu.add(new int[]{ay, ax});
        visited[ay][ax] = true;
        int count = 1;
        while (!qu.isEmpty()) {
            int size = qu.size();
            while (size-- > 0) {
                int now[] = qu.poll();
                for (int i = 0; i < 4; i++) {
                    int nexty = now[0] + dy[i];
                    int nextx = now[1] + dx[i];
                    if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) continue;
                    if (map[nexty][nextx] != 1) continue;
                    if (visited[nexty][nextx]) continue;
                    visited[nexty][nextx] = true;
                    answer[nexty][nextx] = count;
                    qu.add(new int[]{nexty, nextx, count});
                }
            }
            count++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    sb.append("-1 ");
                    continue;
                }
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}