import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        boolean visited[] = new boolean [n];
        int check[] = new int [n];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v != 0) {
                answer += v;
                check[i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (check[i] == -1) continue;
            int prev = i - 1;
            int next = i + 1;
            if (i == 0) prev = n - 1;
            if (i == n - 1) next = 0;
            if (!visited[prev] && !visited[next]) {
                answer++;
                visited[i] = true;
            }
        }
        System.out.println(answer);
    }
}