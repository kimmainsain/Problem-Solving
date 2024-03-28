import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{b, a});
        }
        Collections.sort(list, ((o1, o2) -> o1[1] - o2[1]));
        int answer = 0;
        int y = -1;
        int x = -1;
        int max = -1;
        int xx = -1;
        for (int i = 0; i < list.size(); i++) {
            int now[] = list.get(i);
            if (i == 0) {
                y = now[0];
                x = now[1];
            } else if (y <= now[0]) {
                answer += (now[1] - x) * y;
                y = now[0];
                x = now[1];
                xx = i;
            }
            max = Math.max(max, now[0]);
        }
        y = x = 1001;
        if (xx != -1) {
            for (int i = list.size() - 1; i >= xx; i--) {
                int now[] = list.get(i);
                if (i == list.size() - 1) {
                    y = now[0];
                    x = now[1];
                } else if (y <= now[0]) {
                    answer += (x - now[1]) * y;
                    y = now[0];
                    x = now[1];
                }
            }
        }
        answer += max;
        System.out.println(answer);
    }
}