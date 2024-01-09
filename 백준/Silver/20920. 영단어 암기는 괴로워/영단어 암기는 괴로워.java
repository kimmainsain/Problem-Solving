import java.util.*;
import java.io.*;

class node {
    int size;
    String alpha;
    int count;

    public node(int size, String alpha, int count) {
        this.size = size;
        this.alpha = alpha;
        this.count = count;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<node> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.count == o2.count) {
                if (o1.size == o2.size) {
                    return o1.alpha.compareTo(o2.alpha);
                }
                return o2.size - o1.size;
            } else {
                return o2.count - o1.count;
            }
        }));
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        for (String key : map.keySet()) {
            pq.add(new node(key.length(), key, map.get(key)));
        }
        while (!pq.isEmpty()) sb.append(pq.poll().alpha).append("\n");
        System.out.println(sb);
    }
}