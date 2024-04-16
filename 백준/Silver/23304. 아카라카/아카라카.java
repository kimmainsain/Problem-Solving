import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        while (str.length() > 1) {
            sb = new StringBuilder();
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    System.out.println("IPSELENTI");
                    return;
                }
                sb.append(str.charAt(left));
                left++;
                right--;
            }
            if (sb.toString().equals(sb.reverse().toString())) {
                str = sb.toString();
            } else {
                System.out.println("IPSELENTI");
                return;
            }
        }
        System.out.println("AKARAKA");
    }
}