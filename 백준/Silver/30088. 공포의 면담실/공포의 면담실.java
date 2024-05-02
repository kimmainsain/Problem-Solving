import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        int arr[] = new int [t + 1];
        for (int tc = 1; tc < t + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int i = 0; i < n; i++) sum += Integer.parseInt(st.nextToken());
            arr[tc] = sum;
        }
        int answer = 0;
        Arrays.sort(arr);
        for (int i = 1; i < t + 1; i++) {
            arr[i] = arr[i] + arr[i - 1];
            answer += arr[i];
        }
        System.out.println(answer);
    }

}