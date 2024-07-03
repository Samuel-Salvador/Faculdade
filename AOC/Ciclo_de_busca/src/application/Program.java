package application;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import entities.Instrucao;
import entities.Menu;

public class Program {
	public static int n = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Instrucao> list = new ArrayList<>();

		Menu.showMenu(sc, list);

		sc.close();
	}

	
}
