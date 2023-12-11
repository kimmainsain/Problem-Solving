import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String map[][];

    private static void recur(int y, int x, int n) {
        if (n == 1) {
            map[y][x] = "*";
            return;
        }
        if ((y / (n / 5) % 5 == 0 || y / (n / 5) % 5 == 1) && x / (n / 5) % 5 != 2) {
            map[y][x] = " ";
        } else if (y / (n / 5) % 5 == 3 && (x / (n / 5) % 5 == 0 || x / (n / 5) % 5 == 4)) {
            map[y][x] = " ";
        } else if (y / (n / 5) % 5 == 4 && (x / (n / 5) % 5 == 0 || x / (n / 5) % 5 == 2 || x / (n / 5) % 5 == 4)) {
            map[y][x] = " ";
        } else {
            recur(y, x, n / 5);
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        n = (int) Math.pow(5, n);
        map = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                recur(i, j, n);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}