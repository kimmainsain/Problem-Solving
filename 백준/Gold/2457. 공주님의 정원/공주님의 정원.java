import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int s = 301;
        int e = 1201;
        PriorityQueue<int[]> flowers = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int start = a * 100 + b;
            int end = c * 100 + d;
            flowers.add(new int[]{start, end});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int count = 0;
        while (s < e) {
            while (!flowers.isEmpty() && s >= flowers.peek()[0]) {
                pq.add(flowers.poll());
            }
            if (pq.isEmpty()) break;
            int greed[] = pq.poll();
            s = greed[1];
            count++;
        }
        if (s < e) System.out.println("0");
        else System.out.println(count);
    }
}