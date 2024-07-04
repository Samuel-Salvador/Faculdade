package entities;

import java.util.ArrayList;
import java.util.List;

public class Fita {
	static List<Character> lista = new ArrayList<>();

	public static List<Character> getLista() {
		return lista;
	}

	public static void putOnLista(Character c) {
		lista.add(c);
	}
	
	
}
