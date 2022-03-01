
package Interfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class Pestana_Reportes extends JPanel implements ActionListener{
    JLabel tiporep;
    JButton masiva3, generar;
    private final JComboBox<String> report;
    
    //Colores
    Color azulito = new Color(46, 64, 83);
    Color verdeclaro = new Color(130, 224, 170);
    Color azulejo = new Color(155, 89, 182);
    Color plateado = new Color(113, 125, 126);
    Color blanco = new Color(250, 250, 250);
    Color rojo = new Color(102, 255, 0);
    
    public Pestana_Reportes(){
        
    //*************************************************************************
    //CREACIÓN TODOS LOS TITULOS
    
        //Creamos el titulo de Tipo de Reporte
        tiporep = new JLabel("Tipo de Reporte:");
        tiporep.setBounds(10,10,120,20);
        tiporep.setFont(new Font("Arial Narrow", Font.BOLD,16));
        tiporep.setForeground(blanco);
        tiporep.setVisible(true);
        this.add(tiporep);
        
    //*************************************************************************    
    //CREACIÓN TODOS LOS CUADROS DE TEXTO
    
        //Creando el cuadro para escoger el tipo de reporte
        setLayout(null);
        report =new JComboBox<String>();
        report.setBounds(130,10,160,20);
        report.setFont(new Font("Verdana", Font.BOLD,12));
        add(report);
        report.addItem("Reporte de Usuario");
        report.addItem("Reporte de Libros");
        report.addItem("Reporte de pestamos");
        report.addActionListener(this);  
        
    //*************************************************************************
    //CREACIÓN TODOS LOS BOTONES    
        
        //Creando el boton de generar 
        generar = new JButton("Generar");
        generar.setBounds(130,40,160,25);
        generar.setFont(new Font("Franklin Gothic Medium", Font.BOLD,14));
        generar.setBackground(verdeclaro);
        generar.setForeground(Color.black);
        generar.setVisible(true);
        generar.addActionListener(this);
        this.add(generar);  
        
    //*************************************************************************
    //CREACIÓN DE PESTAÑA REPORTE    
        
        //Diseño de Jpanel
        this.setBackground(plateado);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
