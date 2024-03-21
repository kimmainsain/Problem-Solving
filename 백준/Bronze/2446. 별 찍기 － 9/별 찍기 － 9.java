import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) sb.append(" ");
            for (int j = 0; j < (n - i - 1) * 2 + 1; j++) sb.append("*");
            sb.append("\n");
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) sb.append(" ");
            for (int j = 0; j < i * 2 + 1; j++) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}