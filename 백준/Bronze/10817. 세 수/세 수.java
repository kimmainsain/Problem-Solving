import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int input[] = new int [3];
        for (int i = 0; i < 3; i++) input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        System.out.println(input[1]);
    }
}