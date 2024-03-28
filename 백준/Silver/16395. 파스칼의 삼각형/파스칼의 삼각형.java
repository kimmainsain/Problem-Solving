import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n + 1][n + 1];
        arr[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) arr[i][j] = 1;
                else arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        System.out.println(arr[n - 1][m - 1]);
    }
}