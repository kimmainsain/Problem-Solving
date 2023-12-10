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
        int map[][] = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 1;
            map[x][y] = 1;
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (map[i][j] == 0 && i != j) map[i][j] = 987654321;
        for (int k = 0; k < n; k++)
            for (int s = 0; s < n; s++)
                for (int e = 0; e < n; e++)
                    if (s != e)
                        map[s][e] = Math.min(map[s][e], map[s][k] + map[k][e]);
        int answer = -1;
        int sum = 987654321;
        for (int i = 0; i < n; i++) {
            int ssum = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 987654321) continue;
                ssum += map[i][j];
            }
            if (ssum == 0) continue;
            if (ssum < sum) {
                sum = ssum;
                answer = i;
            }
        }
        System.out.println(answer + 1);
    }

}