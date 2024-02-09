import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static boolean visited[];
    static char answer[];
    static char arr[];

    public static boolean nextPer(int end) {
        int idx = end - 1;
        while (idx > 0 && arr[idx - 1] >= arr[idx]) idx--;
        if (idx == 0) return false;
        for (int i = end - 1; i >= idx; i--) {
            if (arr[idx - 1] < arr[i]) {
                char temp = arr[i];
                arr[i] = arr[idx - 1];
                arr[idx - 1] = temp;
                break;
            }
        }
        Arrays.sort(arr, idx, end);
        return true;
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            visited = new boolean[str.length()];
            answer = new char[str.length()];
            arr = new char[str.length()];
            for (int j = 0; j < str.length(); j++) {
                arr[j] = str.charAt(j);
            }
            Arrays.sort(arr);
            sb.append(arr).append("\n");
            while (nextPer(str.length())) {
                sb.append(arr).append("\n");
            }
        }
        System.out.println(sb);
    }
}