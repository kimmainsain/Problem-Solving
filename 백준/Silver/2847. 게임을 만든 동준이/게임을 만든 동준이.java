import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n - 2; i > -1; i--) {
            if (arr[i] < arr[i + 1]) continue;
            answer += arr[i] - arr[i + 1] + 1;
            arr[i] = arr[i + 1] - 1;
        }
        System.out.println(answer);
    }
}