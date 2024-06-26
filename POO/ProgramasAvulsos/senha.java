package Faculdade.POO.ProgramasAvulsos;
import javax.swing.JOptionPane;
public class senha {
    public static void main(String[] args) {
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
}
