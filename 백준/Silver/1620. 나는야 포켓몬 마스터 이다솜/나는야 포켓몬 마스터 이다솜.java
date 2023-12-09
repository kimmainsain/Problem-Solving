import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        Map<Integer, String> idxString = new HashMap<>();
        Map<String, Integer> stringIdx = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            idxString.put(i, str);
            stringIdx.put(str, i);
        }
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            try {
                int t = Integer.parseInt(str);
                sb.append(idxString.get(t)).append("\n");
                continue;
            } catch (Exception e) {
            }
            sb.append(stringIdx.get(str)).append("\n");
        }
        System.out.println(sb);
    }
}