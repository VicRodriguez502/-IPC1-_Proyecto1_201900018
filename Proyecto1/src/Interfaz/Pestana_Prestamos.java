package Interfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Pestana_Prestamos extends JPanel implements ActionListener{
    // Variables para titulos, botones y cuadros de texto
    JLabel usuario, libro, fecha;
    JTextField idusu, idlb, idfecha;
    JButton prestar, masiva2;
    
    //Colores
    Color azulito = new Color(46, 64, 83);
    Color verdeclaro = new Color(130, 224, 170);
    Color azulejo = new Color(39, 55, 70);
    Color plateado = new Color(113, 125, 126);
    Color blanco = new Color(250, 250, 250);
    
    public Pestana_Prestamos(){
        //Creamos el titulo Usuario
        libro = new JLabel("ID Libro:");
        libro.setBounds(10,50,80,20);
        libro.setFont(new Font("Arial Narrow", Font.BOLD,16));
        libro.setForeground(blanco);
        libro.setVisible(true);
        this.add(libro);
        
        //Creamos el titulo Libro
        fecha = new JLabel("Fecha Entrega:");
        fecha.setBounds(10,90,100,20);
        fecha.setFont(new Font("Arial Narrow", Font.BOLD,16));
        fecha.setForeground(blanco);
        fecha.setVisible(true);
        this.add(fecha);
        
        //Creamos el titulo Usuario
        usuario = new JLabel("ID Usuario:");
        usuario.setBounds(10,10,80,20);
        usuario.setFont(new Font("Arial Narrow", Font.BOLD,16));
        usuario.setForeground(blanco);
        usuario.setVisible(true);
        this.add(usuario);
        
        //Cuadro Texto para ingresar ID libro
        idusu = new JTextField();
        idusu.setBounds(120,10,200,25);
        idusu.setFont(new Font("Verdana", Font.BOLD,12));
        idusu.setVisible(true);
        this.add(idusu);
        
        //Cuadro Texto para ingresar ID libro
        idlb = new JTextField();
        idlb.setBounds(120,50,200,25);
        idlb.setFont(new Font("Verdana", Font.BOLD,12));
        idlb.setVisible(true);
        this.add(idlb);
        
        //Cuadro Texto para ingresar ID libro
        idfecha = new JTextField();
        idfecha.setBounds(120,90,200,25);
        idfecha.setFont(new Font("Verdana", Font.BOLD,12));
        idfecha.setVisible(true);
        this.add(idfecha);
        
        //Creando botton para ingresar datos de libros
        prestar = new JButton("Prestar");
        prestar.setBounds(130,120,180,25);
        prestar.setFont(new Font("Franklin Gothic Medium", Font.BOLD,14));
        prestar.setBackground(verdeclaro);
        prestar.setForeground(Color.black);
        prestar.setVisible(true);
        prestar.addActionListener(this);
        this.add(prestar); 
        
        //Creamos el boton de carga masiva
        masiva2 = new JButton("Carga Masiva");
        masiva2.setBounds(10,580,150,25);
        masiva2.setFont(new Font("Franklin Gothic Medium", Font.BOLD,14));
        masiva2.setBackground(azulejo);
        masiva2.setForeground(Color.white);
        masiva2.setVisible(true);
        masiva2.addActionListener(this);
        this.add(masiva2); 
        
        //Diseño de Jpanel
        this.setBackground(plateado);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    }
    

