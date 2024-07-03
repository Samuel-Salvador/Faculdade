package entities;

import java.util.List;
import java.util.Scanner;

import controller.InstrucaoConstructor;

public abstract class Instrucao {
	public boolean jumpConcluded;
	
	private int COD;
	private int op1, op2;
	private String resultado;
	
	
	public Instrucao(int COD) {
		this.COD = COD;
	}
	public void setJumpConcluded(boolean mudanca) {
		jumpConcluded=mudanca;
	}
	public boolean getJumpConcluded() {
		return jumpConcluded;
	}
	public int getCOD() {
		return COD;
	}

	public int getOp1() {
		return op1;
	}

	public void setOp1(int op1) {
		this.op1 = op1;
	}

	public int getOp2() {
		return op2;
	}

	public void setOp2(int op2) {
		this.op2 = op2;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public static void verInstrucoes(List<Instrucao> list) {
		System.out.println("\nInstruções a serem executadas: ");
		int i = 0;
		System.out.println("ORDEM  -   COD  -  OP1  - OP2 - RESULTADOS");
		for (Instrucao ins : list) {
			i++;
			if (ins.getOp1() == 0) {
				System.out.printf("  %d    - %06d -       -     - %s\n", i, ins.getCOD(), ins.toString());
			} else if (ins.getOp2() == 0) {
				System.out.printf("  %d    - %06d -  %d  -     - %s\n", i, ins.getCOD(), ins.getOp1(), ins.toString());
			} else {
				System.out.printf("  %d    - %06d -  %d  - %d  - %s\n", i, ins.getCOD(), ins.getOp1(), ins.getOp2(),
						ins.toString());
			}
		}
		System.out.println();
	}
	public static void inserirInstrucoes(Scanner sc, List<Instrucao> list, int n) {
		System.out.println("\n \t\t INSTRUÇÕES \t\n");
		System.out.println("   COD   -  OP1  -   OP2  - RESULTADOS");
		System.out.println("  000001 - #POS  -        - MBR <- #POS");
		System.out.println("  000010 - #POS  - #DADO  - #POS <- #DADO");
		System.out.println("  000011 - #POS  -        - MBR <- MBR + #POS");
		System.out.println("  000100 - #POS  -        - MBR <- MBR - #POS");
		System.out.println("  000101 - #POS  -        - MBR <- MBR * #POS");
		System.out.println("  000110 - #POS  -        - MBR <- MBR / #POS");
		System.out.println("  000111 - #LIN  -        - JUMP to #LIN");
		System.out.println("  001000 - #LIN  -        - JUMP IF Z to #LIN");
		System.out.println("  001001 - #LIN  -        - JUMP IF N to #LIN");
		System.out.println("  001010 -       -        - MBR <- raiz_quadrada(MBR)");
		System.out.println("  001011 -       -        - MBR <- - MBR");
		System.out.println("  001111 - #POS  -        - #POS <- MBR");
		System.out.println("  001100 -       -        - NOP");
		int cod = 0;
		while (cod != 1100) {
			System.out.print("\nDigite a Instrução: ");
			cod = sc.nextInt();

			if (cod == 1100) {
				System.out.println();
			}
			InstrucaoConstructor IC = new InstrucaoConstructor(cod);
			Instrucao ins = IC.createInstrucao(sc);
			list.add(ins);
			Memory.getMemoria()[n] = cod;
			n++;
		}
	}
	public static void executar(List<Instrucao> list) {
		int indiceJump=0;
		System.out.println("\n\t EXECUTANDO");
		while (Registrador.getPc() <= list.size()) {
			System.out.println("CALCULO DO ENDEREÇO DA INSTRUÇÃO:");
			System.out.printf("PC: %06d\n", Registrador.getPc());
			System.out.println("BUSCANDO A INSTRUÇÃO: ");
			if (list.get(Registrador.getPc() - 1).getOp1() == 0) {
				System.out.printf("RI <OPCODE>: %06d \n", list.get(Registrador.getPc() - 1).getCOD());
			} else if (list.get(Registrador.getPc() - 1).getOp2() == 0) {
				System.out.printf("RI <OPCODE> <OP1>: %06d %06d \n", list.get(Registrador.getPc() - 1).getCOD(),
						list.get(Registrador.getPc() - 1).getOp1());
			} else {
				System.out.printf("RI <OPCODE> <OP1> <OP2>: %06d %06d %06d \n",
						list.get(Registrador.getPc() - 1).getCOD(), list.get(Registrador.getPc() - 1).getOp1(),
						list.get(Registrador.getPc() - 1).getOp2());
			}
			System.out.println("DECODIFICANDO A INSTRUÇÃO:");
			if (list.get(Registrador.getPc() - 1).getCOD() != 1100) {
				System.out.println(list.get(Registrador.getPc() - 1).getResultado());
			}
			if ((list.get(Registrador.getPc() - 1).getCOD() == 111)
							|| (list.get(Registrador.getPc() - 1).getCOD() == 1000 && Registrador.getMbr() == 0)
							|| (list.get(Registrador.getPc() - 1).getCOD() == 1001 && Registrador.getMbr() < 0)) {
				list.get(Registrador.getPc() - 1).setJumpConcluded(true);
				indiceJump=Registrador.getPc()-1;
				
			}
			list.get(Registrador.getPc() - 1).tarefa();
			if (list.get(indiceJump).getJumpConcluded()) {
				System.out.println(list.get(indiceJump).toString());
				if (list.get(indiceJump).getOp1() != 0) {
					System.out.println("CALCULO DO ENDEREÇO DO OPERANDO: ");
					System.out.printf("ENDEREÇO: %06d\n", list.get(indiceJump).getOp1());
					System.out.println("BUSCANDO OPERANDO NA POSIÇÃO: ");
					System.out.printf("MAR: %06d\n", list.get(indiceJump).getOp1());
				}
				if (list.get(indiceJump).getOp2() != 0) {
					System.out.println("CALCULO DO ENDEREÇO DO SEGUNDO OPERANDO: ");
					System.out.printf("ENDEREÇO: %06d\n", list.get(indiceJump).getOp2());
					System.out.println("BUSCANDO O SEGUNDO OPERANDO NA POSIÇÃO: ");
					System.out.printf("MAR: %06d\n", list.get(indiceJump).getOp2());
				}
				System.out.println("OPERAÇÃO DE DADOS: ");
				System.out.println(list.get(indiceJump).operacaoDeDados());
				System.out.println();

				if (list.get(indiceJump).getCOD() == 1100) {
					Registrador.setPc(indiceJump);
					break;
				}

			}else {
				System.out.println(list.get(Registrador.getPc() - 2).toString());
				if (list.get(Registrador.getPc() - 2).getOp1() != 0) {
					System.out.println("CALCULO DO ENDEREÇO DO OPERANDO: ");
					System.out.printf("ENDEREÇO: %06d\n", list.get(Registrador.getPc() - 2).getOp1());
					System.out.println("BUSCANDO OPERANDO NA POSIÇÃO: ");
					System.out.printf("MAR: %06d\n", list.get(Registrador.getPc() - 2).getOp1());
				}
				if (list.get(Registrador.getPc() - 2).getOp2() != 0) {
					System.out.println("CALCULO DO ENDEREÇO DO SEGUNDO OPERANDO: ");
					System.out.printf("ENDEREÇO: %06d\n", list.get(Registrador.getPc() - 2).getOp2());
					System.out.println("BUSCANDO O SEGUNDO OPERANDO NA POSIÇÃO: ");
					System.out.printf("MAR: %06d\n", list.get(Registrador.getPc() - 2).getOp2());
				}
				System.out.println("OPERAÇÃO DE DADOS: ");
				System.out.println(list.get(Registrador.getPc() - 2).operacaoDeDados());
				System.out.println();

				if (list.get(Registrador.getPc() - 2).getCOD() == 1100) {
					Registrador.setPc(Registrador.getPc() - 2);
					break;
				}

			}
			list.get(indiceJump).setJumpConcluded(false);
		}

	}

	public abstract void tarefa();
	public abstract String operacaoDeDados();
}
