import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int start = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Character> qu = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (qu.isEmpty()) {
                if (c == 'I') {
                    qu.add(c);
                }
            } else {
                if (qu.getLast() != c) {
                    qu.add(c);
                } else {
                    if (qu.getLast() == 'I') {
                        list.add(qu.size());
                        qu.clear();
                        qu.add(c);
                    } else {
                        list.add(qu.size() - 1);
                        qu.clear();
                    }
                }
            }
        }
        if (!qu.isEmpty()) list.add(qu.size());
        int count = 0;
        n =  1 + 2 * n;
        for (int i = 0; i < list.size(); i++) {
            int v = list.get(i);
            if (v - n < 0) continue;
            count += (v - n) / 2 + 1;
        }
        System.out.println(count);
    }
}