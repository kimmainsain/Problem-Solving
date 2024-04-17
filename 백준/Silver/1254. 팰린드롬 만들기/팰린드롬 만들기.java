import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        loop:
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, str.length());
            int left = 0;
            int right = temp.length() - 1;
            while (left < right) {
                if (temp.charAt(left) != temp.charAt(right)) continue loop;
                left++;
                right--;
            }
            System.out.println(str.length() * 2 - temp.length());
            return;
        }
    }
}