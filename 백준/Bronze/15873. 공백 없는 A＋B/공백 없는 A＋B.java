import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        if (n < 100) System.out.println(n / 10 + n % 10);
        else if (n % 10 == 0) System.out.println(n / 100 + 10);
        else System.out.println(n % 100 + 10);
    }
}