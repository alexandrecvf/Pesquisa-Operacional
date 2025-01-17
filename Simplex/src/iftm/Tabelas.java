package iftm;

import java.util.Scanner;

public class Tabelas {

	protected void Receber(int linha, int coluna) {
		Scanner scan = new Scanner(System.in);
		
		double[][] matriz = new double[linha][coluna];
		double menorValorZ = 0.0;
		int colunaPivo = 0;
		int linhaPivo = 0;
		boolean existeNegativo = true;

		// Entrada da Matriz
		System.out.println("Entre com a matriz");
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				matriz[i][j] = scan.nextDouble();
			}
		}

		// Verifica se tem n�mero negativo na linha da fun��o objetivo
		for (int j = 0; j < coluna; j++) {
			if (matriz[0][j] < 0) {
				existeNegativo = true;
				break;
			}
		}
		
		// Enquanto existir um n�mero negativo na primeira linha ele vai seguir
		while (existeNegativo) {
			// Encontra qual o menor valor da primeira linha
			for (int i = 0; i < linha; i++) {
				for (int j = 0; j < coluna; j++) {
					if (matriz[0][j] < menorValorZ) {
						menorValorZ = matriz[i][j];
						colunaPivo = j;
					}
				}
			}
			
			menorValorZ = 999.0;
			double div = 1.0;
			
			// Escolhe qual a coluna piv�, 
			for (int i = 1; i < linha; i++) {
				if (matriz[i][colunaPivo] > 0) {
					div = matriz[i][coluna - 1] / matriz[i][colunaPivo];
					if (div < menorValorZ) {
						menorValorZ = div;
						linhaPivo = i;
					}
				}
			}
			
			// Imprime caso o valor piv� seja diferente de 1, nesse caso precisa dividir toda a linha
			if (matriz[linhaPivo][colunaPivo] != 1) {
				double aux = matriz[linhaPivo][colunaPivo];
				for (int i = 0; i < coluna; i++) {
					matriz[linhaPivo][i] = matriz[linhaPivo][i] / aux;
				}
				System.out.println();
				System.out.println("------------------ Nova tabela ------------------");
				for (int i = 0; i < linha; i++) {
					for (int j = 0; j < coluna; j++) {
						System.out.print(matriz[i][j] + "\t");
					}
					System.out.println();
				}
			}

			double[][] matrizaux = matriz;

			for (int i = 0; i < linha; i++) {
				double valor = matriz[i][colunaPivo] * -1.0;
				for (int j = 0; j < coluna; j++) {
					if ((i != linhaPivo) && valor != 0) {
						matrizaux[i][j] = matriz[linhaPivo][j] * valor + matriz[i][j];
					}
				}
			}
			
			// Imprime caso o valor piv� seja igual a 1, nesse caso n�o precisa dividir toda a linha
			System.out.println();
			System.out.println("------------------ Nova Tabela ------------------");
			for (int i = 0; i < linha; i++) {
				for (int j = 0; j < coluna; j++) {
					System.out.print(matrizaux[i][j] + "\t");
				}
				System.out.println();
			}

			for (int j = 0; j < coluna; j++) {
				if (matriz[0][j] < 0) {
					existeNegativo = true;
					break;
				} else {
					existeNegativo = false;
				}
			}
		}
		scan.close();
	}
}
