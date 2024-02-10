import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, t, g;

    public static int cal(int value) {
        int arr[] = new int [5];
        int idx = 5;
        int i = 0;
        int len = 10000;
        while (i < 5) {
            arr[i] = value / len;
            value = value % len;
            len = len / 10;
            if (arr[i] != 0) {
                idx = Math.min(idx, i);
            }
            i++;
        }
        arr[idx]--;
        int ret = 0;
        i = 0;
        len = 10000;
        while (i < 5) {
            ret += arr[i] * len;
            len /= 10;
            i++;
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        Queue<int[]> qu = new ArrayDeque<>();
        int limit = 99999;
        boolean visited[] = new boolean[limit + 1];
        qu.add(new int[]{n, 0});
        while (!qu.isEmpty()) {
            int now[] = qu.poll();
            if (now[0] == g) {
                System.out.println(now[1]);
                return;
            }
            if (now[1] == t) continue;
            if (now[0] + 1 <= limit && !visited[now[0] + 1]) {
                qu.add(new int[]{now[0] + 1, now[1] + 1});
                visited[now[0] + 1] = true;
            }
            if (now[0] != 0 && now[0] * 2 <= limit) {
                int next = cal(now[0] * 2);
                if (visited[next]) continue;
                qu.add(new int[]{next, now[1] + 1});
                visited[next] = true;
            }
        }
        System.out.println("ANG");
    }
}