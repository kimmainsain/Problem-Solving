import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        int max = -2147483648;
        for (int i = 0; i < n - m + 1; i++) {
            int sum = 0;
            for (int j = i; j < m + i; j++) {
                sum += map[j];
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}