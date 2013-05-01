import java.util.Scanner;

// Problema 170
public class Main {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String lin;
		String[] temp;

		String[][] relogio;

		while (scanner.hasNext()) {

			relogio = new String[4][13];

			for (int i = 0; i < 4; i++) {
				lin = scanner.nextLine();
				if (lin.startsWith("#")) {
					return;
				}
				temp = lin.split(" ");
				for (int j = 12; j >= 0; j--) {
					relogio[i][j] = temp[12 - j];
				}

			}
			executar(relogio);
		}
	}

	private static void executar(String[][] relogio) {

		int[] aux = new int[13];
		int contador = 0;
		
		int pilha = 12;

		while (true) {

			String atual = relogio[aux[pilha]][pilha];			
			aux[pilha]++;
			pilha = converteString(atual) - 1;
			contador++;
			
			if(aux[pilha] == 4) {
				if(contador < 10){
					System.out.print("0" + contador + ",");
				} else {
					System.out.print(contador + ",");
				}
				System.out.println(atual);
				return;
			}
		}
	}

	private static int converteString(String atual) {

		if (atual.charAt(0) >= '0' && atual.charAt(0) <= '9') {
			return Character.getNumericValue(atual.charAt(0));
		}
		if (atual.charAt(0) == 'A') {
			return 1;
		}
		if (atual.charAt(0) == 'T') {
			return 10;
		}
		if (atual.charAt(0) == 'J') {
			return 11;
		}
		if (atual.charAt(0) == 'Q') {
			return 12;
		}
		if (atual.charAt(0) == 'K') {
			return 13;
		}
		return -1;
	}
}

/*
 * 
 * EXEMPLO DE ENTRADA TS QC 8S 8D QH 2D 3H KH 9H 2H TH KS KC 9D JH 7H JD 2S QS
 * TD 2C 4H 5H AD 4D 5D 6D 4S 9S 5S 7S JS 8H 3D 8C 3S 4C 6S 9C AS 7C AH 6H KD JC
 * 7D AC 5C TC QD 6C 3C KS QC 8S 8D QH 2D 3H TS 9H 2H TH 9D 6D KD JH 7H JD 2S QS
 * TD 2C 4H 5H AD 4D 5D KH 4S 9S 5S 7S JS 8H 3D 8C 3S 4C 6S 9C KC 7C AH 6H AS JC
 * 7D AC 5C TC QD 6C 3C QC JC TC 9C 8C 7C 6C 5C 4C 3C 2C AC KC QD JD TD 9D 8D 7D
 * 6D 5D 4D 3D 2D AD KD QS JS TS 9S 8S 7S 6S 5S 4S 3S 2S AS KS QH JH TH 9H 8H 7H
 * 6H 5H 4H 3H 2H AH KH #
 * 
 * EXEMPLO DE SAIDA 44,KD 04,KC 52,KH
 */