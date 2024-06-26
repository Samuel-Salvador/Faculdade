package Faculdade.POO.ProgramasAvulsos;
import javax.swing.JOptionPane;
public class todosJuntos {
public static void main(String[] args) {
    String escolha=(String)JOptionPane.showInputDialog("1- Exercício 1\n2- Exercício 2\n3- Exercício 3\n4- Exercício 4");
    if(escolha.equals("1")){
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
    if(escolha.equals("2")){
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
    if(escolha.equals("3")){
        String login = (String)JOptionPane.showInputDialog(null, "Forneça um login: ", "login") ;
        String senha = (String)JOptionPane.showInputDialog(null, "Forneça uma senha: ", "senha") ; 
        for(int i=0;i<=2;i++){
            if(login.equals("java8") && senha.equals("java8")){
                JOptionPane.showMessageDialog(null, "Login e senha aceitos!");
                break;
        }
            else if(i<2)
            {
                JOptionPane.showMessageDialog(null, "Falha, verifique login e senha!\nVocê tem mais "+(2-i)+" tentativas");
                login = (String)JOptionPane.showInputDialog(null, "Forneça um login: ", "login") ;
                senha = (String)JOptionPane.showInputDialog(null, "Forneça uma senha: ", "senha") ; 
        
        }else if(i==2){
            JOptionPane.showMessageDialog(null, "Falha, você não tem mais tentativas");
        }
        }
    }
    if(escolha.equals("4")){
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneça um numero: ", "numero"));
        String janela="";
        for(int i=0;i<=10;i++){
            int res= n*i;
    
            janela=janela+"\n"+String.valueOf(n)+" x "+String.valueOf(i)+" = "+String.valueOf(res);
            }
            JOptionPane.showMessageDialog(null, janela);
    
    }
}
}
