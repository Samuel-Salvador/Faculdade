package entities;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	private int nome;
	private boolean ehEstadoinicial;
	private boolean ehEstadofinal;
	private static boolean tabelaExecutouUmaVez;

	List<FdT> listaFdT = new ArrayList<>();

	public Estado(int nome, boolean ehEstadoinicial, boolean ehEstadofinal) {
		super();
		this.nome = nome;
		this.ehEstadoinicial = ehEstadoinicial;
		this.ehEstadofinal = ehEstadofinal;
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

	public boolean isEhEstadoinicial() {
		return ehEstadoinicial;
	}

	public void setEhEstadoinicial(boolean ehEstadoinicial) {
		this.ehEstadoinicial = ehEstadoinicial;
	}

	public boolean isEhEstadofinal() {
		return ehEstadofinal;
	}

	public void setEhEstadofinal(boolean ehEstadofinal) {
		this.ehEstadofinal = ehEstadofinal;
	}

	public List<FdT> getLista() {
		return listaFdT;
	}

	public void putOnListaFdT(FdT fdt) {
		listaFdT.add(fdt);
	}

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
