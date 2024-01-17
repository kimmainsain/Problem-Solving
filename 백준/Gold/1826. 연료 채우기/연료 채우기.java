import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pqMeter = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        ArrayList<int[]> station = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pqMeter.add(new int[]{a, b});
        }
        while (!pqMeter.isEmpty()) {
            station.add(pqMeter.poll());
        }
        st = new StringTokenizer(br.readLine());
        int end = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
        for (int i = 0; i < n; i++) {
            int now[] = station.get(i);
            if (start >= end) break;
            if (now[0] > start) { // 값 업데이트 필요함
                while (!pq.isEmpty() && now[0] > start) {
                    int greedy[] = pq.poll();
                    start += greedy[1];
                    answer++;
                }
                if (now[0] > start) break;
            }
            pq.add(now);
        }
        while (!pq.isEmpty() && start < end) {
            int now[] = pq.poll();
            start += now[1];
            answer++;
        }
        if (start >= end) {
            System.out.println(answer);
        } else {
            System.out.println("-1");
        }
    }
}