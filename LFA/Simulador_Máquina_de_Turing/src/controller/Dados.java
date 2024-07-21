package controller;

import java.util.Collections;
import java.util.Scanner;

import entities.Estado;
import entities.FdT;
import entities.Fita;
import entities.Maquina;

public class Dados {

	//Pega todos os dados do usuário referente a MT, inclusive instancia cada objeto 
	public static void setDados(Scanner sc) {
		int nomeEstadoFinal=0;
		Maquina.setAlfabeto(sc);
		Maquina.setAlfabetoAuxiliar(sc);
		Maquina.setQuantidadeEstados(sc);
		Maquina.setEstadoInicial(sc);
		Maquina.setQuantidadeEstadosFinais(sc);		
		for (int i = 0; i < Maquina.getQuantidadeEstadosFinais(); i++) {
			System.out.printf("Informe o %dº estado final: ", i + 1);
			nomeEstadoFinal=sc.nextInt();
			Estado estadoFinal = new Estado(nomeEstadoFinal,false,true);
			sc.nextLine();
			Maquina.addEstadoFinal(estadoFinal);
			Maquina.addEstado(estadoFinal);
		}
		for (int i = 1; i <= Maquina.getQuantidadeEstados(); i++) {
			for(Estado estado: Maquina.getListaEstadosFinais()) {
				if (i==estado.getNome()||i==Maquina.getEstadoInicial()) {
					i++;
				}
			}			
			if(i <= Maquina.getQuantidadeEstados()) {
				Estado estado = new Estado(i,false,false);
				Maquina.addEstado(estado);
			}
				
		}
		Estado estadoInicial = new Estado(Maquina.getEstadoInicial(),true,false);
		Maquina.addEstado(estadoInicial);
		Maquina.setMarcadorInicio(sc);
		Maquina.setMarcadorBranco(sc);
		for(Estado estado: Maquina.getListaEstados()) {
			for (int i=0;i<Maquina.getQuantidadeAlfabeto()+Maquina.getQuantidadeAlfabetoAuxiliar()+2;i++) {
				FdT fdt = new FdT(estado.getNome());
				estado.putOnListaFdT(fdt);
			}			
		}
		Collections.sort(Maquina.getListaEstados(),new EstadosComparator());
		Maquina.printChart();
		System.out.println();
		System.out.println("Digite as transições: ");
		System.out.println("Obs 1: Caso não haja transições, insira X.");
		System.out.println("Obs 2: Qualquer transição inválida fará com que o campo seja anulado.");
		System.out.println();
		for (Estado est:	Maquina.getListaEstados()) {
			for (FdT fdt: 	est.getLista()) {
				System.out.println("----------------------------------");
				try {
					int posicaoAlfabetoAuxiliar=0;
					System.out.printf("Digite o estado futuro da transição: %d,%d\n",est.getNome(),est.getLista().indexOf(fdt)+1);
					if((est.getLista().indexOf(fdt)+1)<=Maquina.getQuantidadeAlfabeto()) {
						fdt.setLerNaFita(Maquina.getAlfabeto().charAt(est.getLista().indexOf(fdt)));
					}else if((est.getLista().indexOf(fdt)+1)<=Maquina.getQuantidadeAlfabetoAuxiliar()+Maquina.getQuantidadeAlfabeto()) {
						if((est.getLista().indexOf(fdt)+1)==Maquina.getQuantidadeAlfabeto()+1) {
							fdt.setLerNaFita(Maquina.getAlfabetoAuxiliar().charAt(posicaoAlfabetoAuxiliar));
							posicaoAlfabetoAuxiliar++;
						}else{
							fdt.setLerNaFita(Maquina.getAlfabetoAuxiliar().charAt(posicaoAlfabetoAuxiliar));
							posicaoAlfabetoAuxiliar++;
							 }			
					}else if((est.getLista().indexOf(fdt)+1)==Maquina.getQuantidadeAlfabetoAuxiliar()+Maquina.getQuantidadeAlfabeto()+1) {
						fdt.setLerNaFita(Maquina.getMarcadorInicio());
					}else if((est.getLista().indexOf(fdt)+1)==Maquina.getQuantidadeAlfabetoAuxiliar()+Maquina.getQuantidadeAlfabeto()+2) {
						fdt.setLerNaFita(Maquina.getMarcadorBranco());
					}
					fdt.setEstadoProximo(Integer.parseInt(sc.nextLine()));
					System.out.printf("Digite o alfabeto futuro da transição: %d,%d\n",est.getNome(),est.getLista().indexOf(fdt)+1);
					fdt.setTrocarNaFita(sc.nextLine().charAt(0));
					System.out.printf("Digite a direção da transição: %d,%d (D para Direita | E para Esquerda)\n",est.getNome(),est.getLista().indexOf(fdt)+1);
					fdt.setDirecao(sc.nextLine().charAt(0));
				}
				catch (NumberFormatException e) {
					System.out.println("O campo será anulado!");
				}	
			}
		}
		Estado.tabelaExecutouUmaVez();
		Maquina.printChart();		
	}
}
