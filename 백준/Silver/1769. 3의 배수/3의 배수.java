import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int c = 0;
        int answer = -1;
        while (str.length() > 1) {
            answer = 0;
            for (int i = 0; i < str.length(); i++) {
                answer += str.charAt(i) - 48;
            }
            str = Integer.toString(answer);
            c++;
        }
        sb.append(c).append("\n");
        if (Integer.parseInt(str) % 3 == 0) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }
        System.out.println(sb);

    }
}