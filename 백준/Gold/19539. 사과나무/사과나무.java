import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int se = 0;
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            sum += t;
            se += t / 2;
        }
        if (sum % 3 == 0 && se >= sum / 3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}