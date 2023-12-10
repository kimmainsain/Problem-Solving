import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Map<String, Integer> hm = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (hm.containsKey(b)) {
                    hm.put(b, hm.get(b) + 1);
                } else {
                    hm.put(b, 1);
                }
            }
            int answer = 1;
            for (String key : hm.keySet()) {
                answer *= (hm.get(key) + 1);
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }

}