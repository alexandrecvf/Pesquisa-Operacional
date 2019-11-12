package progDinamica;
import java.util.Scanner;
public class Fibonacci {
	public static long fibonacci(long x) {
		if(x == 0) {
			return 0;
		}
		if (x <= 2) {
			return 1;
		}
		return fibonacci(x - 1) + fibonacci(x - 2);
	}
	
	public static long Memorizacao[] = new long[9999];
	
	public static long fibonacciMemo(long n) {
		long valorFibonacci = 0;
		
		if (n == 0) {
			return 0;
			
		} else if (n == 1) {
			return 1;
			
		} else if (Memorizacao[(int) n] != 0) {
			return Memorizacao[(int) n];
			
		} else {
			valorFibonacci = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
			Memorizacao[(int) n] = valorFibonacci;
			return valorFibonacci;
		}
	}
	
	
	
	public static void main(String[] args) {
		Memorizacao[0] = 0;
		Memorizacao[1] = 1;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Qual a quantidade de números da sequencia de Fibonacci você deseja?");
		long posFib = scan.nextLong();
		
		System.out.println("Fibonacci na posição " + posFib + ": " + fibonacci(posFib));
		scan.close();
	}
}
