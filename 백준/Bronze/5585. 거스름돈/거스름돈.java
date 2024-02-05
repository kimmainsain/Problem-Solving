import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        answer += (1000 - n) / 500 + ((1000 - n) % 500) / 100 + (((1000 - n) % 500) % 100) / 50 + ((((1000 - n) % 500) % 100) % 50) / 10 +
                (((((1000 - n) % 500) % 100) % 50) % 10) / 5 + ((((((1000 - n) % 500) % 100) % 50) % 10) % 5) / 1;
        System.out.println(answer);
    }
}