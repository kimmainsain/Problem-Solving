import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int alpha[] = new int[26];
        String a[] = br.readLine().split(" ");
        char before = '0';
        boolean flag = false;
        for (int i = 0; i < a.length; i++) alpha[i] = Integer.parseInt(a[i]);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char lowerC = Character.toLowerCase(c);
            if (c == ' ') {
                if (before == ' ') continue;
                n--;
                if (n < 0) flag = true;
            } else {
                if (before == c) continue;
                if (before == ' ' || before == '0') {
                    sb.append(Character.toUpperCase(c));
                    alpha[lowerC - 'a']--;
                }
                alpha[lowerC - 'a']--;
                if (alpha[lowerC - 'a'] < 0) flag = true;
            }
            before = c;
        }
        if (flag) System.out.println("-1");
        else System.out.println(sb);
    }
}