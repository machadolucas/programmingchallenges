import java.util.Scanner;

// Problema 539
public class Main {

	public static final int SEM_CAMINHO = 0;
	public static final int COM_CAMINHO = 1;
	public static final int TO_PASSADA = 2;

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		while (true) {
			int nos = a.nextInt();
			int ver = a.nextInt();
			if (nos == 0 && ver == 0)
				break;
			int[][] matriz = new int[nos][nos];
			for (int i = 0; i < ver; i++) {
				int x = a.nextInt();
				int y = a.nextInt();
				matriz[x][y] = 1;
				matriz[y][x] = 1;
			}
			executa(matriz);
		}
	}

	private static int tamanhoMaximo = 0;

	public static void executa(int[][] matriz) {
		tamanhoMaximo = 0;

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length; j++) {

				if (i != j && matriz[i][j] == 1) {
					int tamanhoRecursao = recursao(matriz, i, j);
					if (tamanhoMaximo < tamanhoRecursao) {
						tamanhoMaximo = tamanhoRecursao;
					}
				}

			}
		}

		System.out.println(tamanhoMaximo);
	}

	private static int recursao(int[][] matriz, int i, int j) {
		int soma = 0;

		for (int k = 0; k < matriz.length; k++) {
			if (matriz[i][j] == COM_CAMINHO) {
				matriz[i][j] = TO_PASSADA;
				matriz[j][i] = TO_PASSADA;
				int temp = recursao(matriz, j, k) + 1;
				if (temp > soma) {
					soma = temp;
				}
				matriz[i][j] = COM_CAMINHO;
				matriz[j][i] = COM_CAMINHO;
			}
		}
		return soma;
	}
}