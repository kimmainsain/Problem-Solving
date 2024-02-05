import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            pq.add(v);
        }
        int max = Integer.MIN_VALUE;
        int idx = 1;
        while (!pq.isEmpty()) {
            int now = pq.poll();
            int ss = now * idx++;
            max = Math.max(ss, max);
        }
        System.out.println(max);
    }
}