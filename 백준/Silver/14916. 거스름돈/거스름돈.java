import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int v = n % 5;
        if (n == 1 || n == 3) {
            System.out.println("-1");
            return;
        }
        if (v == 0) {
            System.out.println(n / 5);
        } else if (v == 1) {
            System.out.println(n / 5 - 1 + 3);
        } else if (v == 2) {
            System.out.println(n / 5 + 1);
        } else if (v == 3) {
            System.out.println(n / 5 - 1 + 4);
        } else if (v == 4) {
            System.out.println(n / 5 + 2);
        }
    }

}