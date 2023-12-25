import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br.readLine();
        String str = br.readLine();
        int b = 0;
        int s = 0;
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'S') {
                s++;
            } else if (c == 'B') {
                b++;
            } else if (c == 'A') {
                a++;
            }
        }
        if (b == s && s == a) {
            System.out.println("SCU");
            return;
        }

        int max = Math.max(a, Math.max(b, s));
        if (max == b) System.out.print("B");
        if (max == s) System.out.print("S");
        if (max == a) System.out.print("A");
    }
}