import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        Arrays.sort(arr);
        int v = -1001;
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (v == -1001) {
                v = arr[i];
                if (v < 0) break;
                if (i == 0) answer += v;
            } else {
                if (v < 0) break;
                if (v + arr[i] < v * arr[i]) {
                    answer += v * arr[i];
                    v = -1001;
                } else {
                    answer += v;
                    v = arr[i];
                    if (v < 0) break;
                    if (i == 0) answer += v;
                }
            }
        }
        v = 1001;
        for (int i = 0; i < n; i++) {
            if (v == 1001) {
                v = arr[i];
                if (v > 0) break;
                if (i == n - 1) answer += v;
            } else {
                if (v > 0) break;
                if (v + arr[i] < v * arr[i]) {
                    answer += v * arr[i];
                    v = 1001;
                } else {
                    answer += v;
                    v = arr[i];
                    if (v > 0) break;
                    if (i == n - 1) answer += v;
                }
            }
        }
        System.out.println(answer);
    }

}