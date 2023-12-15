import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 65 + 26) {
                sb.append((char)(c + 32));
            } else {
                sb.append((char)(c - 32));
            }
        }
        System.out.println(sb);

    }
}
