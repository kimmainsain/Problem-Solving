import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];
        int alpha[] = new int [26];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < arr[j].length(); k++) {
                    int c = arr[j].charAt(k) - 65;
                    if (c == i) {
                        int v = (int)Math.pow(10, arr[j].length() - (k + 1));
                        if (v == 0) v = 1;
                        alpha[i] += v;
                    }
                }
            }
        }
        Arrays.sort(alpha);
        int answer = 0;
        for (int i = 25, nb = 9; nb >= 0; i--, nb--) {
            answer += alpha[i] * nb;
        }
        System.out.println(answer);
    }

}