import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < 3; i++) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }
}