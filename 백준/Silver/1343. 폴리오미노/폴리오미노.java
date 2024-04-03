import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine().replaceAll("XX", "BB");
        String str2 = str.replaceAll("BBBB", "AAAA");
        System.out.println(str2.contains("X") ? -1 : str2);
    }
}