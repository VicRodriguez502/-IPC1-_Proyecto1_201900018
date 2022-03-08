
package Interfaz;
import Clases.ObRegistros;
import static Interfaz.Pantalla_login.ReporteU;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import static proyecto1.Proyecto1.contregistro;
import static proyecto1.Proyecto1.contusuario;
import static proyecto1.Proyecto1.obreg;
import static proyecto1.Proyecto1.obuser;


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
    //*******************************************************************************
    //METODO PARA AÑADIR EL ARREGLO DE USUARIOS
    public static void crearreporte(ObRegistros registro) {
        if (contregistro < obreg.length) {
            obreg[contregistro] = registro;
            contregistro++;
        }
    }
    
    //*****************************************************************************
    //MÉTODO PARA EL REPORTE DE USUARIOS
    public void reporteu(){
        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;
        
        try {            
            nombreReporte = "RU.html"; //Nombre del archivo html
            reporte = new File(nombreReporte);
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);
            
            cadenaHTML = "<html>"
                    + "    <head>"
                    + "    <body>"
                    + "        <table border = 2>"
                    + "            <tr>"
                    + "                <td>ID</td>" //Esto es para el encabezado 
                    + "                <td>Usuario</td>"
                    + "                <td>Password</td>"
                    + "                <td>Facultad</td>"
                    + "                <td>Carrera</td>"
                    + "                <td>Tipo</td>"
                    + "            </tr>";
                    
            
            for(int i = 0; i < contusuario; i++){ //MI CANTIDAD DE ARREGLO MI CONTADOR DE USUARIO
                if(obuser[i] != null){ //Llamar arreglo 
                    cadenaHTML +=  "            <tr>"
                    + "                <td>" + obuser[i].getID() + "</td>" //llamamos lo que contiene la tabla
                    + "                <td>" + obuser[i].getUsuario() + "</td>"
                    + "                <td>" + obuser[i].getPassword()+ "</td>"
                    + "                <td>" + obuser[i].getFacultad()+ "</td>"
                    + "                <td>" + obuser[i].getCarrera()+ "</td>"
                    + "                <td>" + obuser[i].getTipo()+ "</td>"
                   
                    + "            </tr>";
                }
            }
            
            cadenaHTML += "        </table>"
                        + "    </body>"
                        + "</html>";
            
            br.write(cadenaHTML);
            
            br.close();
            fw.close();
            
            pdfusuario(cadenaHTML);
            
        } catch (IOException ex) {
            System.out.println("error escribiendo el reporte. Detalles " + ex.getMessage());
        }
    }
    
    
    //**************************************************************************
    //metodo para usuarios
    public void pdfusuario(String html){
        try{ //E métodos para generar 3 reportes de arriba y abajo
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            String nombre = "reporteUsuarios_"+dtf.format(LocalDateTime.now());
            
                Document document = new Document(PageSize.LETTER);
                PdfWriter.getInstance(document, new FileOutputStream(nombre+".pdf"));

                document.open();
                document.addAuthor("Victor Rodriguez");
                document.addCreator("Victor Rodriguez");
                document.addSubject("reporteUsuarios");
                document.addCreationDate();
                document.addTitle("ReporteUsuario");

                HTMLWorker htmlWorker = new HTMLWorker(document);
                htmlWorker.parse(new StringReader(html));

                document.close();
                DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String FECHA = dtf1.format(LocalDateTime.now());
                //ObRegistros or = new ObRegistros(FECHA, ReporteU , "Reporte 1");
                //crearreporte(or);
                //Tengo que crear mi tablita de reportes se hace arribita
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generar) {
            if (report.getSelectedItem() == "Reporte de Usuario") {
                reporteu();
                JOptionPane.showMessageDialog(this, "El reporte de Usuario se realizao a la perfección");
            }
        }
    }
}
