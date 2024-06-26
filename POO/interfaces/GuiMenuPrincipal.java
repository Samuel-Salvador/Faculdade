import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class GuiMenuPrincipal extends JFrame {
    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos;
    private JMenuItem miSair, miBotao, miCursos, miRadio;

    public GuiMenuPrincipal() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic ('A') ;
        mnExemplos = new JMenu("Exemplos");
        mnExemplos.setMnemonic('E');
		URL urlSair = getClass().getResource("sair.jpg");
		URL urlBotao = getClass().getResource("botao.jpg");
		URL urlCursos = getClass().getResource("cursos.jpg");
        miSair = new JMenuItem("Sair", new ImageIcon(urlSair));
        miSair.setAccelerator (KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        miBotao = new JMenuItem("Botão", new ImageIcon(urlBotao));
		miCursos = new JMenuItem("Cursos",new ImageIcon(urlCursos));
		miRadio = new JMenuItem("Radio",new ImageIcon(urlCursos));
        mnArquivo.add(miSair);
        mnExemplos.add (miBotao);
		mnExemplos.add(miCursos);
		mnExemplos.add(miRadio);

        mnBarra.add (mnArquivo);
        mnBarra.add(mnExemplos);
        setJMenuBar (mnBarra);
    }

    private void definirEventos() {
        miSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        miBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiBotao botao = new GuiBotao();
                contentPane.removeAll();
                contentPane.add(botao);
                contentPane.validate();
            }
        });

		miCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiCaixaOpcao cursos = new GuiCaixaOpcao();
                contentPane.removeAll();
                contentPane.add(cursos);
                contentPane.validate();
            }
        });
		
		miRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiRadio radio = new GuiRadio();
                contentPane.removeAll();
                contentPane.add(radio);
                contentPane.validate();
            }
        });
    }

    public static void abrir () {
        GuiMenuPrincipal frame = new GuiMenuPrincipal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((tela.width - frame.getSize().width) / 2,
                (tela.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }
}