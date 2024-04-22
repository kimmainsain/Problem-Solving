import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        Set<String> set = new HashSet<>();
        int arr[] = new int[]{13, 13, 13, 13};
        String vali = "PKHT";
        for (int i = 0; i < str.length(); i += 3) {
            String s = str.substring(i, i + 3);
            arr[vali.indexOf(Character.toString(s.charAt(0)))]--;
            set.add(s);
        }
        if (set.size() != str.length() / 3) {
            System.out.println("GRESKA");
        } else {
            for (int i = 0; i < 4; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}