import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            if (str2.equals("enter")) {
                set.add(str1);
                continue;
            }
            set.remove(str1);
        }
        for (String str : set) sb.append(str).append("\n");
        System.out.println(sb);
    }
}