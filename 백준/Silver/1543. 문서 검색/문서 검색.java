import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        String alpha = br.readLine();
        String answer = str.replaceAll(alpha, "1");
        int c = 0;
        for (int i = 0; i < answer.length(); i++) if (answer.charAt(i) == '1') c++;
        System.out.println(c);
    }
}