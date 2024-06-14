import java.io.*;
import java.util.*;

class shark {
    int y;
    int x;
    int speed;
    int dir;
    int size;

    public shark(int y, int x, int speed, int dir, int size) {
        this.y = y;
        this.x = x;
        this.speed = speed;
        this.dir = dir;
        this.size = size;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, ss;
    static Queue<shark> sharks;

    static int dy[] = new int[]{-1, 1, 0, 0};
    static int dx[] = new int[]{0, 0, 1, -1};

    static int fisherMan;

    private static void fishing(int index) {
        int size = sharks.size();
        shark fishedShark = null;
        int min = 2147483647;
        while (size-- > 0) { // 제일 위에있는놈 찾기
            shark now = sharks.poll();
            if (index == now.x && now.y < min) {
                fishedShark = now;
                min = now.y;
            }
            sharks.add(now);
        }
        if (fishedShark != null) {
            sharks.remove(fishedShark);
            fisherMan += fishedShark.size;
        }
    }

    private static void moveShark() {
        int size = sharks.size();
        shark map[][] = new shark[n + 1][m + 1];
        while (size-- > 0) {
            shark now = sharks.poll();
            int distance = 0;
            if (now.dir == 1 || now.dir == 2) distance = now.speed % ((n - 1) * 2);
            else if (now.dir == 3 || now.dir == 4) distance = now.speed % ((m - 1) * 2);
            for (int i = 0; i < distance; i++) {
                int nexty = dy[now.dir - 1] + now.y;
                int nextx = dx[now.dir - 1] + now.x;
                if (nexty < 1 || nexty > n || nextx < 1 || nextx > m) {
                    now.y -= dy[now.dir - 1];
                    now.x -= dx[now.dir - 1];
                    if (now.dir == 1) now.dir = 2;
                    else if (now.dir == 2) now.dir = 1;
                    else if (now.dir == 3) now.dir = 4;
                    else if (now.dir == 4) now.dir = 3;
                    continue;
                }
                now.y = nexty;
                now.x = nextx;
            }

            if (map[now.y][now.x] == null || map[now.y][now.x].size < now.size) {
                map[now.y][now.x] = new shark(now.y, now.x, now.speed, now.dir, now.size);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == null) continue;
                sharks.add(map[i][j]);
            }
        }

//        size = sharks.size();
//        while (size-- > 0) {
//            shark now = sharks.poll();
//            System.out.println("y : " + now.y + " x : " + now.x + " dir : " + now.dir + " size : " + now.size);
//            sharks.add(now);
//        }
//        System.out.println("----");
    }

    public static void main(String[] args) throws Exception {
        input();
        for (int i = 1; i < m + 1; i++) {
            fishing(i);
            moveShark();
        }
        System.out.println(fisherMan);
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ss = Integer.parseInt(st.nextToken());
        sharks = new ArrayDeque<>();
        fisherMan = 0;
        for (int i = 0; i < ss; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            sharks.add(new shark(y, x, speed, dir, size));
        }
    }
}