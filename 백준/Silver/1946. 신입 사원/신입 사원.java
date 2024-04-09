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
            int arr[] = new int [m];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a - 1] = b;
            }
            int max = 100001;
            int answer = 0;
            for (int j = 0; j < m; j++) {
                if (arr[j] < max) {
                    answer++;
                    max = arr[j];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}