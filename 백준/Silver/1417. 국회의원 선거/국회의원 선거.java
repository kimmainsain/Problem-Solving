import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int dasom = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        while (!pq.isEmpty()) {
            int value = pq.poll();
            if (value < dasom) break;
            dasom++;
            value--;
            answer++;
            pq.add(value);
        }
        System.out.println(answer);
    }
}