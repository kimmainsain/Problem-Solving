import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static int n, m;
    static int arr[];

    private static void solve() {
        int left = 1;
        int right = arr[n - 1];
//        System.out.println(Arrays.toString(arr));
        while (left < right) {
            int mid = (left + right + 1) / 2;
            boolean flag = solve2(mid);
//            System.out.println("left : " + left + " right : " + right + " mid : " + mid);
            if (!flag) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        System.out.println(left);
    }


    private static boolean solve2(int mid) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (dq.isEmpty()) dq.add(arr[i]);
            else {
                if (arr[i] - dq.getLast() >= mid) {
                    dq.add(arr[i]);
                    count++;
                }
            }
        }
        dq.clear();
//        System.out.println(count);
        if (count < m) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
    }
}