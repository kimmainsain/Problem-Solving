import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (i % 10 == 9) sb.append("\n");
        }
        System.out.println(sb);
    }
}