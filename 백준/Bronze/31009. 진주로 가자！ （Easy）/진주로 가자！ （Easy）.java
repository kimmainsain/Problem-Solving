import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int v = Integer.parseInt(st.nextToken());
            arr[i] = v;
            if (str.equals("jinju")) {
                sb.append(v).append("\n");
                j = v;
            }
        }
        int c = 0;
        for (int i = 0 ; i < n; i++) {
            if (arr[i] > j) c++;
        }
        sb.append(c);
        System.out.println(sb);
    }
}