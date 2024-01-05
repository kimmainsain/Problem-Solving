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
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        int start = 0;
        for (int i = 0; i < n; i++) {
            long v = Long.parseLong(st.nextToken());
            if (v != 0) {
                answer += v;
                check[i] = -1;
                start = i;
            }
        }
        for (int i = 0; i < n; i++) {
            int index = (start + i) % n;
            if (check[index] == -1) continue;
            int prev = index - 1;
            int next = index + 1;
            if (index == 0) prev = n - 1;
            if (index == n - 1) next = 0;
            if (!visited[prev] && !visited[next]) {
                answer++;
                visited[index] = true;
            }
        }
        System.out.println(answer);
    }
}