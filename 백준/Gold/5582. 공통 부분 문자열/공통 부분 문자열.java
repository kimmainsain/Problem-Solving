import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String a = br.readLine();
        String b = br.readLine();
        int dp[][] = new int[a.length()][b.length()];
        int max = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, 1);
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}