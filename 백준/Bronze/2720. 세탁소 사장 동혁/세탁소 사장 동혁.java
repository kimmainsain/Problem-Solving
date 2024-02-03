import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        int a = 25;
        int b = 10;
        int c = 5;
        int d = 1;
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            sb.append(v / a).append(" ").append(v % a / b ).append(" ").append(v % a % b / c).append(" ").append(v % a % b % c / 1).append("\n");
        }
        System.out.println(sb);
    }
}