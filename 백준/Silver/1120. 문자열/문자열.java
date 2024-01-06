import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        String alpha = st.nextToken();
        String beta = st.nextToken();
        int min = 2147483647;
        int size = beta.length() - alpha.length();
        for (int i = 0; i <= size; i++) {
            int count = 0;
            for (int j = 0; j < alpha.length(); j++) {
                char alphaC = alpha.charAt(j);
                char betaC = beta.charAt(j + i);
                if (alphaC != betaC) count++;
            }
            min = Math.min(min, count);
        }
        System.out.println(min);
    }
}