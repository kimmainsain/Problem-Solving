import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n + 1][n + 1];
        int max = -2147483648;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }
        int answer = -2147483648;
        for (int y = 1; y < n + 1; y++) {
            for (int x = 1; x < n + 1; x++) {
                int k = 1;
                while (true) {
                    if (y - k < 0 || x - k < 0) break;
                    int v = map[y][x] - map[y - k][x] - map[y][x - k] + map[y - k][x - k];
                    answer = Math.max(answer, v);
                    k++;
                }
            }
        }
        System.out.println(answer);
    }
}