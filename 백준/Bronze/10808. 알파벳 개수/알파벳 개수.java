import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        int arr[] = new int[26];
        for (int i = 0; i < str.length(); i++) arr[str.charAt(i) - 'a']++;
        for (int i = 0; i < arr.length; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb);
    }
}