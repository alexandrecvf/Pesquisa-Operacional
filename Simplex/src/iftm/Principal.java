package iftm;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Quantidade de restri��es: ");
		int linhas = scan.nextInt();
		
		System.out.print("Quantidade de vari�veis: ");
		int colunas = scan.nextInt();

		Tabelas tabela = new Tabelas();
		tabela.Receber(linhas, colunas);

		scan.close();
	}

}
