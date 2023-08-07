import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean map[][] = new boolean[n][26];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
                map[i][c - 'a'] = true;
            }
        }
        int answer = n;
        boolean row[] = new boolean[n];
        int cc[] = new int [n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            String sValue = st.nextToken();
            if ("aeiou".contains(sValue)) continue;
            int check = sValue.charAt(0) - 'a';
            for (int j = 0; j < n; j++) {
                if (value == 1) {
                    if (map[j][check]) {
                        cc[j]++;
                        if (!row[j]) {
                            answer--;
                            row[j] = true;
                        }
                    }
                } else {
                    if (map[j][check]) {
                        if (row[j]) {
                            cc[j]--;
                            if (cc[j] == 0) {
                                row[j] = false;
                                answer++;
                            }
                        }
                    }
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

}