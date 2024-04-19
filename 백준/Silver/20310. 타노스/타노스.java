import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int o = 0;
        int l = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') o++;
            else l++;
            sb.append(str.charAt(i));
        }
        o /= 2;
        l /= 2;
        for (int i = 0; i < str.length(); i++) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '2');
                l--;
            }
            if (l == 0) break;
        }
        for (int i = str.length() - 1; i > -1; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i,'3');
                o--;
            }
            if (o == 0) break;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (sb.charAt(i) == '0' || sb.charAt(i) == '1') answer.append(sb.charAt(i));
        }
        System.out.println(answer);
    }
}