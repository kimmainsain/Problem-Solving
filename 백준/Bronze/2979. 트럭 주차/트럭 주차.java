import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int arr[] = new int [101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j < e; j++) {
                arr[j]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < 101; i++) {
            if (arr[i] == 1) ans += arr[i] * a;
            if (arr[i] == 2) ans += arr[i] * b;
            if (arr[i] == 3) ans += arr[i] * c;
        }
        System.out.println(ans);
    }
}