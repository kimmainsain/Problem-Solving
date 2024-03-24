import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(",");
            sb.append(Integer.parseInt(str[0]) + Integer.parseInt(str[1])).append("\n");
        }
        System.out.println(sb);
    }
}