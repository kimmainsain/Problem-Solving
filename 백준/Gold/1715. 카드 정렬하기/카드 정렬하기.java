import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        int top = -1;
        while (!pq.isEmpty()) {
            int v = pq.poll();
            if (top == -1) {
                top = v;
            } else {
                answer += v + top;
                pq.add(v + top);
                top = -1;
            }
        }
        System.out.println(answer);
    }

}