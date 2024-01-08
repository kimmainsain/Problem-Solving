import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
            if (!pq.isEmpty() && a == 0) {
                sb.append(pq.poll()).append("\n");
            } else if (a == 0) {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}