
package Interfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Pestana_Libro extends JFrame implements ActionListener{
    JLabel idl, namel, autor, codigo, tipo;
    JTextField lib, nombrel, autor1, cod, tip;
    JButton ingresar, masiva1;
    Color azulito = new Color(46, 64, 83);
    Color verdeclaro = new Color(130, 224, 170);
    Color azulejo = new Color(39, 55, 70);
    
    public Pestana_Libro(){
    //Creando boton para carga masiva
    //Creamos el boton de carga masiva
        masiva1 = new JButton("Carga Masiva");
        masiva1.setBounds(10,600,180,25);
        masiva1.setFont(new Font("Franklin Gothic Medium", Font.BOLD,14));
        masiva1.setBackground(azulejo);
        masiva1.setForeground(Color.white);
        masiva1.setVisible(true);
        masiva1.addActionListener(this);
        this.add(masiva1);    
        
    //Creando botton para ingresar datos de libros
    ingresar = new JButton("Registro Libro");
        ingresar.setBounds(70,210,180,25);
        ingresar.setFont(new Font("Franklin Gothic Medium", Font.BOLD,14));
        ingresar.setBackground(verdeclaro);
        ingresar.setForeground(Color.black);
        ingresar.setVisible(true);
        ingresar.addActionListener(this);
        this.add(ingresar);    
        
    //Cuadro Texto para ingresar tipo
        tip = new JTextField();
        tip.setBounds(70,170,200,25);
        tip.setFont(new Font("Verdana", Font.BOLD,12));
        tip.setVisible(true);
        this.add(tip);    
        
    //Cuadro Texto para ingresar codigo
        cod = new JTextField();
        cod.setBounds(70,130,200,25);
        cod.setFont(new Font("Verdana", Font.BOLD,12));
        cod.setVisible(true);
        this.add(cod);   
        
    //Cuadro Texto para ingresar autor
        autor1 = new JTextField();
        autor1.setBounds(70,90,200,25);
        autor1.setFont(new Font("Verdana", Font.BOLD,12));
        autor1.setVisible(true);
        this.add(autor1); 
        
    //Cuadro Texto para ingresar nombre libro
        nombrel = new JTextField();
        nombrel.setBounds(70,50,200,25);
        nombrel.setFont(new Font("Verdana", Font.BOLD,12));
        nombrel.setVisible(true);
        this.add(nombrel);    
        
    //Cuadro Texto para ingresar ID libro
        lib = new JTextField();
        lib.setBounds(70,10,200,25);
        lib.setFont(new Font("Verdana", Font.BOLD,12));
        lib.setVisible(true);
        this.add(lib);
     
    //Creamos el titulo tipo
    tipo = new JLabel("Tipo:");
        tipo.setBounds(10,170,80,20);
        tipo.setFont(new Font("Arial Narrow", Font.BOLD,16));
        tipo.setForeground(azulito);
        tipo.setVisible(true);
        this.add(tipo);
        
    //Creamos el titulo código   
    codigo = new JLabel("Código:");
        codigo.setBounds(10,130,80,20);
        codigo.setFont(new Font("Arial Narrow", Font.BOLD,16));
        codigo.setForeground(azulito);
        codigo.setVisible(true);
        this.add(codigo);
   
    //Creamos el titulo autor
    autor = new JLabel("Autor:");
        autor.setBounds(10,90,80,20);
        autor.setFont(new Font("Arial Narrow", Font.BOLD,16));
        autor.setForeground(azulito);
        autor.setVisible(true);
        this.add(autor);
        
    //Creamos el titulo Nombre de libro 
        namel = new JLabel("Libro:");
        namel.setBounds(10,50,80,20);
        namel.setFont(new Font("Arial Narrow", Font.BOLD,16));
        namel.setForeground(azulito);
        namel.setVisible(true);
        this.add(namel);
        
    //Creamos el titulo ID libro
        idl = new JLabel("ID Libro:");
        idl.setBounds(10,10,80,20);
        idl.setFont(new Font("Arial Narrow", Font.BOLD,16));
        idl.setForeground(azulito);
        idl.setVisible(true);
        this.add(idl);
    
     //creación de la ventana de pestaña de libro
        this.setTitle("Libros");
        this.setLayout(null);
        this.setBounds(500, 150, 1000, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
