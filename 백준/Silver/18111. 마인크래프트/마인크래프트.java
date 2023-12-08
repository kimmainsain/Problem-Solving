import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, b, min, max;
    static int map[][];
    static TreeMap<Integer, Integer> tm;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        min = 2147483647;
        max = -2147483648;
        tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                min = Math.min(value, min);
                max = Math.max(value, max);
            }
        }
        cal();
        System.out.println(tm.firstKey() + " " + tm.get(tm.firstKey()));
    }

    private static void cal() {
        for (int k = min; k <= max; k++) {
            int time = 0;
            int block = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] < k) {
                        int v = k - map[i][j];
                        block -= v;
                        time += v;
                    } else if (map[i][j] > k) {
                        int v = map[i][j] - k;
                        block += v;
                        time += 2 * v;
                    }
                }
            }
            if (block >= 0) {
                if (tm.containsKey(time)) {
                    tm.put(time, Math.max(k, tm.get(time)));
                } else {
                    tm.put(time, k);
                }
            }
        }
    }
}