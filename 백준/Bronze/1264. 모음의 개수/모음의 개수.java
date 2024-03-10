import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String vali = "aeiouAEIOU";
        while (true) {
            String str = br.readLine();
            if (str.equals("#")) break;
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (vali.contains(Character.toString(str.charAt(i)))) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}