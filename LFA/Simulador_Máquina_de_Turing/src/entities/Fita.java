package entities;

import java.util.Scanner;

public class Fita {
	private static String palavra;
	
	private static char[] fita=new char[50];
	
	public static String getPalavra() {
		return palavra;
	}

	public static void setPalavra(Scanner sc) {
		System.out.printf("Digite a palavra a ser reconhecida: ");
		Fita.palavra = sc.nextLine();
		fita[0]=Maquina.getMarcadorInicio();
		for(int i=1;i<=palavra.length();i++) {
			fita[i]=palavra.toCharArray()[i-1];
		}
		for(int i=palavra.length()+1;i<50;i++) {
			fita[i]=Maquina.getMarcadorBranco();
		}
	}
	
	public static void modifyFita(int index, char character) {
		fita[index]=character;
	}
	


	public static char[] getFita() {
		return fita;
	}

	public static void printarFitaInicio() {
		System.out.println("Fita inicio: ");
		System.out.printf("%c%s",Maquina.getMarcadorInicio(),palavra);
		for (int k=0;k<50;k++) {
			System.out.printf("%c",Maquina.getMarcadorBranco());
		}
		System.out.println();
		System.out.println();
	}	
}
