import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();
        char c1[] = new char[str1.length()];
        char c2[] = new char[str2.length()];
        char c3[] = new char[str3.length()];
        for (int i = 0; i < str1.length(); i++) c1[i] = str1.charAt(i);
        for (int i = 0; i < str2.length(); i++) c2[i] = str2.charAt(i);
        for (int i = 0; i < str3.length(); i++) c3[i] = str3.charAt(i);
        int dp[][][] = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                for (int k = 1; k < str3.length() + 1; k++) {
                    if (c1[i - 1] == c2[j - 1] && c2[j - 1] == c3[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i][j - 1][k], dp[i][j][k - 1]), dp[i - 1][j][k]);
                    }
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()][str3.length()]);
    }
}