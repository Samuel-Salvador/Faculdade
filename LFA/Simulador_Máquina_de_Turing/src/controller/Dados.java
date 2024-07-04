package controller;

import java.util.Collections;
import java.util.Scanner;

import entities.Estado;
import entities.FdT;
import entities.Maquina;

public class Dados {

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
		
	}
}
