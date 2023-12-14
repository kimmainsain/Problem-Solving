import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int [n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = 2147483647;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, arr[i - j * j]);
            }
            arr[i] = min + 1;
        }
        System.out.println(arr[n]);
    }
}