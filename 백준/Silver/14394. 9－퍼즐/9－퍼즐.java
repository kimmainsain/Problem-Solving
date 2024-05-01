import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String color = "RGBY";
        int c[] = new int[4];
        String before = br.readLine();
        String after = br.readLine();
        for (int i = 0; i < before.length(); i++) {
            int b = color.indexOf(Character.toString(before.charAt(i)));
            if (b == -1) continue;
            c[b]++;
        }
        for (int i = 0; i < after.length();i++) {
            int a = color.indexOf(Character.toString(after.charAt(i)));
            if (a == -1) continue;
            c[a]--;
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (c[i] > 0) answer += c[i];
        }
        System.out.println(answer);
    }

}