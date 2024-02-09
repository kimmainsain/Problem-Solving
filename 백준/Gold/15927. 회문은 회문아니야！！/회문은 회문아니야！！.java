import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        char c = str.charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c != str.charAt(i)) break;
            else count++;
        }
        if (count == str.length()) {
            System.out.println(-1);
            return;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                System.out.println(str.length());
                return;
            } else {
                left++;
                right--;
            }
        }
        System.out.println(str.length() - 1);
    }
}