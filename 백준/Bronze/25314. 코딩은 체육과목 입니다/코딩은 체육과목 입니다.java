import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n / 4; i++) sb.append("long ");
        sb.append("int");
        System.out.println(sb);
    }
}