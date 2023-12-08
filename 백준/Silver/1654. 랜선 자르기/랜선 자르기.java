import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static long lan[];
    static long right;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lan = new long[n];
        right = -1;
        for (int i = 0; i < n; i++) {
            lan[i] = Long.parseLong(br.readLine());
            right = Math.max(right, lan[i]);
        }
        BS();
    }

    private static void BS() {
        long left = 1;
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += lan[i] / mid;
            }
            if (count < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println((left + right) / 2);
    }
}