import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 1;
        int idx = 0;
        while (true) {
            if (dq.isEmpty()) {
                if (count > n) break;
                dq.add(count++);
                sb.append("+\n");
            } else {
                if (dq.getLast() == arr[idx]) {
                    dq.pollLast();
                    sb.append("-\n");
                    idx++;
                } else {
                    if (count > n) break;
                    dq.add(count++);
                    sb.append("+\n");
                }
            }
        }
        if (dq.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}