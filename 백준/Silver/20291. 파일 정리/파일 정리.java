import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> hm = new TreeMap<>();
        int max = -1;
        for (int i = 0; i < n; i++) {
            String str = br.readLine().split("\\.")[1];
            if (!hm.containsKey(str)) hm.put(str, 1);
            else hm.put(str, hm.get(str) + 1);
        }
        for (String value : hm.keySet()) sb.append(value).append(" ").append(hm.get(value)).append("\n");
        System.out.println(sb);
    }
}