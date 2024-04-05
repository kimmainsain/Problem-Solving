import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int answer = 0;
        for (int i = 0; i < n; i++) pq.add(Integer.parseInt(br.readLine()));
        int i = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            int v = pq.poll();
            if (i == 2) {
                answer += sum;
                i = 0;
                continue;
            }
            answer += v;
            i++;
        }
        System.out.println(answer);
    }
}