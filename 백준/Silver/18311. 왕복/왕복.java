import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long arr[] = new long[n * 2 + 1];
        long origin[] = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] + origin[i];
            if (arr[i] > m) {
                answer = i;
                System.out.println(answer);
                return;
            }
        }
        for (int i = n + 1; i < n * 2 + 1; i++) {
            arr[i] = arr[i - 1] + origin[n * 2 - i + 1];
            if (arr[i] > m) {
                answer = n * 2 - i + 1;
                System.out.println(answer);
                return;
            }
        }
    }
}