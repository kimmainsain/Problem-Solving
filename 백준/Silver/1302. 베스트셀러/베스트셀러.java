import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> hm = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        int max = -1;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (!hm.containsKey(str)) hm.put(str, 1);
            else hm.put(str, hm.get(str) + 1);
            max = Math.max(max, hm.get(str));
        }
        for (String value : hm.keySet()) if (hm.get(value) == max) pq.add(value);
        System.out.println(pq.poll());
    }
}