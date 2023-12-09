import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, white, blue;
    static int map[][];

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        white = 0;
        blue = 0;
        recursive(0, 0, n);
        System.out.println(white + "\n" + blue);
    }

    private static void recursive(int y, int x, int end) {
        int flag = map[y][x];
        for (int i = y; i < end + y; i++) {
            for (int j = x; j < end + x; j++) {
                if (flag != map[i][j]) {
                    recursive(y, x, end / 2);
                    recursive(y + end / 2, x, end / 2);
                    recursive(y, x + end / 2, end / 2);
                    recursive(y + end / 2, x + end / 2, end / 2);
                    return;
                }
            }
        }
        if (flag == 1) blue++;
        else white++;
    }
}