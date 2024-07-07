import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static char map[][] = new char[3][3];

	public static void rotation(char rotate[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				rotate[i][j] = map[i][j];
			}
		}
	}

	public static void minus(char rotate[][]) {
		for (int i = 0; i < 3; i++) {
			map[2][i] = rotate[i][0];
			map[1][i] = rotate[i][1];
			map[0][i] = rotate[i][2];
		}
		rotation(rotate);
	}

	public static void plus(char rotate[][]) {
		for (int j = 0; j < 3; j++) {
			map[0][j] = rotate[2 - j][0];
			map[1][j] = rotate[2 - j][1];
			map[2][j] = rotate[2 - j][2];
		}
		rotation(rotate);
	}

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < n; tc++) { // 4

			char ucube[][] = new char[][] { { 'w', 'w', 'w' }, { 'w', 'w', 'w' }, { 'w', 'w', 'w' } };
			char dcube[][] = new char[][] { { 'y', 'y', 'y' }, { 'y', 'y', 'y' }, { 'y', 'y', 'y' } };
			char rcube[][] = new char[][] { { 'b', 'b', 'b' }, { 'b', 'b', 'b' }, { 'b', 'b', 'b' } };
			char lcube[][] = new char[][] { { 'g', 'g', 'g' }, { 'g', 'g', 'g' }, { 'g', 'g', 'g' } };
			char fcube[][] = new char[][] { { 'r', 'r', 'r' }, { 'r', 'r', 'r' }, { 'r', 'r', 'r' } };
			char bcube[][] = new char[][] { { 'o', 'o', 'o' }, { 'o', 'o', 'o' }, { 'o', 'o', 'o' } };

			int m = Integer.parseInt(br.readLine()); // 1
			st = new StringTokenizer(br.readLine());
			char keep[] = new char[3];
			for (int i = 0; i < m; i++) {
				String key = st.nextToken();
				if (key.charAt(0) == 'F') {
					keep[0] = ucube[2][0];
					keep[1] = ucube[2][1];
					keep[2] = ucube[2][2];
					if (key.charAt(1) == '-') {
						ucube[2][0] = rcube[0][0];
						ucube[2][1] = rcube[1][0];
						ucube[2][2] = rcube[2][0];
						rcube[0][0] = dcube[0][2];
						rcube[1][0] = dcube[0][1];
						rcube[2][0] = dcube[0][0];
						dcube[0][0] = lcube[0][2];
						dcube[0][1] = lcube[1][2];
						dcube[0][2] = lcube[2][2];
						lcube[0][2] = keep[2];
						lcube[1][2] = keep[1];
						lcube[2][2] = keep[0];
						minus(fcube);
					} else {
						ucube[2][0] = lcube[2][2];
						ucube[2][1] = lcube[1][2];
						ucube[2][2] = lcube[0][2];
						lcube[0][2] = dcube[0][0];
						lcube[1][2] = dcube[0][1];
						lcube[2][2] = dcube[0][2];
						dcube[0][0] = rcube[2][0];
						dcube[0][1] = rcube[1][0];
						dcube[0][2] = rcube[0][0];
						rcube[0][0] = keep[0];
						rcube[1][0] = keep[1];
						rcube[2][0] = keep[2];
						plus(fcube);
					}
				} else if (key.charAt(0) == 'B') {
					keep[0] = ucube[0][0];
					keep[1] = ucube[0][1];
					keep[2] = ucube[0][2];
					if (key.charAt(1) == '-') {
						ucube[0][2] = lcube[0][0];
						ucube[0][1] = lcube[1][0];
						ucube[0][0] = lcube[2][0];
						lcube[0][0] = dcube[2][0];
						lcube[1][0] = dcube[2][1];
						lcube[2][0] = dcube[2][2];
						dcube[2][0] = rcube[2][2];
						dcube[2][1] = rcube[1][2];
						dcube[2][2] = rcube[0][2];
						rcube[2][2] = keep[2];
						rcube[1][2] = keep[1];
						rcube[0][2] = keep[0];
						plus(bcube);
					} else {
						ucube[0][0] = rcube[0][2];
						ucube[0][1] = rcube[1][2];
						ucube[0][2] = rcube[2][2];
						rcube[0][2] = dcube[2][2];
						rcube[1][2] = dcube[2][1];
						rcube[2][2] = dcube[2][0];
						dcube[2][2] = lcube[2][0];
						dcube[2][1] = lcube[1][0];
						dcube[2][0] = lcube[0][0];
						lcube[0][0] = keep[2];
						lcube[1][0] = keep[1];
						lcube[2][0] = keep[0];
						minus(bcube);
					}
				} else if (key.charAt(0) == 'L') {
					keep[0] = ucube[0][0];
					keep[1] = ucube[1][0];
					keep[2] = ucube[2][0];
					if (key.charAt(1) == '-') {
						ucube[0][0] = fcube[0][0];
						ucube[1][0] = fcube[1][0];
						ucube[2][0] = fcube[2][0];
						fcube[0][0] = dcube[0][0];
						fcube[1][0] = dcube[1][0];
						fcube[2][0] = dcube[2][0];
						dcube[0][0] = bcube[2][0];
						dcube[1][0] = bcube[1][0];
						dcube[2][0] = bcube[0][0];
						bcube[2][0] = keep[0];
						bcube[1][0] = keep[1];
						bcube[0][0] = keep[2];
						minus(lcube);
					} else {
						ucube[0][0] = bcube[2][0];
						ucube[1][0] = bcube[1][0];
						ucube[2][0] = bcube[0][0];
						bcube[2][0] = dcube[0][0];
						bcube[1][0] = dcube[1][0];
						bcube[0][0] = dcube[2][0];
						dcube[0][0] = fcube[0][0];
						dcube[1][0] = fcube[1][0];
						dcube[2][0] = fcube[2][0];
						fcube[0][0] = keep[0];
						fcube[1][0] = keep[1];
						fcube[2][0] = keep[2];
						plus(lcube);
					}
				} else if (key.charAt(0) == 'R') {
					keep[0] = ucube[0][2];
					keep[1] = ucube[1][2];
					keep[2] = ucube[2][2];
					if (key.charAt(1) == '-') {
						ucube[2][2] = bcube[0][2];
						ucube[1][2] = bcube[1][2];
						ucube[0][2] = bcube[2][2];
						bcube[0][2] = dcube[2][2];
						bcube[1][2] = dcube[1][2];
						bcube[2][2] = dcube[0][2];
						dcube[2][2] = fcube[2][2];
						dcube[1][2] = fcube[1][2];
						dcube[0][2] = fcube[0][2];
						fcube[2][2] = keep[2];
						fcube[1][2] = keep[1];
						fcube[0][2] = keep[0];
						minus(rcube);
					} else {
						ucube[2][2] = fcube[2][2];
						ucube[1][2] = fcube[1][2];
						ucube[0][2] = fcube[0][2];
						fcube[2][2] = dcube[2][2];
						fcube[1][2] = dcube[1][2];
						fcube[0][2] = dcube[0][2];
						dcube[2][2] = bcube[0][2];
						dcube[1][2] = bcube[1][2];
						dcube[0][2] = bcube[2][2];
						bcube[0][2] = keep[2];
						bcube[1][2] = keep[1];
						bcube[2][2] = keep[0];
						plus(rcube);
					}
				} else if (key.charAt(0) == 'U') {
					keep[0] = fcube[0][0];
					keep[1] = fcube[0][1];
					keep[2] = fcube[0][2];
					if (key.charAt(1) == '-') {
						fcube[0][0] = lcube[0][0];
						fcube[0][1] = lcube[0][1];
						fcube[0][2] = lcube[0][2];
						lcube[0][0] = bcube[0][2];
						lcube[0][1] = bcube[0][1];
						lcube[0][2] = bcube[0][0];
						bcube[0][2] = rcube[0][0];
						bcube[0][1] = rcube[0][1];
						bcube[0][0] = rcube[0][2];
						rcube[0][0] = keep[0];
						rcube[0][1] = keep[1];
						rcube[0][2] = keep[2];
						minus(ucube);
					} else {
						fcube[0][0] = rcube[0][0];
						fcube[0][1] = rcube[0][1];
						fcube[0][2] = rcube[0][2];
						rcube[0][0] = bcube[0][2];
						rcube[0][1] = bcube[0][1];
						rcube[0][2] = bcube[0][0];
						bcube[0][2] = lcube[0][0];
						bcube[0][1] = lcube[0][1];
						bcube[0][0] = lcube[0][2];
						lcube[0][0] = keep[0];
						lcube[0][1] = keep[1];
						lcube[0][2] = keep[2];
						plus(ucube);
					}
				} else if (key.charAt(0) == 'D') {
					keep[0] = fcube[2][0];
					keep[1] = fcube[2][1];
					keep[2] = fcube[2][2];
					if (key.charAt(1) == '-') {
						fcube[2][0] = rcube[2][0];
						fcube[2][1] = rcube[2][1];
						fcube[2][2] = rcube[2][2];
						rcube[2][0] = bcube[2][2];
						rcube[2][1] = bcube[2][1];
						rcube[2][2] = bcube[2][0];
						bcube[2][2] = lcube[2][0];
						bcube[2][1] = lcube[2][1];
						bcube[2][0] = lcube[2][2];
						lcube[2][0] = keep[0];
						lcube[2][1] = keep[1];
						lcube[2][2] = keep[2];
						minus(dcube);
					} else {
						fcube[2][0] = lcube[2][0];
						fcube[2][1] = lcube[2][1];
						fcube[2][2] = lcube[2][2];
						lcube[2][0] = bcube[2][2];
						lcube[2][1] = bcube[2][1];
						lcube[2][2] = bcube[2][0];
						bcube[2][2] = rcube[2][0];
						bcube[2][1] = rcube[2][1];
						bcube[2][0] = rcube[2][2];
						rcube[2][0] = keep[0];
						rcube[2][1] = keep[1];
						rcube[2][2] = keep[2];
						plus(dcube);
					}
				}

			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(ucube[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}