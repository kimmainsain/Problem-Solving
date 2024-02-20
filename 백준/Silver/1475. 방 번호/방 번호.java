import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int arr[] = new int[11];
        for (int i = 0; i < str.length(); i++) {
            int v = str.charAt(i) - '0';
            arr[v]++;
        }
        int t = (arr[6] + arr[9] + 1) / 2;
        arr[6] = arr[9] = t;
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = Math.max(answer, arr[i]);
        }
        System.out.println(answer);
    }
}