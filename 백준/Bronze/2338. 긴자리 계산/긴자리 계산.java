import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BigInteger n = new BigInteger(br.readLine());
        BigInteger m = new BigInteger(br.readLine());
        sb.append(n.add(m)).append("\n").append(n.subtract(m)).append("\n").append(n.multiply(m));
        System.out.println(sb);
    }
}