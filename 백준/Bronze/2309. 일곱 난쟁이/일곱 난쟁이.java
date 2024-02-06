import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int arr[] = new int [9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int v = Integer.parseInt(br.readLine());
            sum += v;
            arr[i] = v;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        loop : for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int t = arr[i] + arr[j];
                if (sum - t == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == j || k == i) continue;
                        pq.add(arr[k]);
                    }
                    break loop;
                }
            }
        }
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}