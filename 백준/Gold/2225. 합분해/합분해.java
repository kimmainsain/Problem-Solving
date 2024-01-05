import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int dp[][] = new int [k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            dp[i][1] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] % 1000000000 + dp[i][j - 1] % 1000000000) % 1000000000;
            }
        }
        System.out.println(dp[k][n]);
    }
}