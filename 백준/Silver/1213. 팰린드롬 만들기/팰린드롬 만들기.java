import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int alpha[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char v = str.charAt(i);
            alpha[v - 65]++;
        }
        ArrayDeque<Character> front = new ArrayDeque<>();
        ArrayDeque<Character> back = new ArrayDeque<>();
        boolean hol = false;
        int keep = -1;
        for (int i = 0; i < 26; i++) {
            if (hol && alpha[i] % 2 == 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
            if (alpha[i] % 2 == 1) {
                hol = true;
                keep = i;
            }
            for (int j = 0; j < alpha[i] / 2; j++) {
                front.add((char) (i + 65));
                back.addFirst((char) (i + 65));
            }
        }
        if (keep != -1) front.add((char) (keep + 65));
        while (!front.isEmpty()) {
            sb.append(front.poll());
        }
        while (!back.isEmpty()) {
            sb.append(back.poll());
        }
        System.out.println(sb);
    }

}