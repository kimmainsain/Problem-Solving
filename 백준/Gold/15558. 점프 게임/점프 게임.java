import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static boolean visited[][];
    static int map[][];

    static Queue<int[]> qu;
    static int dy[] = new int[]{0, 0, 1};
    static int dx[] = new int[]{1, -1, 0};

    private static boolean solve() {
        qu.add(new int[]{0, 0});
        int idx = 0;
            while (!qu.isEmpty()) {
            int size = qu.size();
            visited[0][idx] = true;
            visited[1][idx++] = true;
            while (size-- > 0) {
                int now[] = qu.poll();
                for (int i = 0; i < 3; i++) {
                    int nexty = (now[0] + dy[i]) % 2;
                    int nextx = now[1] + dx[i];
                    if (i == 2) nextx += m;
                    if (nextx > n - 1) return true;
                    if (nextx < 0) continue;
                    if (visited[nexty][nextx]) continue;
                    if (map[nexty][nextx] == 0) continue;
                    qu.add(new int[]{nexty, nextx});
                    visited[nexty][nextx] = true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[2][n];
        visited = new boolean[2][n];
        qu = new ArrayDeque<>();
        String str = br.readLine();
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) map[0][i] = str.charAt(i) - 48;
        for (int i = 0; i < n; i++) map[1][i] = str2.charAt(i) - 48;
        if (solve()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}