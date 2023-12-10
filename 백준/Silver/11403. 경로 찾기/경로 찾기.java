import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int map[][];
    static boolean visited[];

    private static void recur(int start) {
        for (int i = 0; i < n; i++) {
            if (map[start][i] == 0) continue;
            if (visited[i]) continue;
            visited[i] = true;
            recur(i);
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            recur(i);
            for (int j = 0; j < n; j++) {
                if (visited[j]) sb.append(1).append(" ");
                else sb.append(0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}