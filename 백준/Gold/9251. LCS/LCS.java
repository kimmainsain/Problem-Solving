import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String a = br.readLine();
        String b = br.readLine();
        char alpha[] = new char[a.length()];
        char beta[] = new char[b.length()];
        for (int i = 0; i < a.length(); i++) alpha[i] = a.charAt(i);
        for (int i = 0; i < b.length(); i++) beta[i] = b.charAt(i);
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (alpha[i - 1] == beta[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}