
import javax.swing.JFrame;
public class CarregaFrame2 {
    public static void main(String[] args){
        JFrame frame = new JFrame ("Uso de Diálogo de Informação");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiGridLayout1());
        frame.setBounds(0,0,500,300);
        frame.setVisible (true);
    }
}