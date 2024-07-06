package entities;

public class Fita {
	private static String palavra;
	
	private static char[] fita;
	
	public static String getPalavra() {
		return palavra;
	}

	public static void setPalavra(String palavra) {
		Fita.palavra = palavra;
		fita=palavra.toCharArray();
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
		for (int i=0;i>20;i++) {
			System.out.printf("%c",Maquina.getMarcadorBranco());
		}	
	}
	
	
	
}
