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
        boolean visited[] = new boolean[n + 1];
        visited[1] = true;
        for (int i = 2; i < n + 1; i++) {
            if (visited[i]) continue;
            for (int j = i; j < n + 1; j += i) {
                if (!visited[j]) {
                    m--;
                    visited[j] = true;
                }
                if (m == 0) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}