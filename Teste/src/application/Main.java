package application;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] mat = new int[m][n];
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Qual numero você quer ver: ");
		int valor = sc.nextInt();
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				if(valor == mat[i][j]) {
					System.out.println("Cima " + mat[i-1][j]);
					System.out.println("Esquerda " + mat[i][j-1]);
					System.out.println("Direita " + mat[i][j+1]);
					System.out.println("Baixo " + mat[i+1][j]);
				}
			}
		}
		
		
		sc.close();
	}

}
