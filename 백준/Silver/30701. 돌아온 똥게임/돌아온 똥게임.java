import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> monster = new PriorityQueue<>();
        PriorityQueue<Integer> weapon = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                monster.add(b);
            } else if (a == 2) {
                weapon.add(b);
            }
        }
        int answer = 0;
        while (true) {
            if (!monster.isEmpty() && d > monster.peek()) {
                d += monster.poll();
                answer++;
            } else {
                if (!weapon.isEmpty()) {
                    d *= weapon.poll();
                    answer++;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}