import java.util.Scanner;

public class Main {

	static int n;
	static int tabuleiro[][];

	static final int VAZIO = 0;
	static final int PAREDE = 1;
	static final int TORRE = 2;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		char[] caracteres;
		while (n != 0 && scan.hasNext()) {
			tabuleiro = new int[n][n];
			for (int i = 0; i < n; i++) {
				caracteres = scan.next().toCharArray();
				for (int j = 0; j < n; j++) {
					if (caracteres[j] == 'X')
						tabuleiro[i][j] = PAREDE;
					if (caracteres[j] == '.')
						tabuleiro[i][j] = VAZIO;
				}
			}
			executar();
			if (scan.hasNextInt())
				n = scan.nextInt();
		}
	}

	static int tamanhoMaximo = 0;

	private static void executar() {

		b(0, 0);

		System.out.println(tamanhoMaximo);
		tamanhoMaximo = 0;
	}

	private static void b(int i, int j) {

		if (i == n) {
			return;
		}

		if (j == n) {
			b(i + 1, 0);
			return;
		}

		if (tabuleiro[i][j] != PAREDE) {
			b(i, j + 1);
			
			
			if (valida()) {
				int temp = maximo();
				if (temp > tamanhoMaximo) {
					tamanhoMaximo = temp;
				}
			}

			tabuleiro[i][j] = TORRE;

			b(i, j + 1);
			
			
			if (valida()) {
				int temp = maximo();
				if (temp > tamanhoMaximo) {
					tamanhoMaximo = temp;
				}
			}

			tabuleiro[i][j] = VAZIO;

		} else {
			b(i, j + 1);

		}
	}
	public static int maximo() {

		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tabuleiro[i][j] == TORRE) {
					max++;
				}
			}
		}

		return max;
	}

	public static boolean valida() {
		
		int numTorres = 0;
		for (int x = 0; x < n; x++) {

			for (int ylinha = 0; ylinha < n; ylinha++) {
				if (tabuleiro[x][ylinha] == TORRE)
					numTorres++;
				if (tabuleiro[x][ylinha] == PAREDE)
					numTorres = 0;
				if (numTorres > 1)
					return false;
			}
			numTorres = 0;
		}

		numTorres = 0;
		for (int y = 0; y < n; y++) {

			for (int xlinha = 0; xlinha < n; xlinha++) {
				if (tabuleiro[xlinha][y] == TORRE)
					numTorres++;
				if (tabuleiro[xlinha][y] == PAREDE)
					numTorres = 0;
				if (numTorres > 1)
					return false;
			}
			
			numTorres = 0;
		}
		
		return true;

	}

}
