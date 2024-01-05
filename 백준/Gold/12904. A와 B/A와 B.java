import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        ArrayDeque<ArrayDeque<Character>> qu = new ArrayDeque<>();
        String a = br.readLine();
        String b = br.readLine();
        ArrayDeque<Character> tt = new ArrayDeque<>();
        for (int i = 0; i < b.length(); i++) {
            tt.add(b.charAt(i));
        }
        qu.add(tt);
        loop:
        while (!qu.isEmpty()) {
            ArrayDeque<Character> v = qu.poll();
            if (v.size() == a.length()) {
                int ii = 0;
                while (!v.isEmpty()) {
                    if (a.charAt(ii++) != v.poll()) continue loop;
                }
                System.out.println(1);
                return;
            } else {
                if (v.getLast() == 'A') {
                    v.pollLast();
                    qu.add(v);
                } else {
                    ArrayDeque<Character> rv = new ArrayDeque<>();
                    v.pollLast();
                    int ss = v.size();
                    while (ss-- > 0) {
                        rv.addFirst(v.poll());
                    }
                    qu.add(rv);
                }
            }
        }
        System.out.println(0);
    }
}