import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int input[] = new int [n];
        st = new StringTokenizer(br.readLine());
        long right = -1;
        long left = 0;
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            input[i] = v;
            right = Math.max(right, v);
        }
        while (left <= right) {
            long mid = (right + left) / 2;
            long check = 0;
            for (int i = 0; i < n; i++) {
                if (mid <= input[i]) {
                    check += input[i] - mid;
                }
            }
            if (check >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println((long)(left + right) / 2);

    }

}