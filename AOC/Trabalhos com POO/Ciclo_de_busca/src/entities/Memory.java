package entities;

import java.util.List;

public class Memory {
	
	private static double[] memoria = new double[500];

	public static double[] getMemoria() {
		
		return memoria;
	}
	public static void showMemory() {
		System.out.println("\nMEMORIA: ");
		for (int i = 0; i < 250; i++) {
			System.out.printf("[%08.1f]", memoria[i]);
		}
		System.out.println();
		for (int i = 250; i < 500; i++) {
			System.out.printf("[%08.1f]", memoria[i]);
		}
		System.out.println();
		System.out.println();
	}
	public static void putMemoryOnMbr() {
		Registrador.setMbr(memoria[Registrador.getMar()]);
	}

	public static void putMbrOnMemory() {
		memoria[Registrador.getMar()] = Registrador.getMbr();
	}
	public static void limparMemoria(List<Instrucao> list) {
		try {
			System.out.print("\nLIMPANDO MEMORIA");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".\n");
			list.clear();
			for (int i=0;i<500;i++) {
				memoria[i]=0.0;
			}
			System.out.println("MEMÓRIA LIMPA!\n ");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
