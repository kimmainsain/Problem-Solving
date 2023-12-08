import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int del = (int)Math.round((double)(n * 15) / 100);
        int sum = 0;
        for (int i = del; i < list.size() - del; i++) {
            sum += list.get(i);
        }
        System.out.println(Math.round((double)sum / (list.size() - 2 * del)));
    }
}