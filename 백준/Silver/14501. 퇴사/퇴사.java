import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int day[] = new int[n + 2];
        int value[] = new int[n + 2];
        int dp[] = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            day[i] = a;
            value[i] = b;
        }
        for (int i = 1; i < n + 1; i++) {
            int idx = i + day[i];
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (idx > n + 1) continue;
            dp[idx] = Math.max(dp[i] + value[i], dp[idx]);
        }
        int max = -1;
        for (int i = 0; i < n + 2; i++) max = Math.max(dp[i], max);
        System.out.println(max);
    }
}