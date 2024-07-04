package controller;
import entities.Estado;

public class EstadosComparator implements java.util.Comparator<Estado>{

	@Override
	public int compare(Estado estado1, Estado estado2) {
		return estado1.getNome()-estado2.getNome();
	}

}
