import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long [100];
        long nothing[] = new long [100];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        nothing[1] = 0;
        nothing[2] = 0;
        nothing[3] = 1;
        for (int i = 4; i < 100; i++) {
            arr[i] = arr[i-1] + nothing[i - 1];
            nothing[i] = arr[i - 1];
        }
        System.out.println(arr[n]);
    }
}