import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int INF = 1000001;
        boolean visited[] = new boolean[INF];
        visited[0] = true;
        visited[1] = true;
        for (int i = 2; i < INF / i; i++) {
            if (visited[i]) continue;
            for (int j = i * i; j < INF; j = j + i) {
                visited[j] = true;
            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int left = 0;
            int right = n;
            boolean flag = false;
            while (left <= right) {
                if (!visited[left] && !visited[right]) {
                    flag = true;
                    break;
                } else {
                    left++;
                    right--;
                }
            }
            if (flag) sb.append(n).append(" = ").append(left).append(" + ").append(right).append("\n");
            else sb.append("Goldbach's conjecture is wrong.").append("\n");
        }
        System.out.println(sb);
    }
}