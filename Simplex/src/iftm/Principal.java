package iftm;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Insira a quantidade de restri��es: ");
		int linha = sc.nextInt();
		System.out.print("Insira a quantidade de vari�veis: ");
		int coluna = sc.nextInt();

		Tabelas tb = new Tabelas();
		tb.Receber(linha, coluna);

		sc.close();

	}

}
