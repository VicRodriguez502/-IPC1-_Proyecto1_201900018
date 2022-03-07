package Interfaz;

import Clases.ObPrestamos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
import static proyecto1.Proyecto1.contprestamos;
import static proyecto1.Proyecto1.oblibros;
import static proyecto1.Proyecto1.obpres;
import static proyecto1.Proyecto1.obuser;

public class Pestana_Prestamos extends JPanel implements ActionListener {

    // Variables para titulos, botones y cuadros de texto
    JLabel usuario, libro, fecha;
    JTextField idusu, idlb, idfecha;
    JButton prestar, masiva2;
    static JTable tablaPrestamo;
    static Object[][] datos1;

    //ATRIBUTOS Y VARIABLES PARA CREAR EL JSON Y CARGA MASIVA
    String contenido2 = "";
    File json2;
    FileReader lectura2;
    BufferedReader buff2;

    //Colores
    Color azulito = new Color(46, 64, 83);
    Color verdeclaro = new Color(130, 224, 170);
    Color azulejo = new Color(39, 55, 70);
    Color plateado = new Color(113, 125, 126);
    Color blanco = new Color(250, 250, 250);

    public Pestana_Prestamos() {

        //*************************************************************************
        //CREACIÓN DE TODOS LOS TITULOS
        //Creamos el titulo Usuario
        libro = new JLabel("ID Libro:");
        libro.setBounds(10, 50, 80, 20);
        libro.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        libro.setForeground(blanco);
        libro.setVisible(true);
        this.add(libro);

        //Creamos el titulo Libro
        fecha = new JLabel("Fecha Entrega:");
        fecha.setBounds(10, 90, 100, 20);
        fecha.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        fecha.setForeground(blanco);
        fecha.setVisible(true);
        this.add(fecha);

        //Creamos el titulo Usuario
        usuario = new JLabel("ID Usuario:");
        usuario.setBounds(10, 10, 80, 20);
        usuario.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        usuario.setForeground(blanco);
        usuario.setVisible(true);
        this.add(usuario);

        //************************************************************************
        //CREACIÓN TODOS LOS CUADROS DE TEXTO
        //Cuadro Texto para ingresar ID libro
        idusu = new JTextField();
        idusu.setBounds(120, 10, 200, 25);
        idusu.setFont(new Font("Verdana", Font.BOLD, 12));
        idusu.setVisible(true);
        this.add(idusu);

        //Cuadro Texto para ingresar ID libro
        idlb = new JTextField();
        idlb.setBounds(120, 50, 200, 25);
        idlb.setFont(new Font("Verdana", Font.BOLD, 12));
        idlb.setVisible(true);
        this.add(idlb);

        //Cuadro Texto para ingresar ID libro
        idfecha = new JTextField();
        idfecha.setBounds(120, 90, 200, 25);
        idfecha.setFont(new Font("Verdana", Font.BOLD, 12));
        idfecha.setVisible(true);
        this.add(idfecha);

        //*************************************************************************
        //CREACIÓN TODOS LSO BOTONES    
        //Creando botton para ingresar datos de libros
        prestar = new JButton("Prestar");
        prestar.setBounds(130, 120, 180, 25);
        prestar.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        prestar.setBackground(verdeclaro);
        prestar.setForeground(Color.black);
        prestar.setVisible(true);
        prestar.addActionListener(this);
        this.add(prestar);

        //Creamos el boton de carga masiva
        masiva2 = new JButton("Carga Masiva");
        masiva2.setBounds(10, 580, 150, 25);
        masiva2.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        masiva2.setBackground(azulejo);
        masiva2.setForeground(Color.white);
        masiva2.setVisible(true);
        masiva2.addActionListener(this);
        this.add(masiva2);

        //*************************************************************************
        //cREACIÓN DE LA TABLA DE PRESTAMOS
        String[] titulo ={"Nombre Usuario","Libro","Fecha de Entrega","Status"};
        datos1 = mPrestamo();
        tablaPrestamo = new JTable(datos1, titulo);
        JScrollPane js = new JScrollPane(tablaPrestamo);
        js.setBounds(350, 10, 900, 600);
        this.add(js);
        
        
        //**************************************************************************
        //CREACIÓN DE LA PESTAÑA PRESTAMOS    
        //Diseño de Jpanel
        this.setBackground(plateado);
        this.setLayout(null);
    }
    //*******************************************************************************
    //MÉTODO PARA CREAR 
    public static void crearprestamo(ObPrestamos nuevoP) {
        if (contprestamos < obpres.length) {
            obpres[contprestamos] = nuevoP;
            contprestamos++;
        }
    }
    
    //******************************************************************************
    //FUNCIÓN PARA AÑADIR PRESTAMOS A LA TABLA
    public static Object[][] mPrestamo(){
        Object[][] prestamo = new Object[contprestamos][4];
        for (int i = 0; i < contprestamos; i++) {
            if (obpres[i] != null) {
                prestamo[i][0] = obpres[i].getIDusuario();
                prestamo[i][1] = obpres[i].getIDlibro();
                prestamo[i][2] = obpres[i].getFechasinda();
                prestamo[i][3] = obpres[i].getStatus();
            }
        }
        return prestamo;
    }

    //MÉTODO YA CREADO POR JAVA PARA ABRIR UNA VENTANA EMERGENTE PARA SUBIDA DE DATOS
    //se modificara para poder leer un archivo json
    public void leerarchivos() {
        try {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                json2 = fc.getSelectedFile();
            } else {
                System.out.println("No abriste nada");
            }
            lectura2 = new FileReader(json2); //Obtendremos el texto 
            buff2 = new BufferedReader(lectura2); //leera el texto
            String casilla2;
            //Lo siguiente se leera linea a linea
            while ((casilla2 = buff2.readLine()) != null) {
                contenido2 += casilla2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != lectura2) {
                    lectura2.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == masiva2) {
            System.out.println("Carga de archivo Json");
            leerarchivos();
            System.out.println(contenido2);
            
            
        //**************************************************************************
        //PARA DARLE VIDA AL BOTON PRESTAR
        }else if (ae.getSource() == prestar){
            int IDL = Integer.parseInt(idusu.getText());
            int idu = Integer.parseInt(idlb.getText());
            String fechita = idfecha.getText();
            ObPrestamos op = new ObPrestamos(IDL,idu,fechita,"Prestado");
            crearprestamo(op);
            idusu.setText("");
            idlb.setText("");
            idfecha.setText(""); 
        }
    }
}
   