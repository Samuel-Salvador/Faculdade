package controller;

import java.util.Scanner;

import entities.*;

public class InstrucaoConstructor {
	private int cod;

	public InstrucaoConstructor(int cod) {
		this.cod= cod;
	}
	
	@SuppressWarnings("resource")
	public Instrucao createInstrucao(Scanner sc) {
		if(cod==1) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			return new I000001(cod, op1);			
		}
		if(cod==10) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			System.out.print("Operando 2: ");
			int op2 = sc.nextInt();
			return new I000010(cod, op1,op2);			
		}
		if(cod==11) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			return new I000011(cod, op1);			
		}
		if(cod==100) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			return new I000100(cod, op1);			
		}
		if(cod==101) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			return new I000101(cod, op1);			
		}
		if(cod==110) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			return new I000110(cod, op1);			
		}
		if(cod==111) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			return new I000111(cod, op1);			
		}
		if(cod==1000) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			return new I001000(cod, op1);			
		}
		if(cod==1001) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			return new I001001(cod, op1);			
		}
		if(cod==1010) {
			return new I001010(cod);			
		}
		if(cod==1011) {
			return new I001011(cod);			
		}
		if(cod==1100) {
			return new I001100(cod);			
		}
		if(cod==1111) {
			System.out.print("Operando 1: ");
			int op1 = sc.nextInt();
			return new I001111(cod, op1);			
		}
		return null;
	}
}
