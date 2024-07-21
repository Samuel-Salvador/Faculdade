package entities;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	private int nome;
	private boolean estadoinicial;
	private boolean estadofinal;
	private static boolean tabelaExecutouUmaVez;

	List<FdT> listaFdT = new ArrayList<>();

	public Estado(int nome, boolean ehEstadoinicial, boolean ehEstadofinal) {
		super();
		this.nome = nome;
		this.estadoinicial = ehEstadoinicial;
		this.estadofinal = ehEstadofinal;
	}
	
	public static void tabelaExecutouUmaVez() {
		tabelaExecutouUmaVez=true;
	}
	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
		this.nome = nome;
	}

	public boolean isEstadoinicial() {
		return estadoinicial;
	}

	public void setEstadoinicial(boolean ehEstadoinicial) {
		this.estadoinicial = ehEstadoinicial;
	}

	public boolean isEstadofinal() {
		return estadofinal;
	}

	public void setEstadofinal(boolean ehEstadofinal) {
		this.estadofinal = ehEstadofinal;
	}

	public List<FdT> getLista() {
		return listaFdT;
	}

	public void putOnListaFdT(FdT fdt) {
		listaFdT.add(fdt);
	}

	// Imprime as funções de transição do estado
	public void printFdTEstado() {
		
		for (FdT fdt : listaFdT) {
			if (fdt.getTrocarNaFita()!=null&&fdt.getDirecao()!=null)
				System.out.printf("\t <%c,%c>;%c",fdt.getLerNaFita(),fdt.getTrocarNaFita(),fdt.getDirecao());
			else if(tabelaExecutouUmaVez) {
				System.out.printf("\t\t X");
			}else{
				System.out.printf("\t\t %d,%d",nome,listaFdT.indexOf(fdt)+1);
			}
		}
		System.out.println();
	}
}
