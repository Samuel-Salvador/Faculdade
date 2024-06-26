package Faculdade.POO.ProgramasAvulsos;
import javax.swing.JOptionPane;
public class Resistencias {
    public static void main(String[] args) {
        int r1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual eh o Valor do r1? ", "Valor r1")) ;
        int r2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual eh o Valor do r2? ", "Valor r2")) ;
        int r3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual eh o Valor do r3? ", "Valor r3")) ;
        int r4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual eh o Valor do r4? ", "Valor r4")) ;
        int menor,maior; 
        if(r1<r2&&r1<r3&&r1<r4){
            menor=r1;
        }else if(r2<r3&&r2<r4){
            menor=r2;  
        }else if(r3<r4){
            menor=r3;  
        }else{
            menor=r4;
        }
        if(r1>r2&&r1>r3&&r1>r4){
            maior=r1;
        }else if(r2>r3&&r2>r4){
            maior=r2;  
        }else if(r3>r4){
            maior=r3;  
        }else{
            maior=r4;
        }
        JOptionPane.showMessageDialog(null, "Resistencias fornecidas:\n"+r1+", "+r2+", "+r3+", "+r4+"\nA maior resistencia eh: "+maior+"\nA menor resistencia eh: "+menor);
        
    }
}
