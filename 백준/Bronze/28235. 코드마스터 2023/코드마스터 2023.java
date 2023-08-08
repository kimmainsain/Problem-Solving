import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		String SONGDO = "SONGDO";
		String CODE = "CODE";
		String YEAR = "2023";
		String ALGORITHM = "ALGORITHM";
		if (str.equals(SONGDO)) {
			System.out.println("HIGHSCHOOL");
		} else if (str.equals(CODE)) {
			System.out.println("MASTER");
		} else if (str.equals(YEAR)) {
			System.out.println("0611");
		} else if (str.equals(ALGORITHM)) {
			System.out.println("CONTEST");
		}
	}
}