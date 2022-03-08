
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
import static proyecto1.Proyecto1.contlibros;
import static proyecto1.Proyecto1.contprestamos;
import static proyecto1.Proyecto1.contregistro;
import static proyecto1.Proyecto1.contusuario;
import static proyecto1.Proyecto1.oblibros;
import static proyecto1.Proyecto1.obpres;
import static proyecto1.Proyecto1.obreg;
import static proyecto1.Proyecto1.obuser;


public class Pestana_Reportes extends JPanel implements ActionListener{
    JLabel tiporep;
    JButton masiva3, generar;
    private final JComboBox<String> report;
    static JTable tablaregistro;
    static Object[][] datos;
    
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
        //cREACIÓN DE LA TABLA DE Reportes
        String[] titulo = {"Fecha de Generación", "Usuario", "Tipo de Reporte"};
        datos = mRegistro();
        tablaregistro = new JTable(datos, titulo);
        JScrollPane js = new JScrollPane(tablaregistro);
        js.setBounds(350, 10, 900, 600);
        this.add(js);    
        
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
    //******************************************************************************
    //FUNCIÓN PARA AÑADIR PRESTAMOS A LA TABLA
    public static Object[][] mRegistro() {
        Object[][] registro = new Object[contregistro][4];
        for (int i = 0; i < contregistro; i++) {
            if (obreg[i] != null) {
                registro[i][0] = obreg[i].getReporteUsuarios() ;
                registro[i][1] = obreg[i].getReporteLibrosReg();
                registro[i][2] = obreg[i].getReportesPrestrealizados();
            }
        }
        return registro;
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
    //METODO PARA CREAR PDF DE USUARIOS
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
                ObRegistros or = new ObRegistros(FECHA, ReporteU , "Reporte 1");
                crearreporte(or);
                
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //*****************************************************************************
    //MÉTODO PARA EL REPORTE DE LIBROS
    public void reporteL(){
        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;
        
        try {            
            nombreReporte = "RL.html"; //Nombre del archivo html
            reporte = new File(nombreReporte);
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);
            
            cadenaHTML = "<html>"
                    + "    <head>"
                    + "    <body>"
                    + "        <table border = 2>"
                    + "            <tr>"
                    + "                <td>Titulo</td>" //Esto es para el encabezado 
                    + "                <td>ID</td>"
                    + "                <td>Autor</td>"
                    + "                <td>Tipo</td>"
                    + "                <td>Copias</td>"
                    + "                <td>Disponibles</td>"
                    + "                <td>Ocupados</td>"
                    + "            </tr>";
                    
            
            for(int i = 0; i < contlibros; i++){ //MI CANTIDAD DE ARREGLO MI CONTADOR DE USUARIO
                if(oblibros[i] != null){ //Llamar arreglo 
                    cadenaHTML +=  "            <tr>"
                    + "                <td>" + oblibros[i].getTitulo() + "</td>" //llamamos lo que contiene la tabla
                    + "                <td>" + oblibros[i].getIDlibro() + "</td>"
                    + "                <td>" + oblibros[i].getAutor()+ "</td>"
                    + "                <td>" + oblibros[i].getTipos()+ "</td>"
                    + "                <td>" + oblibros[i].getCopias()+ "</td>"
                    + "                <td>" + oblibros[i].getDisponibles()+ "</td>"
                    + "                <td>" + oblibros[i].getOcupados()+ "</td>"
                    + "                </tr>";
                }
            }
            
            cadenaHTML += "        </table>"
                        + "    </body>"
                        + "</html>";
            
            br.write(cadenaHTML);
            
            br.close();
            fw.close();
            
            pdflibros(cadenaHTML);
            
        } catch (IOException ex) {
            System.out.println("error escribiendo el reporte. Detalles " + ex.getMessage());
        }
    }
    //**************************************************************************
    //METODO PARA CREAR PDF DE USUARIOS
    public void pdflibros(String html){
        try{ //E métodos para generar 3 reportes de arriba y abajo
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            String nombre = "reporteLibros_"+dtf.format(LocalDateTime.now());
            
                Document document = new Document(PageSize.LETTER);
                PdfWriter.getInstance(document, new FileOutputStream(nombre+".pdf"));

                document.open();
                document.addAuthor("Victor Rodriguez");
                document.addCreator("Victor Rodriguez");
                document.addSubject("reporteUsuarios");
                document.addCreationDate();
                document.addTitle("ReporteLibro");

                HTMLWorker htmlWorker = new HTMLWorker(document);
                htmlWorker.parse(new StringReader(html));

                document.close();
                DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String FECHA = dtf1.format(LocalDateTime.now());
                ObRegistros or = new ObRegistros(FECHA, ReporteU , "Reporte 2");
                crearreporte(or);
                
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //******************************************************************************
    //MÉTODO PARA EL REPORTE DE LIBROS
    public void reporteP(){
        String nombreReporte;
        File reporte;
        FileWriter fw;
        BufferedWriter br;
        String cadenaHTML;
        
        try {            
            nombreReporte = "RP.html"; //Nombre del archivo html
            reporte = new File(nombreReporte);
            fw = new FileWriter(reporte);
            br = new BufferedWriter(fw);
            
            cadenaHTML = "<html>"
                    + "    <head>"
                    + "    <body>"
                    + "        <table border = 2>"
                    + "            <tr>"
                    + "                <td>IDLibro</td>" //Esto es para el encabezado 
                    + "                <td>IDUsuario</td>"
                    + "                <td>FechaEntrega</td>"
                    + "            </tr>";
                    
            
            for(int i = 0; i < contprestamos; i++){ //MI CANTIDAD DE ARREGLO MI CONTADOR DE USUARIO
                if(obpres[i] != null){ //Llamar arreglo 
                    cadenaHTML +=  "            <tr>"
                    + "                <td>" + obpres[i].getIDlibro() + "</td>" //llamamos lo que contiene la tabla
                    + "                <td>" + obpres[i].getIDusuario() + "</td>"
                    + "                <td>" + obpres[i].getFechasinda()+ "</td>"
                    + "                </tr>";
                }
            }
            
            cadenaHTML += "        </table>"
                        + "    </body>"
                        + "</html>";
            
            br.write(cadenaHTML);
            
            br.close();
            fw.close();
            
            pdfprestamo(cadenaHTML);
            
        } catch (IOException ex) {
            System.out.println("error escribiendo el reporte. Detalles " + ex.getMessage());
        }
    }
      //**************************************************************************
    //METODO PARA CREAR PDF DE USUARIOS
    public void pdfprestamo(String html){
        try{ //E métodos para generar 3 reportes de arriba y abajo
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
            String nombre = "reportePrestamo_"+dtf.format(LocalDateTime.now());
            
                Document document = new Document(PageSize.LETTER);
                PdfWriter.getInstance(document, new FileOutputStream(nombre+".pdf"));

                document.open();
                document.addAuthor("Victor Rodriguez");
                document.addCreator("Victor Rodriguez");
                document.addSubject("reportePrestamo");
                document.addCreationDate();
                document.addTitle("ReportePrestamo");

                HTMLWorker htmlWorker = new HTMLWorker(document);
                htmlWorker.parse(new StringReader(html));

                document.close();
                DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String FECHA = dtf1.format(LocalDateTime.now());
                ObRegistros or = new ObRegistros(FECHA, ReporteU , "Reporte 3");
                crearreporte(or);
                
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //******************************************************************************
    //METODO PARA DARLE VIDA A LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generar) {
            if (report.getSelectedItem() == "Reporte de Usuario") {
                reporteu();
                JOptionPane.showMessageDialog(this, "El reporte de Usuario se realizao a la perfección");
            }else if (report.getSelectedItem() == "Reporte de Libros"){
                reporteL();
                JOptionPane.showMessageDialog(this, "El reporte de Libros se realizao a la perfección");
            } else if (report.getSelectedItem() == "Reporte de Prestamos"){
                reporteP();
                JOptionPane.showMessageDialog(this, "El reporte de Prestamos se realizao a la perfección");
            }
        }
    }
}
