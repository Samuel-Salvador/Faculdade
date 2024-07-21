package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maquina {
	private static String alfabeto = "";
	private static String alfabetoAuxiliar = "";

	private static int quantidadeAlfabeto;
	private static int quantidadeAlfabetoAuxiliar;
	private static int quantidadeEstados;
	private static int estadoInicial;
	private static int quantidadeEstadosFinais;
	private static Character marcadorInicio;
	private static Character marcadorBranco;

	private static List<Estado> listaEstados = new ArrayList<>();
	private static List<Estado> listaEstadosFinais = new ArrayList<>();

	public static int getQuantidadeAlfabeto() {
		return quantidadeAlfabeto;
	}

	public static int getQuantidadeAlfabetoAuxiliar() {
		return quantidadeAlfabetoAuxiliar;
	}

	public static String getAlfabeto() {
		return alfabeto;
	}

	public static void setAlfabeto(Scanner sc) {
		System.out.print("Informe a quantidade de letras do alfabeto: ");
		quantidadeAlfabeto = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < quantidadeAlfabeto; i++) {
			System.out.printf("Informe a %dª letra do alfabeto: ", i + 1);
			alfabeto += sc.nextLine().charAt(0);
		}
	}

	public static String getAlfabetoAuxiliar() {
		return alfabetoAuxiliar;
	}

	public static void setAlfabetoAuxiliar(Scanner sc) {
		System.out.print("Informe a quantidade de letras do alfabeto auxiliar: ");
		quantidadeAlfabetoAuxiliar = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < quantidadeAlfabetoAuxiliar; i++) {
			System.out.printf("Informe a %dª letra do alfabeto auxiliar: ", i + 1);
			alfabetoAuxiliar += sc.nextLine().charAt(0);
		}
	}

	public static int getQuantidadeEstados() {
		return quantidadeEstados;
	}

	public static void setQuantidadeEstados(Scanner sc) {
		System.out.print("Informe a quantidade de estados: ");
		quantidadeEstados = sc.nextInt();
		sc.nextLine();
	}

	public static int getQuantidadeEstadosFinais() {
		return quantidadeEstadosFinais;
	}

	public static void setQuantidadeEstadosFinais(Scanner sc) {
		System.out.print("Informe a quantidade de estados finais: ");
		quantidadeEstadosFinais = sc.nextInt();
		sc.nextLine();
	}

	public static int getEstadoInicial() {
		return estadoInicial;
	}

	public static void setEstadoInicial(Scanner sc) {
		System.out.print("Informe o estado inicial: ");
		estadoInicial = sc.nextInt();
		sc.nextLine();
	}

	public static Character getMarcadorInicio() {
		return marcadorInicio;
	}

	public static void setMarcadorInicio(Scanner sc) {
		System.out.print("Informe o marcador de início: ");
		marcadorInicio = sc.nextLine().charAt(0);
	}

	public static Character getMarcadorBranco() {
		return marcadorBranco;
	}

	public static void setMarcadorBranco(Scanner sc) {
		System.out.print("Informe o marcador de branco: ");
		marcadorBranco = sc.nextLine().charAt(0);
	}

	public static List<Estado> getListaEstados() {
		return listaEstados;
	}

	public static void addEstado(Estado estado) {
		listaEstados.add(estado);
	}

	public static List<Estado> getListaEstadosFinais() {
		return listaEstadosFinais;
	}

	public static void addEstadoFinal(Estado estado) {
		listaEstadosFinais.add(estado);
	}

	
	
	//imprime a tabela de transição
	public static void printChart() {
		System.out.println();
		System.out.println("\t\t\t\t====== Tabela de Transição ======");
		for (int i = 0; i < getQuantidadeAlfabeto(); i++) {
			System.out.printf("\t\t %c", getAlfabeto().charAt(i));
		}
		for (int i = 0; i < getQuantidadeAlfabetoAuxiliar(); i++) {
			System.out.printf("\t\t %c", getAlfabetoAuxiliar().charAt(i));
		}
		System.out.printf("\t\t %c", getMarcadorInicio());
		System.out.printf("\t\t %c \n", getMarcadorBranco());
		for (int i = 0; i < getQuantidadeEstados(); i++) {
			System.out.printf("S%d", i + 1);
			listaEstados.get(i).printFdTEstado();
			System.out.println();
		}

	}
	
	//Executa a máquina de Turing
	
	public static void executar() {

		int estadoAtual = Maquina.getEstadoInicial() - 1;
		int letraAtualFita = 1;
		boolean estadoAtualEhfinal = false;
		boolean palavraAcabou=false;
		boolean deuRuim = false;
		for (int i = 0; i < Maquina.getListaEstados().get(estadoAtual).listaFdT.size(); i++) {
			FdT fdt = Maquina.getListaEstados().get(estadoAtual).listaFdT.get(i);
			if (Maquina.getListaEstados().get(estadoAtual).isEstadofinal()) {
				break;
			}
			try {
				if (Fita.getFita()[letraAtualFita] == fdt.getLerNaFita()) {
					Fita.modifyFita(letraAtualFita, fdt.getTrocarNaFita());
					if (fdt.getDirecao() == 'D') {
						letraAtualFita++;
					} else
						letraAtualFita--;
					estadoAtual = fdt.getEstadoProximo() - 1;
					i = -1;
				}
			} catch (NullPointerException e) {
				Fita.printarFitaInicio();
			}

		}

		System.out.println();
		System.out.println("Fita modificada: ");
		for (int j = 0; j < 50; j++) {
			System.out.print(Fita.getFita()[j]);
		}
		System.out.println();
		if (!Maquina.getListaEstados().get(estadoAtual).isEstadofinal()) {
			System.out.println();
			System.out.println("Palavra não aceita!");
		} else {
			for (int j = 0; j < 50; j++) {
				if(Fita.getFita()[j]==Maquina.getMarcadorBranco()) {
					palavraAcabou=true;
				}
				if(palavraAcabou && Fita.getFita()[j]!=Maquina.getMarcadorBranco()) {
					System.out.println();
					deuRuim = true;
					System.out.println("Palavra não aceita!");
					break;
				}
				
			}
			if(palavraAcabou && !deuRuim) {
				System.out.println();
				System.out.println("Palavra aceita!");
			}
		}
	}
}
