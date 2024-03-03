import java.util.*;
import java.io.*;

class node {
    int y;
    int value;

    public node(int y, int value) {
        this.y = y;
        this.value = value;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<int[]> list[];
    static PriorityQueue<node> pq;
    static boolean visited[];
    static int arr[];
    static int n, m;
    static int check[];

    public static void dijk() {
        pq.add(new node(0, 0));
        while (!pq.isEmpty()) {
            node now = pq.poll();
            if (visited[now.y]) continue;
            visited[now.y] = true;
            for (int i = 0; i < list[now.y].size(); i++) {
                int nexty = list[now.y].get(i)[0];
                int nextvalue = list[now.y].get(i)[1];
                if (visited[nexty]) continue;
                if (arr[nexty] > nextvalue + now.value) {
                    arr[nexty] = nextvalue + now.value;
                    check[nexty] = now.y;
                    pq.add(new node(nexty, arr[nexty]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visited = new boolean[m];
            list = new ArrayList[m];
            check = new int[m];
            arr = new int[m];
            pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
            for (int j = 0; j < m; j++) {
                list[j] = new ArrayList<>();
                arr[j] = 999999999;
            }
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list[a].add(new int[]{b, c});
                list[b].add(new int[]{a, c});
            }
            dijk();
            sb.append("Case #").append(i + 1).append(": ");
            if (arr[m - 1] == 999999999) {
                sb.append(-1);
            } else {
                ArrayDeque<Integer> dq = new ArrayDeque<>();
                int end = m - 1;
                while (end != 0) {
                    dq.addFirst(end);
                    end = check[end];
                }
                sb.append(0 + " ");
                while (!dq.isEmpty()) {
                    sb.append(dq.poll()).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}