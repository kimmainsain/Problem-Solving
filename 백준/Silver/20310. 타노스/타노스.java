import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int o = 0;
        int l = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') o++;
            else l++;
        }
        System.out.println("0".repeat(o / 2) + "1".repeat(l / 2));
    }
}