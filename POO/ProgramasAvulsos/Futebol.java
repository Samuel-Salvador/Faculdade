package Faculdade.POO.ProgramasAvulsos;
import java.util.Scanner;
public class Futebol {
    public static void main(String[] args) {
        int ptsli,ptsla,vi;
        Scanner sc;
            sc=new Scanner(System.in);
        System.out.println("Digite a quantidade de pontos do time lider : ");
        ptsli=sc.nextInt();
        System.out.println("Digite a quantidade de pontos do time lanterna : ");
        ptsla=sc.nextInt();
        vi=(ptsli-ptsla)/3;
        System.out.println("A quantidade de vitorias necessarias eh : "+vi);
        sc.close();    
    }    
}
