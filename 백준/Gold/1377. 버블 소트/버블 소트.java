import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            pq.add(new int [] {v, i});
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int now[] = pq.poll();
            if (max < now[1] - i) {
                max = now[1] - i;
            }
        }
        System.out.println(max + 1);
    }
}