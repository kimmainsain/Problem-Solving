import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static boolean vali(int a, int b) {
        if (a > 17 || b >= 80) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            String str = br.readLine();
            if (str.equals("# 0 0")) break;
            String temp[] = str.split(" ");
            String name = temp[0];
            int a = Integer.parseInt(temp[1]);
            int b = Integer.parseInt(temp[2]);
            if (!vali(a, b)) sb.append(name).append(" ").append("Junior").append("\n");
            else sb.append(name).append(" ").append("Senior").append("\n");
        }
        System.out.println(sb);
    }
}