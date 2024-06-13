import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, max;
    static ArrayList<boolean[]> list;
    static boolean visited[];
    static int keep[];

    private static void comb(int depth, int start) {
        if (depth == m - 5) {
            int count = 0;
            for (boolean visited[] : list) {
                int collect = 0;
                int visitedCount = 0;
                for (int i = 0; i < keep.length; i++) {
                    if (visited[keep[i]]) collect++;
                }
                for (int i = 0; i < visited.length; i++) {
                    if (visited[i]) visitedCount++;
                }
                if (collect == visitedCount) count++;
            }
            if (max < count) {
                max = count;
            }
            return;
        }
        for (int i = start; i < 26; i++) {
            if (visited[i]) continue;
            if (i == 'a' - 'a' || i == 'n' - 'a' || i == 't' - 'a' || i == 'i' - 'a' || i == 'c' - 'a') continue;
            keep[depth] = i;
            visited[i] = true;
            comb(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = -2147483648;
        if (m < 5) {
            System.out.println(0);
            return;
        }
        keep = new int[m - 5];
        visited = new boolean[26];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean arr[] = new boolean[26];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c') continue;
                arr[c - 'a'] = true;
            }
            list.add(arr);
        }
        comb(0, 0);
        System.out.println(max);
    }
}