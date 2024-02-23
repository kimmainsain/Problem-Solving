import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = "BABAABABAABABAABABAA";
        long n = Long.parseLong(br.readLine());
        char c = str.charAt((int)(n % 20));
        if (c == 'A') System.out.println("SK");
        else System.out.println("CY");
    }
}