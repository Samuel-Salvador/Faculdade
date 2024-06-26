package Faculdade.POO.Metodos;
import javax.swing.JOptionPane;
import java.util.*;
public class mediaNotas {
    public static void main(String[] args) {
        int[] num=new int[5];
        float media=0;
        String janela="";
        for(int i=0;i<5;i++){
            num[i]=Integer.parseInt (JOptionPane.showInputDialog(null, "Forneça um número: ", "Número"));
            media+=num[i];
        }
        media/=5;
        Arrays.sort(num);
        for (int i=4;i>=0;i--){
            janela+=String.valueOf(num[i])+"\n";
        }
        janela+="A média dos números é: "+media;
        JOptionPane.showMessageDialog(null, janela);

    }
}
