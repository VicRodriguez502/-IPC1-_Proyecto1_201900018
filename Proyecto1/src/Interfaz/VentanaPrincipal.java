package Interfaz;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame{
    private JPanel pestañita;
    
    Color azulito = new Color(46, 64, 83);
    Color rojo = new Color(33, 33, 33);
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
        xx.setBackground(Color.ORANGE);
        xx.setForeground(Color.BLACK);
        xx.setFont(new Font("Arial Narrow", Font.PLAIN,16));
        pestañita.add(xx);
        
    //*************************************************************************
    //FORMATO PARA LLAMAR TODAS LAS PESTAÑAS A LA VENTANA PRINCIPAL     
        
        //Mandamos a llamar la pestaña Libros
        Pestana_Libro pl = new Pestana_Libro();
        xx.addTab("Libros", null, pl,null);
        
        //Mandamos a llamar la pestaña Prestamos
        Pestana_Prestamos pp = new Pestana_Prestamos();
        xx.addTab("Prestamos", null, pp,null);
        
        //Mandamos a llamar la pestaña de Reportes
        Pestana_Reportes pr = new Pestana_Reportes();
        xx.addTab("Reportes", null, pr,null);
        
        //Mandamos a llamar la pestaña de Graficas 
        Pestana_Graficas pg = new Pestana_Graficas();
        xx.addTab("Gráficas", null, pg,null);
        
        
    //*************************************************************************
    //CREACIÓN DE LA VENTANA PRINCIPAL

    
        //DISEÑO DE LA VENTANA
        this.setTitle("Administrador | Biblioteca MS©");
        this.setBounds(20,20,1340,730);
        this.getContentPane().setBackground(rojo);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
