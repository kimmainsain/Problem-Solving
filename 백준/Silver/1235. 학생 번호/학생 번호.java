import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        String str[] = new String[n];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) str[i] = br.readLine();
        for (int i = str[0].length() - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                set.add(str[j].substring(i));
            }
            if (set.size() % n == 0) {
                System.out.println(str[0].length() - i);
                return;
            }
            set.clear();
        }
        System.out.println(str[0].length());
    }
}