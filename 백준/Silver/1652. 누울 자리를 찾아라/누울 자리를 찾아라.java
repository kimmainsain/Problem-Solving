import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        char arr[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int c = 0, r = 0, answerC = 0, answerR = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.') c++;
                if (arr[j][i] == '.') r++;
                if (arr[i][j] == 'X' || j == n - 1) {
                    if (c >= 2) answerC++;
                    c = 0;
                }
                if (arr[j][i] == 'X' || j == n - 1) {
                    if (r >= 2) answerR++;
                    r = 0;
                }
            }
        }
        System.out.println(answerC + " " + answerR);
    }
}