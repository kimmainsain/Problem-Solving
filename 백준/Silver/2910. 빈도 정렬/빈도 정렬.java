import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return list.indexOf(o1[0]) - list.indexOf(o2[0]);
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (hm.containsKey(v)) hm.put(v, hm.get(v) + 1);
            else hm.put(v, 1);
            list.add(v);
        }
        for (int i : hm.keySet()) pq.add(new int[]{i, hm.get(i)});
        while (!pq.isEmpty()) {
            int now[] = pq.poll();
            for (int i = 0; i < now[1]; i++) sb.append(now[0]).append(" ");
        }
        System.out.println(sb);
    }

}