import java.util.*;
import java.io.*;

class node {
    int count;
    String str;
    public node (int count, String str) {
        this.count = count;
        this.str = str;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String arr[] = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < m; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (map.containsKey(arr[j].charAt(i))) {
                    map.put(arr[j].charAt(i), map.get(arr[j].charAt(i)) + 1);
                } else {
                    map.put(arr[j].charAt(i), 1);
                }
            }
            int max = -1;
            char c = '\0';
            for (Character key : map.keySet()) {
                int value = map.get(key);
                if (max < value) {
                    max = value;
                    c = key;
                } else if (max == value) {
                    if (key - 48 < c - 48) {
                        c = key;
                    }
                }
            }
            sb.append(c);
        }
        String answer = sb.toString();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (answer.charAt(i) != arr[j].charAt(i)) ans++;
            }
        }
        sb.append("\n").append(ans);
        System.out.println(sb);
    }
}