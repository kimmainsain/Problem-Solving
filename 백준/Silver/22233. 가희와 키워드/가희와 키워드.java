import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(br.readLine());
        for (int i = 0; i < m; i++) {
            String str[] = br.readLine().split(",");
            for (int j = 0; j < str.length; j++) {
                if (set.contains(str[j])) set.remove(str[j]);
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
}