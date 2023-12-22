import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int zero = 0;
        int one = 0;
        for (int i = 0; i < str.length(); i++) {
            int v = str.charAt(i) - 48;
            if (stack.isEmpty()) {
                if (v == 0) {
                    zero++;
                } else {
                    one++;
                }
                stack.add(v);
            } else {
                if (stack.peek() == v) {
                } else {
                    if (v == 0) {
                        zero++;
                    } else if (v == 1) {
                        one++;
                    }
                    stack.add(v);
                }
            }
        }
        System.out.println(Math.min(zero, one));
    }
}