import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String str[] = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<String, Integer> tm = new TreeMap<>();
        for (int i = n; i < m + 1; i++) {
            String t = Integer.toString(i);
            String push = "";
            for (int j = 0; j < t.length(); j++) {
                push += str[t.charAt(j) - '0'];
            }
            tm.put(push, i);
        }
        int i = 0;
        for (String s : tm.keySet()) {
            sb.append(tm.get(s)).append(" ");
            i++;
            if (i == 10) {
                sb.append("\n");
                i = 0;
            }
        }
        System.out.println(sb);
    }
}