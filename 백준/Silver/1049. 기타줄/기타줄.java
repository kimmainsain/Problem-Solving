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
        PriorityQueue<Integer> six = new PriorityQueue<>();
        PriorityQueue<Integer> one = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            six.add(a);
            one.add(b);
        }
        int ss = six.poll();
        int oo = one.poll();
        int aa = n % 6;
        int answer = 0;
        if (ss < oo * aa) {
            answer += ss;
        } else {
            answer += oo * aa;
        }
        if (ss < oo * 6) {
            answer += ss * (n / 6);
        } else {
            answer += oo * 6 * (n / 6);
        }
        System.out.println(answer);
    }
}