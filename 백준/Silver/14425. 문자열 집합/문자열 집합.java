import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        int c = 0;
        for (int i = 0; i < n; i++) set.add(br.readLine());
        for (int i = 0; i < m; i++) if (set.contains(br.readLine())) c++;
        System.out.println(c);
    }
}