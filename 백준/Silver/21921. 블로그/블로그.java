import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[] = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            map[i] += map[i - 1];
        }
        int max = -2147483648;
        int count = 0;
        for (int i = m; i < n + 1; i++) {
            int sub = map[i] - map[i - m];
            if (max < sub) {
                count = 1;
                max = sub;
            } else if (max == sub) {
                count++;
            }
        }
        sb.append(max == 0 ? "SAD": max + "\n" + count);
        System.out.println(sb);
    }
}