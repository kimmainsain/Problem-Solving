import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long left = 1;
        long right = (long)n * n;
        while (left != right) {
            long mid = (left + right) / 2;
            if (solve(n, mid) < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    public static long solve(int n, long mid) {
        long c = 0;
        for (int i = 1; i <= n; i++) {
            c += Math.min(mid / i, n);
        }
        return c;
    }
}