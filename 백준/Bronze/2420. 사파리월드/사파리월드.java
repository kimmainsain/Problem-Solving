import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        System.out.println(Math.abs(((long)Integer.parseInt(st.nextToken()) - (long)Integer.parseInt(st.nextToken()))));
    }
}
