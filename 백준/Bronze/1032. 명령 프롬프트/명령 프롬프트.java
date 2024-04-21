import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split("");
        for (int i = 0; i < n - 1; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (!Character.toString(str.charAt(j)).equals(s[j])) s[j] = "?";
            }
        }
        for (int i = 0; i < s.length; i++) sb.append(s[i]);
        System.out.println(sb);
    }
}