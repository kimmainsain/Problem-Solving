import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int alpha[] = new int[26];
        Set<Character> set = new HashSet<>();
        int answer = 0;
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            alpha[c - 'a']++;
            set.add(c);
            if (set.size() > n) {
                while (set.size() > n) {
                    char cc = str.charAt(left);
                    if (--alpha[cc - 'a'] == 0) {
                        set.remove(cc);
                    }
                    left++;
                }
            } else {
                answer = Math.max(answer, i - left + 1);
            }
        }
        System.out.println(answer);
    }
}