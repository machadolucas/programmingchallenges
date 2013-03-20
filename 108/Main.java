import java.util.Scanner;

class Main {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		int m[][];
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		m = new int[n][n];
		int i = 0;
		int j = 0;
		while (scan.hasNext()) {
			m[i][j] = scan.nextInt();
			j = (j + 1) % n;
			if (j == 0)
				i++;
			if (i == n)
				break;
		}
		executar(m, n);
	}

	static void executar(int m[][], int n) {

		int[][] c = new int[n][n];

		c[0][0] = m[0][0];

		for (int i = 1; i < n; i++) {
			c[0][i] = c[0][i - 1] + m[0][i];
		}
		for (int j = 1; j < n; j++) {
			c[j][0] = c[j - 1][0] + m[j][0];
		}

		int max = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				c[i][j] = c[i - 1][j] + c[i][j - 1] - c[i - 1][j - 1] + m[i][j];

				if (c[i][j] > max) {
					max = c[i][j];
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				for (int x = 0; x <= i; x++) {
					for (int y = 0; y <= j; y++) {

						int temp = 0;

						temp = temp + c[i][j];
						
						if (x != 0) {
							temp = temp - c[x - 1][j];
						}

						if (y != 0) {
							temp = temp - c[i][y - 1];
						}

						if (x != 0 && y != 0) {
							temp = temp + c[x - 1][y - 1];
						}

						if (temp > max) {
							max = temp;
						}
					}
				}
			}
		}

		System.out.println(max);
	}
}
