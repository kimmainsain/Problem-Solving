import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            StringBuilder temp = new StringBuilder();
            temp.append(str).deleteCharAt(m - 1);
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }
}