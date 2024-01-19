import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][3];
        int maxDP[][] = new int[n][3];
        int minDP[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minDP[i][j] = 987654321;
            }
        }
        int max = -2147483648;
        int min = 2147483647;
        for (int i = 0; i < 3; i++) minDP[0][i] = maxDP[0][i] = map[0][i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = j - 1; k < j + 2; k++) {
                    if (k == -1 || k == 3) continue;
                    maxDP[i][j] = Math.max(maxDP[i - 1][k] + map[i][j], maxDP[i][j]);
                    minDP[i][j] = Math.min(minDP[i - 1][k] + map[i][j], minDP[i][j]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxDP[n - 1][i]);
            min = Math.min(min, minDP[n - 1][i]);
        }
        System.out.println(max + " " + min);
    }
}