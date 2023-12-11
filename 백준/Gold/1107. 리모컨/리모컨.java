import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class node {
    int count;
    int value;

    public node(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[10];
        if (m > 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) arr[Integer.parseInt(st.nextToken())] = true;
        Set<Integer> set = new HashSet<>();
        Queue<node> qu = new ArrayDeque<>();

        int min = 2147483647;
        for (int i = 0; i < 10; i++) {
            if (arr[i]) continue;
            qu.add(new node(i, 1));
            set.add(i);
            min = Math.min(min, Math.abs(n - i) + 1);
        }
        min = Math.min(min, Math.abs(n - 100));
        while (!qu.isEmpty()) {
            node now = qu.poll();
            if (now.value < 0 || now.value > n) continue;
            for (int i = 0; i < 10; i++) {
                if (arr[i]) continue;
                int next = now.value * 10 + i;
                if (set.contains(next)) continue;
                if (next > 999999) continue;
                if (min > (Math.abs(n - next) + now.count + 1)) {
                    min = Math.abs(n - next) + now.count + 1;
                }
                qu.add(new node(next, now.count + 1));
                set.add(next);
            }
        }
        System.out.println(min);
    }

}