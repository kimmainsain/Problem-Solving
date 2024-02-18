import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean flag = false;
        loop : for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int before = 0;
            for (int j = 0; j < k; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (before == 0) {
                    before = v;
                } else {
                    if (before < v) {
                        flag = true;
                        break loop;
                    } else {
                        before = v;
                    }
                }
            }
        }
        if (flag) System.out.println("No");
        else System.out.println("Yes");
    }
}