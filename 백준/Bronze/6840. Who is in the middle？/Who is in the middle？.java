import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int i = 0;
        while(i++ < 3) pq.add(Integer.parseInt(br.readLine()));
        pq.poll();
        System.out.println(pq.poll());
    }
}