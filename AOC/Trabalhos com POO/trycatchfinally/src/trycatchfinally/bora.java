package trycatchfinally;

import java.util.InputMismatchException;
import java.util.Scanner;

public class bora {
	public static void main (String[]args) {
	int[] bora = new int[10];
	Scanner sc= new Scanner(System.in);
	InputMismatchException e;
	while (e!=null) {
		try{
			bora[1] = sc.nextInt();
			sc.nextLine();
		}
		catch(VariableDeclaratorId e) {
			System.out.println("escreve certo porra");
			bora[1] = sc.nextInt();
		}
	}
	
	
	
	sc.close();
}}