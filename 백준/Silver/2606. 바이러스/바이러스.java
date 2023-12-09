import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> list[] = new ArrayList[n + 1];
        boolean visited[] = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (list[a] == null) list[a] = new ArrayList<>();
            if (list[b] == null) list[b] = new ArrayList<>();
            list[a].add(b);
            list[b].add(a);
        }
        int answer = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        visited[1] = true;
        while (!dq.isEmpty()) {
            int v = dq.poll();
            if (list[v] == null) continue;
            for (int i = 0; i < list[v].size(); i++) {
                int vv = list[v].get(i);
                if (visited[vv]) continue;
                visited[vv] = true;
                dq.add(vv);
                answer++;
            }
        }
        System.out.println(answer);
    }

}