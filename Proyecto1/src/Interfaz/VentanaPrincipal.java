package Interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame implements ActionListener{
    private JPanel pestañita;
    JButton masiva1;
    
    Color azulito = new Color(46, 64, 83);
    Color rojo = new Color(33, 33, 33);
    Color azulejo = new Color(39, 55, 70);
    Color plateado = new Color(113, 125, 126);
    
    public VentanaPrincipal() {
        
        
        
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
    
    setIconImage(new ImageIcon(getClass().getResource("Logo png msc.png")).getImage());
     //Creamos el boton de carga masiva
        masiva1 = new JButton("Actualizar");
        masiva1.setBounds(500, 0, 150, 25);
        masiva1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        masiva1.setBackground(azulito);
        masiva1.setForeground(Color.white);
        masiva1.setVisible(true);
        masiva1.addActionListener(this);
        this.add(masiva1);
    
        //DISEÑO DE LA VENTANA
        this.setTitle("Administrador | Biblioteca MS©");
        this.setBounds(20,20,1340,730);
        this.getContentPane().setBackground(rojo);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == masiva1) {
            VentanaPrincipal v = new VentanaPrincipal ();
            this.dispose();
        }
    }
    
}
