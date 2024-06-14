import java.io.*;
import java.util.*;

class node {
    int y;
    int x;
    int virus;

    public node(int y, int x, int virus) {
        this.y = y;
        this.x = x;
        this.virus = virus;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int dy[] = new int[]{0, 1, 0, -1};
    static int dx[] = new int[]{1, 0, -1, 0};

    static boolean visited[][];
    static int map[][];
    static PriorityQueue<node> pq;
    static Queue<node> qu;

    static int n, k;
    static int s, x, y;

    private static void bfs() {
        while (!qu.isEmpty()) {
            if (s == 0) return;
            int size = qu.size();
            while (size-- > 0) {
                node now = qu.poll();
                for (int i = 0; i < 4; i++) {
                    int nexty = now.y + dy[i];
                    int nextx = now.x + dx[i];
                    if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > n - 1) continue;
                    if (visited[nexty][nextx]) continue;
                    if (map[nexty][nextx] < now.virus && map[nexty][nextx] != 0) continue;
                    visited[nexty][nextx] = true;
                    map[nexty][nextx] = now.virus;
                    qu.add(new node(nexty, nextx, now.virus));
                }
            }
            s--;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        map = new int[n][n];
        pq = new PriorityQueue<>((a, b) -> a.virus - b.virus);
        qu = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) continue;
                visited[i][j] = true;
                pq.add(new node(i, j, map[i][j]));
            }
        }
        while(!pq.isEmpty()) qu.add(pq.poll());
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        bfs();
//        System.out.println(Arrays.deepToString(map));
        System.out.println(map[x - 1][y - 1]);
    }
}