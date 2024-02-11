import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        int nexty = (q + t) % (h * 2);
        int nextx = (p + t) % (w * 2);
        if (nexty > h) nexty = h * 2 - nexty;
        if (nextx > w) nextx = w * 2 - nextx;
        System.out.println(nextx + " " + nexty);
    }
}