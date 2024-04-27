import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        for (int ts = 0; ts < t; ts++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int a[] = new int[n];
            int b[] = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(b);
            int answer = 0;
            for (int i = 0; i < n; i++) answer += bs(a[i], b);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int bs(int a, int b[]) {
        int left = 0;
        int right = b.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (b[mid] < a) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}