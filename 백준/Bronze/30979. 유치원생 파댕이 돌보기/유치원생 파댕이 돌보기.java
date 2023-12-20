import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int a = 0;
        for (int i = 0; i < m; i++) {
            a += Integer.parseInt(st.nextToken());
            if (a >= n) {
                System.out.println("Padaeng_i Happy");
                return;
            }
        }
        System.out.println("Padaeng_i Cry");
    }
}