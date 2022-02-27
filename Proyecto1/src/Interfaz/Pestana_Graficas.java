
package Interfaz;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Pestana_Graficas extends JPanel {
    JLabel gusu, glib, glibreg;
            
    //Colores
    Color azulito = new Color(46, 64, 83);
    Color verdeclaro = new Color(130, 224, 170);
    Color azulejo = new Color(39, 55, 70);
    Color plateado = new Color(113, 125, 126);
    Color blanco = new Color(250, 250, 250);
    
    public Pestana_Graficas(){
    //Creando titulo de gráfica de tipo de usuarios
        gusu = new JLabel("Tipo de Usuario Registrado");
        gusu.setBounds(30,10,300,20);
        gusu.setFont(new Font("Arial Narrow", Font.BOLD,16));
        gusu.setForeground(blanco);
        gusu.setVisible(true);
        this.add(gusu);
    
    //Creando titulo de gráfica de cantidad de libros
        glib = new JLabel("Cantidad de Libros prestados");
        glib.setBounds(450,580,300,20);
        glib.setFont(new Font("Arial Narrow", Font.BOLD,16));
        glib.setForeground(blanco);
        glib.setVisible(true);
        this.add(glib);
        
    //Creando titulo de libros registrados    
        glibreg = new JLabel("Tipo de Libro registrado");
        glibreg.setBounds(1000,10,300,20);
        glibreg.setFont(new Font("Arial Narrow", Font.BOLD,16));
        glibreg.setForeground(blanco);
        glibreg.setVisible(true);
        this.add(glibreg);    
    
    //Diseño de Jpanel
        this.setBackground(plateado);
        this.setLayout(null);
    }
}
