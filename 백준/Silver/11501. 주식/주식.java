import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int arr[] = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = -1;
            long answer = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (max < arr[j]) {
                    max = arr[j];
                } else {
                    answer += max - arr[j];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}