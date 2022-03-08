package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import javax.swing.*;
import Clases.ObLibros;
import static Interfaz.Pestana_Libro.mlibro;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import static proyecto1.Proyecto1.contlibros;
import static proyecto1.Proyecto1.oblibros;

public class Pestana_Libro extends JPanel implements ActionListener {

    //Variables para titulos, botones, cuadros de texto
    JLabel idl, namel, autor, codigo, tipo;
    JTextField lib, nombrel, autor1, cop;
    JButton ingresar, masiva1;
    JTextArea info;
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
        
        //Creando cuadro de texto para poner los datos del json
        JTextArea info = new JTextArea( "{\n" +
"	\"Libros\":[\n" +
"		{\n" +
"			\"Titulo\": \"titulo libro\",\n" +
"			\"ID\": 1,\n" +
"			\"Autor\":  \"USAC\",\n" +
"			\"Tipo\": 1,\n" +
"			\"Copias\": 60,\n" +
"			\"Disponibles\": 50,\n" +
"			\"Ocupados\": 10\n" +
"		},\n" +
"		{\n" +
"			\"Titulo\": \"titulo libro\",\n" +
"			\"ID\": 2,\n" +
"			\"Autor\":  \"USAC\",\n" +
"			\"Tipo\": 1,\n" +
"			\"Copias\": 60,\n" +
"			\"Disponibles\": 50,\n" +
"			\"Ocupados\": 10\n" +
"		},\n" +
"		{\n" +
"			\"Titulo\": \"titulo libro\",\n" +
"			\"ID\": 3,\n" +
"			\"Autor\":  \"USAC\",\n" +
"			\"Tipo\": 1,\n" +
"			\"Copias\": 60,\n" +
"			\"Disponibles\": 50,\n" +
"			\"Ocupados\": 10\n" +
"		},\n" +
"		{\n" +
"			\"Titulo\": \"titulo libro\",\n" +
"			\"ID\": 4,\n" +
"			\"Autor\":  \"USAC\",\n" +
"			\"Tipo\": 1,\n" +
"			\"Copias\": 60,\n" +
"			\"Disponibles\": 50,\n" +
"			\"Ocupados\": 10\n" +
"		},\n" +
"		{\n" +
"			\"Titulo\": \"titulo libro\",\n" +
"			\"ID\": 5,\n" +
"			\"Autor\":  \"USAC\",\n" +
"			\"Tipo\": 1,\n" +
"			\"Copias\": 60,\n" +
"			\"Disponibles\": 50,\n" +
"			\"Ocupados\": 10\n" +
"		}"
                + "	]\n" +
"}" ); 
        info.setVisible(true);
        info.setEditable(true);
        JScrollPane js = new JScrollPane(info);
        js.setBounds(300, 350, 950, 250); 
        info.setFont(new Font("Verdana", Font.BOLD, 10));
        this.add(js);

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

        //******************************************************************************************
        //CREACION DE TABLA
        String[] cabeza = {"Nombre Libro", "ID Libro", "Autor", "tipo", "Copias", "Disponibles", "Ocupados"}; //Arreglo del encabezado
        datos = mlibro();
        tablalibros = new JTable(datos, cabeza);
        JScrollPane js1 = new JScrollPane(tablalibros);
        js1.setBounds(300, 10, 950, 330);
        DefaultTableModel modelo = new DefaultTableModel(datos, cabeza) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.add(js1);

        //************************************************************************
        //CREACIÓN DE LA PESTAÑA LIBRO
        //Diseño de Jpanel
        this.setBackground(plateado);
        this.setLayout(null);

    }

    //*************************************************************************
    //MÉTODO PARA AÑADIR EL ARREGLO DE LIBROS
    public static void crearlib(ObLibros nuevoL) {
        if (contlibros < oblibros.length) {
            oblibros[contlibros] = nuevoL;
            contlibros++;
        }
    }

    //****************************************************************************
    //FUNCION PARA AÑADIR LOS LIBROS A LA TABLA 
    public static Object[][] mlibro() {
        Object[][] libros = new Object[contlibros][7];
        for (int i = 0; i < contlibros; i++) {
            if (oblibros[i] != null) {
                libros[i][0] = oblibros[i].getTitulo();
                libros[i][1] = oblibros[i].getIDlibro();
                libros[i][2] = oblibros[i].getAutor();
                if (oblibros[i].getTipos() == 1) {
                    libros[i][3] = "Libro";

                } else if (oblibros[i].getTipos() == 2) {
                    libros[i][3] = "Revista";
                } else if (oblibros[i].getTipos() == 3) {
                    libros[i][3] = "Libro Electronico";
                }
                libros[i][4] = oblibros[i].getCopias();
                libros[i][5] = oblibros[i].getDisponibles();
                libros[i][6] = oblibros[i].getOcupados();
            }
        }
        return libros;
    }

    //******************************************************************************
    //mÉTODO PARA abrir y leer en consola los datos de un archivo json
    public void leerarchivo() {
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
            cargamaslibros(contenido);
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

    //******************************************************************************
    //METODO PARA RETORNAR TITULO DEL LIBRO VERIFICANDO SU ID
    public static String retornarlib(int ID) {
        for (int i = 0; i < contlibros; i++) {
            if (oblibros[i].getIDlibro() == ID) {
                return oblibros[i].getTitulo();
            }
        }
        return null;
    }

    //******************************************************************************
    //METODO PARA CARGA MASIVA
    public void cargamaslibros(String content) {
        JsonParser parser = new JsonParser();
        Object contenido = parser.parse(content);
        JsonObject objetito = (JsonObject) contenido;
        Object jsonarrayobyeto = objetito.get("Libros");
        JsonArray arreglo = (JsonArray) jsonarrayobyeto;
        System.out.println("Cantidad Objetos: " + arreglo.size());
        for (int i = 0; i < arreglo.size(); i++) {
            JsonObject objeto = arreglo.get(i).getAsJsonObject();
            String Titulo = objeto.get("Titulo").getAsString();
            int ID = objeto.get("ID").getAsInt();
            String Autor = objeto.get("Autor").getAsString();
            int Tipo = objeto.get("Tipo").getAsInt();
            int Copias = objeto.get("Copias").getAsInt();
            int Disponibles = objeto.get("Disponibles").getAsInt();
            int Ocupados = objeto.get("Ocupados").getAsInt();
            ObLibros nuevo = new ObLibros(Titulo, ID, Autor, Tipo, Copias, Disponibles, Ocupados);
            crearlib(nuevo);
        }
    }

    @Override
    //se le dio vida al boton de carga masiva 1
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == masiva1) {
            System.out.println("Carga de archivo Json");
            leerarchivo();
            System.out.println(contenido);

        } //******************************************************************************
        //Esto es para darle vida al boton de ingresar datos de libro
        else if (ae.getSource() == ingresar) {
            int ID = Integer.parseInt(lib.getText()); //Esto es para pasar datos de int a String
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
            ObLibros ob = new ObLibros(Nom, ID, aut, t, c, c, 0);
            crearlib(ob);
            lib.setText("");
            nombrel.setText("");
            autor1.setText("");
            cop.setText("");
        }

    }
}
