import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int arr[];

    private static void dfs(int sum, int depth) {
        if (sum == n) {
            if (--m != 0) return;
            for (int i = 1; i < 11; i++) {
                if (arr[i] == 0) break;
                sb.append(arr[i]);
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (sum + i > n || m == 0) return;
            arr[depth] = i;
            dfs(sum + i, depth + 1);
            arr[depth] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[11];
        dfs(0, 1);
        System.out.println(sb.length() == 0 ? -1 : String.join("+", sb.toString().split("")));
    }
}