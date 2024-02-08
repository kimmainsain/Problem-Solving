import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        String str2 = br.readLine();
        Queue<String> qu = new ArrayDeque<>();
        qu.add(str2);
        while (!qu.isEmpty()) {
            String now = qu.poll();
            if (now.length() < str.length()) continue;
            if (now.equals(str)) {
                System.out.println(1);
                return;
            }
            if (now.charAt(now.length() - 1) == 'A') {
                String sub = now.substring(0, now.length() - 1);
                qu.add(sub);
            }
            if (now.charAt(0) == 'B') {
                StringBuilder rev = new StringBuilder(now).reverse();
                String subRev = rev.toString().substring(0, now.length() - 1);
                qu.add(subRev);
            }
        }
        System.out.println(0);
    }
}