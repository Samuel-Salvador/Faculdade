package entities;

import java.util.List;
import java.util.Scanner;

import application.Program;

public class Menu {
	private static int escolha=0;
	
	public static void showMenu(Scanner sc, List<Instrucao> list) {
		while (escolha != 6) {
			System.out.println("\t OPÇÕES \t");
			System.out.println("1 - INSERIR INSTRUÇÕES ");
			System.out.println("2 - VER INSTRUÇÕES INSERIDAS   ");
			System.out.println("3 - VER MEMÓRIA    ");
			System.out.println("4 - LIMPAR MEMÓRIA    ");
			System.out.println("5 - EXECUTAR ");
			System.out.println("6 - SAIR    ");
			System.out.print("\nDigite sua escolha: ");
			escolha = sc.nextInt();
			switch (escolha) {
			case 1:
				Instrucao.inserirInstrucoes(sc, list, Program.n);
				break;
			case 2:
				Instrucao.verInstrucoes(list);
				break;
			case 3:
				Memory.showMemory();
				break;
			case 4:
				Memory.limparMemoria(list);
				break;
			case 5:
				Instrucao.executar(list);
				break;
			case 6:
				break;
			}
		}

	}
}
