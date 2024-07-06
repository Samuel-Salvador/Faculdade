package application;

import java.util.Scanner;

import controller.Dados;
import entities.Fita;
import entities.Maquina;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------ Máquina de Turing -----");
		//while(Fita.getPalavra()!="-1") {
			Dados.setDados(sc);
			//Maquina.executar();
		//}
		
	}
}
