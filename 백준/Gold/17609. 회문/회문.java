import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    private static int find(int left, int right, String str) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                if (find2(left + 1, right, str)) {
                    return 1;
                }
                if (find2(left, right - 1, str)) {
                    return 1;
                }
                return 2;
            }
            left++;
            right--;
        }
        return 0;
    }

    private static boolean find2(int left, int right, String str) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            sb.append(find(0, str.length() - 1, str)).append("\n");
        }
        System.out.println(sb);
    }
}