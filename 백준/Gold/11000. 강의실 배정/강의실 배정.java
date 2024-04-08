import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> room = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            room.add(new int[]{a, b});
        }
        int answer = 0;
        while (!room.isEmpty()) {
            int now[] = room.poll();
            if (pq.isEmpty() || now[0] < pq.peek()) {
                pq.add(now[1]);
                answer++;
                continue;
            }
            pq.poll();
            pq.add(now[1]);
        }
        System.out.println(pq.size());
    }
}