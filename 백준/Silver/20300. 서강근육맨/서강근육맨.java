import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long value = Long.parseLong(st.nextToken());
            list.add(value);
        }
        Collections.sort(list);
        long max = -1;
        int left = 0;
        int right = n - 1;
        if (n % 2 == 1) {
            max = list.get(right);
            right--;
        }
        while (left < right) {
            long value = list.get(left) + list.get(right);
            max = Math.max(value, max);
            left++;
            right--;
        }
        System.out.println(max);
    }
}