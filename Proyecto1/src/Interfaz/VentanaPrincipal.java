package Interfaz;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame{
    private JPanel pestañita;
    
    Color azulito = new Color(46, 64, 83);
    Color verdeclaro = new Color(130, 224, 170);
    Color azulejo = new Color(39, 55, 70);
    Color plateado = new Color(113, 125, 126);
    
    public VentanaPrincipal(){
        
        //Creación de pestañita para un borde bonito
        pestañita = new JPanel();
        pestañita.setBorder(new EmptyBorder(5,25,5,5));
        setContentPane(pestañita);
        pestañita.setLayout(null);
        
        //Creamos la configuracion de Jpanel para poder colocar las pestañas 
        JTabbedPane xx = new JTabbedPane(JTabbedPane.TOP);
        xx.setBounds(10,11,1290,650);
        xx.setBackground(Color.green);
        xx.setForeground(Color.BLACK);
        xx.setFont(new Font("Arial Narrow", Font.PLAIN,16));
        pestañita.add(xx);
        
        //Mandamos a llamar la pestaña Libros
        Pestana_Libro pl = new Pestana_Libro();
        xx.addTab("Libros", null, pl,null);
        
        //DISEÑO DE LA VENTANA
        this.setTitle("Administrador | Biblioteca MS©");
        this.setBounds(20,20,1340,730);
        this.getContentPane().setBackground(azulejo);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
