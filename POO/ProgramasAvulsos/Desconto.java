package Faculdade.POO.ProgramasAvulsos;
import javax.swing.JOptionPane;

public class Desconto {
    public static void main(String[] args) {
    
        String nome = (String) JOptionPane.showInputDialog(null, "Qual eh o Nome do produto? ", "Nome do produto");
        float valor_o = Float.parseFloat(JOptionPane.showInputDialog(null, "Qual eh o Valor do produto? ", "Valor do produto")) ;
        float valor_n=0;
        if(valor_o>=50 && valor_o<200){
            valor_n=valor_o-((valor_o*5)/100);
        }else if(valor_o>=200 && valor_o<500){
            valor_n=valor_o-((valor_o*6)/100);  
        }else if(valor_o>=500 && valor_o<1000){
            valor_n=valor_o-((valor_o*7)/100);  
        }else if(valor_o>=1000){
            valor_n=valor_o-((valor_o*8)/100);  
        }JOptionPane.showMessageDialog(null, "Nome do produto: "+nome+"\nValor original do produto: R$ "+valor_o+"\nValor do produto com desconto: R$ "+valor_n);
        

            }
}
