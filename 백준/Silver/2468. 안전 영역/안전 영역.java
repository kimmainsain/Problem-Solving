import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int dy[] = new int[]{0, 1, 0, -1};
    static int dx[] = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> qu = new ArrayDeque<>();
        int count = n * n;
        int max = -2147483648;
        for (int i = 0; i < 101; i++) {
            boolean visited[][] = new boolean[n][n];
            if (count == 0) break;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int v = map[j][k];
                    if (v > i) continue;
                    if (v == -1) continue;
                    map[j][k] = -1;
                    count--;
                }
            }
            int check = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (visited[j][k]) continue;
                    if (map[j][k] == -1) continue;
                    qu.add(new int [] {j, k});
                    check++;
                    while(!qu.isEmpty()) {
                        int now[] = qu.poll();
                        for (int l = 0; l < 4; l++) {
                            int nexty = now[0] + dy[l];
                            int nextx = now[1] + dx[l];
                            if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
                            if (visited[nexty][nextx]) continue;
                            if (map[nexty][nextx] == -1) continue;
                            visited[nexty][nextx] = true;
                            qu.add(new int [] {nexty, nextx});
                        }
                    }
                }
            }
            max = Math.max(max, check);
        }
        System.out.println(max);
    }
}