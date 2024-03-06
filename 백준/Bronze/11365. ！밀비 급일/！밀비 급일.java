import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        while (true) {
            String str = br.readLine();
            if (str.equals("END")) {
                break;
            }
            StringBuilder builder = new StringBuilder(str).reverse();
            sb.append(builder.toString()).append("\n");
        }
        System.out.println(sb);
    }
}