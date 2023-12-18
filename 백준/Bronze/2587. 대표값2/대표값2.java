import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int sum = 0;
        int arr[] = new int [5];
        for (int i = 0; i < 5; i++) {

            arr[i] = Integer.parseInt(br.readLine());
            sum+= arr[i];
        }
        Arrays.sort(arr);
        sb.append(sum / 5).append("\n").append(arr[2]);
        System.out.println(sb);
    }
}