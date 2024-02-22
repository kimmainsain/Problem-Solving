import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer> list[];
    static Queue<Integer> qu;
    static boolean visited[];
    static int m;
    static int answer;

    public static void solve(int starta, int startb) {
        qu.add(starta);
        qu.add(startb);
        loop : while (!qu.isEmpty()) {
            int size = qu.size();
            while (size-- > 0) {
                int now = qu.poll();
                if (visited[now]) {
                    sb.append(now).append("\n");
                    break loop;
                }
                visited[now] = true;
                for (int i = 0; i < list[now].size(); i++) {
                    int next = list[now].get(i);
                    qu.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            list = new ArrayList[m + 1];
            visited = new boolean[m + 1];
            answer = 0;
            qu = new ArrayDeque<>();
            for (int j = 0; j < m + 1; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < m - 1; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[b].add(a);
            }
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            solve(a, b);
        }
        System.out.println(sb);
    }
}