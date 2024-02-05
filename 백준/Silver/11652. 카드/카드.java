import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        HashMap<Long, Integer> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long v = Long.parseLong(br.readLine());
            if (hm.containsKey(v)) {
                hm.put(v, hm.get(v) + 1);
            } else {
                hm.put(v, 1);
            }
        }
        int ans = -1;
        long min = (long)Math.pow(2, 63);
        for (Long v : hm.keySet()) {
            if (hm.get(v) > ans) {
                ans = hm.get(v);
                min = v;
            } else if (hm.get(v) == ans) {
                min = Math.min(min, v);
            }
        }
        System.out.println(min);
    }
}