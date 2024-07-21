package application;

import java.util.Scanner;

import controller.Dados;
import entities.Fita;
import entities.Maquina;

public class Program {

	//Professor, eu sou bilingue, logo os métodos e atributos estão escritos em Portu-English.
	// KKKKKKKKKKKKKKKKKKKKKKKKK, preciso mudar isso.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------ Máquina de Turing -----");
		Dados.setDados(sc);
		while(Fita.getPalavra()!="-1") {
			Fita.setPalavra(sc);
			Maquina.executar();			
		}					
	}
}
