import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'a';
            value = value < 0 ? value + 32 + 26 + 1 : value + 1;
            sum += value;
        }
        for (int i = 2; i * i <= sum; i++) {
            if (sum % i == 0) {
                System.out.println("It is not a prime word.");
                return;
            }
        }
        System.out.println("It is a prime word.");
    }
}