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
            String str[] = br.readLine().split(" ");
            if (str[1].equals("enter")) {
                set.add(str[0]);
                continue;
            }
            set.remove(str[0]);
        }
        for (String str : set) sb.append(str).append("\n");
        System.out.println(sb);
    }
}