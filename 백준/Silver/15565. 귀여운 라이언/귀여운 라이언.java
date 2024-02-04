import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v == 1) list.add(i);
        }
        if (list.size() < m) {
            System.out.println(-1);
            return;
        }
        int min = 2147483647;
        for (int i = 0; i < list.size() - m + 1; i++) {
            int sum = list.get(i + m - 1) - list.get(i) + 1;
            min = Math.min(sum, min);
        }
        System.out.println(min);
    }
}