import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (i % 2 == 0) { // 짝
                if (left.isEmpty()) {
                    left.add(v);
                } else {
                    if (v <= right.peek()) {
                        left.add(v);
                    } else {
                        left.add(right.poll());
                        right.add(v);
                    }
                }
            } else { // 홀
                if (right.isEmpty()) {
                    if (left.peek() <= v) {
                        right.add(v);
                    } else {
                        right.add(left.poll());
                        left.add(v);
                    }
                } else {
                    int peekL = left.peek(); // 1
                    if (peekL <= v) { // v = 3
                        right.add(v);
                    } else { // v = -3
                        right.add(left.poll());
                        left.add(v);
                    }
                }
            }
            sb.append(left.peek()).append("\n");
        }
        System.out.println(sb);
    }
}