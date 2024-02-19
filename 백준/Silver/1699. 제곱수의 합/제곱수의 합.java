import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int [n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = 999999;
            for (int j = 1; j * j < i + 1; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}