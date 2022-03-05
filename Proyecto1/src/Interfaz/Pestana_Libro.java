package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
import Clases.ObLibros;
import static proyecto1.Proyecto1.contlibros;
import static proyecto1.Proyecto1.oblibros;

public class Pestana_Libro extends JPanel implements ActionListener {

    //Variables para titulos, botones, cuadros de texto
    JLabel idl, namel, autor, codigo, tipo;
    JTextField lib, nombrel, autor1, cop;
    JButton ingresar, masiva1;
    static JTable tablalibros;
    static Object[][] datos;
    private final JComboBox<String> tip;

    //ATRIBUROS PARA LA CARGA DE ARCHIVOS JSON
    String contenido = "";
    File json;
    FileReader lectura;
    BufferedReader buff;

    //Colores
    Color azulito = new Color(46, 64, 83);
    Color verdeclaro = new Color(130, 224, 170);
    Color azulejo = new Color(39, 55, 70);
    Color plateado = new Color(113, 125, 126);
    Color blanco = new Color(250, 250, 250);

    //Constructor para la pestaña de libros
    public Pestana_Libro() {

        //************************************************************************
        //CREACIÓN TODOS LOS BOTONES
        //Creamos el boton de carga masiva
        masiva1 = new JButton("Carga Masiva");
        masiva1.setBounds(10, 580, 150, 25);
        masiva1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        masiva1.setBackground(azulejo);
        masiva1.setForeground(Color.white);
        masiva1.setVisible(true);
        masiva1.addActionListener(this);
        this.add(masiva1);

        //Creando botton para ingresar datos de libros
        ingresar = new JButton("Registro Libro");
        ingresar.setBounds(70, 210, 180, 25);
        ingresar.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        ingresar.setBackground(verdeclaro);
        ingresar.setForeground(Color.black);
        ingresar.setVisible(true);
        ingresar.addActionListener(this);
        this.add(ingresar);

        //*************************************************************************
        //CREACIÓN TODOS LOS CUADROS DE TEXTO    
        //Cuadro Texto para ingresar tipo
        setLayout(null);
        tip = new JComboBox<String>();
        tip.setBounds(70, 170, 200, 25);
        tip.setFont(new Font("Verdana", Font.BOLD, 12));
        add(tip);
        tip.addItem("Libro");
        tip.addItem("Revista");
        tip.addItem("Libro Electrónico");
        tip.addActionListener(this);

        //Cuadro Texto para ingresar codigo
        cop = new JTextField();
        cop.setBounds(70, 130, 200, 25);
        cop.setFont(new Font("Verdana", Font.BOLD, 12));
        cop.setVisible(true);
        this.add(cop);

        //Cuadro Texto para ingresar autor
        autor1 = new JTextField();
        autor1.setBounds(70, 90, 200, 25);
        autor1.setFont(new Font("Verdana", Font.BOLD, 12));
        autor1.setVisible(true);
        this.add(autor1);

        //Cuadro Texto para ingresar nombre libro
        nombrel = new JTextField();
        nombrel.setBounds(70, 50, 200, 25);
        nombrel.setFont(new Font("Verdana", Font.BOLD, 12));
        nombrel.setVisible(true);
        this.add(nombrel);

        //Cuadro Texto para ingresar ID libro
        lib = new JTextField();
        lib.setBounds(70, 10, 200, 25);
        lib.setFont(new Font("Verdana", Font.BOLD, 12));
        lib.setVisible(true);
        this.add(lib);

        //*************************************************************************
        //CREACIÓN TODOS LOS TITULOS    
        //Creamos el titulo tipo
        tipo = new JLabel("Tipo:");
        tipo.setBounds(10, 170, 80, 20);
        tipo.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        tipo.setForeground(blanco);
        tipo.setVisible(true);
        this.add(tipo);

        //Creamos el titulo código   
        codigo = new JLabel("Copias:");
        codigo.setBounds(10, 130, 80, 20);
        codigo.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        codigo.setForeground(blanco);
        codigo.setVisible(true);
        this.add(codigo);

        //Creamos el titulo autor
        autor = new JLabel("Autor:");
        autor.setBounds(10, 90, 80, 20);
        autor.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        autor.setForeground(blanco);
        autor.setVisible(true);
        this.add(autor);

        //Creamos el titulo Nombre de libro 
        namel = new JLabel("Libro:");
        namel.setBounds(10, 50, 80, 20);
        namel.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        namel.setForeground(blanco);
        namel.setVisible(true);
        this.add(namel);

        //Creamos el titulo ID libro
        idl = new JLabel("ID Libro:");
        idl.setBounds(10, 10, 80, 20);
        idl.setFont(new Font("Arial Narrow", Font.BOLD, 16));
        idl.setForeground(blanco);
        idl.setVisible(true);
        this.add(idl);

        //CREACION DE TABLA
        String[] cabeza = {"ID Libro", "Nombre Libro", "Autor", "tipo", "Copias", "Disponibles", "Ocupados"}; //Arreglo del encabezado
        datos = mlibro();
        tablalibros = new JTable(datos, cabeza);
        JScrollPane js = new JScrollPane(tablalibros);
        js.setBounds(300, 10, 950, 600);
        this.add(js);

        //************************************************************************
        //CREACIÓN DE LA PESTAÑA LIBRO
        //Diseño de Jpanel
        this.setBackground(plateado);
        this.setLayout(null);

    }
    //MÉTODO PARA AÑADIR EL ARREGLO DE LIBROS
    public static void crearlib(ObLibros nuevoL) {
        if (contlibros < oblibros.length) {
            oblibros[contlibros] = nuevoL;
            contlibros++;
        }
    }
    public static Object[][] mlibro() {
        Object[][] libros = new Object[contlibros][7];
        for (int i = 0; i < contlibros; i++) {
            if (oblibros[i] != null) {
                libros[i][0] = oblibros[i].getIDlibro();
                libros[i][1] = oblibros[i].getTitulo();
                libros[i][2] = oblibros[i].getAutor();
              //  libros[i][3] = oblibros[i].getTipos();
                if (oblibros[i].getTipos() == 1) {
                    libros[i][3] = "Libro";
                                          
                }else if (oblibros[i].getTipos() == 2){
                    libros[i][3] = "Revista";
                }else if (oblibros[i].getTipos() == 3){
                    libros[i][3] = "Libro Electronico";
                }
                libros[i][4] = oblibros[i].getCopias();
                libros[i][5] = oblibros[i].getDisponibles();
                libros[i][6] = oblibros[i].getOcupados();
            }
        }
        return libros;
    }

    //MÉTODO YA CREADO POR JAVA PARA ABRIR UNA VENTANA EMERGENTE PARA SUBIDA DE DATOS
    //se modificara para poder leer un archivo json
    public void leerarchivos() {
        try {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                json = fc.getSelectedFile();
            } else {
                System.out.println("No abriste nada");
            }
            lectura = new FileReader(json); //Obtendremos el texto 
            buff = new BufferedReader(lectura); //leera el texto
            String casilla;
            //Lo siguiente se leera linea a linea
            while ((casilla = buff.readLine()) != null) {
                contenido += casilla;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != lectura) {
                    lectura.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    @Override
    //se le dio vida al boton de carga masiva 1
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == masiva1) {
            System.out.println("Carga de archivo Json");
            leerarchivos();
            System.out.println(contenido);
        } else if (ae.getSource() == ingresar) { //Esto es para darle vida al boton ingresar
            int ID = Integer.parseInt(lib.getText());
            String Nom = nombrel.getText();
            String aut = autor1.getText();
            int c = Integer.parseInt(cop.getText());
            int t = 0;
            if (tip.getSelectedItem() == "Libro") {
                t = 1;
            } else if (tip.getSelectedItem() == "Revista") {
                t = 2;
            } else if (tip.getSelectedItem() == "Libro Electrónico") {
                t = 3;
            }
            ObLibros ob = new ObLibros(ID,Nom, aut, t, c, 1, 0);
            crearlib(ob);
            lib.setText("");
            nombrel.setText("");
            autor1.setText("");
            cop.setText("");
        }

    }
}

//JTextField lib, nombrel, autor1, cod;
/*"Libros");
        tip.addItem("Revistas");
        tip.addItem("Libros Electrónicos");
 */
