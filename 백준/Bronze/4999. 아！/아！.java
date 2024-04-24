import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String hwan = br.readLine();
        String doc = br.readLine();
        System.out.println(hwan.length() < doc.length() ? "no" : "go");
    }
}