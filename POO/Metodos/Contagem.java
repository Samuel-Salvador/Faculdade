package Faculdade.POO.Metodos;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Contagem {
    public static void contar() {
        int[] v={0,1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i<11;i++){
            System.out.printf(v[i]+" ");
        }
        
    }
    public static void contar(int fim) {
        for(int i=0;i<fim+1;i++){
            System.out.printf(i+" ");
        }
    }
    public static void contar(int inicio, int fim) {
        for(int i=inicio;i<fim+1;i++){
            System.out.printf(i+" ");
        }
        
    }
    public static void contar(int inicio,int fim,int pausa) {
        try {for(int i=inicio;i<fim+1;i++){
            System.out.printf(i+" ");
            TimeUnit.SECONDS.sleep(pausa);
        }
            
        } catch (InterruptedException e ) {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Digite o o inicio da contagem");
        int inicio=sc.nextInt();
        System.out.println("Digite o fim da contagem");
        int fim=sc.nextInt();
        System.out.println("Digite a pausa em segundos da contagem");
        int pausa=sc.nextInt();
        System.out.println();
        contar();
        System.out.println();
        contar(fim);
        System.out.println();
        contar(inicio,fim);
        System.out.println();
        contar(inicio,fim,pausa);
        sc.close();
    }
}
