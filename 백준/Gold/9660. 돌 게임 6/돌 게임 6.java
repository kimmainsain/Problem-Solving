import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(br.readLine());
        if (n % 7 == 0 || n % 7 == 2) System.out.println("CY");
        else System.out.println("SK");
    }
}