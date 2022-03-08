package Interfaz;
//importamos las librerías que nos ayudaran con la interfaz

import Clases.ObUsuarios;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static proyecto1.Proyecto1.contusuario;
import static proyecto1.Proyecto1.obuser;

public class Pantalla_login extends JFrame implements ActionListener {
    //VARIABLES A UTILIZAR PARA TODO
    static JLabel usuario, logo;
    JLabel contra;
    JTextField inusuario;
    JPasswordField incontra;
    TextArea info;
    static JButton login;
    static JButton masiva, actualizar;
    static JTable tablausu;
    static Object[][] datos;
    
    

    //Colores
    Color plateado = new Color(113, 125, 126);
    Color verdeclaro = new Color(130, 224, 170);
    Color azulejo = new Color(39, 55, 70);

    //ATRIBUTOS Y VARIABLES PARA CREAR EL JSON Y CARGA MASIVA
    String contenido = "";
    File json1;
    FileReader lectura1;
    BufferedReader buff1;

    public Pantalla_login() {
        //*********************************************************************************
        //PARTE GRÁFICA DEL Login

        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo png msc.png")).getImage());

        //*********************************************************************************
        //CREACIÓN DE TODOS LOS BOTONES
        //Creamos el boton de carga masiva
        masiva = new JButton("Carga Masiva");
        masiva.setBounds(10, 500, 180, 35);
        masiva.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        masiva.setBackground(azulejo);
        masiva.setForeground(Color.white);
        masiva.setVisible(true);
        masiva.addActionListener(this);
        this.add(masiva);
        
         //Creamos el boton de carga masiva
        actualizar = new JButton("Actualizar");
        actualizar.setBounds(10, 450, 180, 35);
        actualizar.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        actualizar.setBackground(azulejo);
        actualizar.setForeground(Color.white);
        actualizar.setVisible(true);
        actualizar.addActionListener(this);
        this.add(actualizar);

        //Creando boton para iniciar sesión
        login = new JButton("Iniciar Sesión");
        login.setBounds(340, 220, 180, 35);
        login.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
        login.setBackground(verdeclaro);
        login.setForeground(Color.black);
        login.setVisible(true);
        login.addActionListener(this);
        this.add(login);

        //*****************************************************************************
        //CREACIÓN TODOS LOS CUADROS DE TEXTO    
        //Creando cuadro de texto para ingresar usuario
        inusuario = new JTextField();
        inusuario.setBounds(300, 110, 250, 35);
        inusuario.setFont(new Font("Verdana", Font.BOLD, 14));
        inusuario.setVisible(true);
        this.add(inusuario);

        //creando cuadro de texto para ingresar contraseña
        incontra = new JPasswordField();
        incontra.setBounds(300, 180, 250, 35);
        incontra.setFont(new Font("Verdana", Font.BOLD, 14));
        incontra.setVisible(true);
        this.add(incontra);
        
        //Creando cuadro de texto para poner los datos del json
       /* info = new TextArea();
        info.setBounds(200, 450, 300, 80);
        info.setVisible(true);
        info.setEditable(false);
        info.setFont(new Font("Verdana", Font.BOLD, 14));
        info.getText();
        this.add(info);*/

        //**************************************************************************
        //CREACIÓN TODOS LOS TITULOS    
        //vamos a crear el titulo contraseña
        contra = new JLabel("Contraseña:");
        contra.setBounds(390, 150, 100, 20);
        contra.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        contra.setForeground(plateado);
        contra.setVisible(true);
        this.add(contra);

        //vamos a crear el titulo usuario
        usuario = new JLabel("Usuario:");
        //POSICION X, POSICION Y, TAMAÑO X, TAMAÑO Y
        usuario.setBounds(400, 80, 100, 20);
        //TIPOGRAFIA
        usuario.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        //COLOR A LA LETRA
        usuario.setForeground(plateado);
        //VISIBILIDAD
        usuario.setVisible(true);
        //AGREGARLO A LA VENTANA
        this.add(usuario);

        //*******************************************************************
        //CREACIÓN DE IMAGENES PARA LOGIN
        //Creando JLabel para colocar la imagen
        logo = new JLabel();
        logo.setBounds(10, 30, 300, 300);
        logo.setIcon(setIcono("src\\Interfaz\\MSC ROSTER MAIN.png", logo));
        logo.setVisible(true); 
        this.add(logo);
        
        
        //**************************************************************************
        String[] cabeza = {"ID", "Usuario", "Password", "Facultad", "Carrera", "Tipo"}; //Arreglo del encabezado
        datos = mUsuario();
        tablausu = new JTable(datos, cabeza);
        JScrollPane js = new JScrollPane(tablausu);
        js.setBounds(220, 440, 400,100);
        DefaultTableModel modelo = new DefaultTableModel(datos, cabeza) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.add(js);

        //*********************************************************************
        //CREACIÓN DEL DISEÑO DE LA VENTANA
        //diseño de la ventana 
        this.setTitle("Proyecto 1");
        //QUITAR MARGENES
        this.setLayout(null);
        //TAMAÑO DE MI VENTANA
        //POSICION X, POSICION Y, TAMAÑO X, TAMAÑO Y
        this.setBounds(300, 100, 700, 700);
        //QUITAR EL CAMBIO DE TAMAÑO
        this.setResizable(false);
        //CERRAR Y TERMINAR EL PROCESO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //HACER VISIBLE LA VENTANA
        this.setVisible(true);

    }
    
    //*******************************************************************************
    //METODO PARA AÑADIR EL ARREGLO DE USUARIOS
    public static void crearusu(ObUsuarios usuario) {
        if (contusuario < obuser.length) {
            obuser[contusuario] = usuario;
            contusuario++;
        }
    }

    //******************************************************************************
    //FUNCIÓN PARA AÑADIR PRESTAMOS A LA TABLA
    public static Object[][] mUsuario() {
        Object[][] usuario = new Object[contusuario][6];
        for (int i = 0; i < contusuario; i++) {
            if (obuser[i] != null) {
                usuario[i][0] = obuser[i].getID();
                usuario[i][1] = obuser[i].getUsuario();
                usuario[i][2] = obuser[i].getPassword();
                usuario[i][3] = obuser[i].getFacultad();
                usuario[i][4] = obuser[i].getCarrera();
                usuario[i][5] = obuser[i].getTipo();
            }
        }
        return usuario;
    }

    //******************************************************************************
    //METODO PARA ABRIR UNA VENTANA EMERGENTE Y ESCOGER EL ARCHIVO JSON
    public void leerarchivos() {
        try {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                json1 = fc.getSelectedFile();
            } else {
                System.out.println("No abriste nada");
            }
            lectura1 = new FileReader(json1); //Obtendremos el texto 
            buff1 = new BufferedReader(lectura1); //leera el texto
            String casilla1;
            //Lo siguiente se leera linea a linea
            while ((casilla1 = buff1.readLine()) != null) {
                contenido += casilla1;
            }
            cargamasusuario(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != lectura1) {
                    lectura1.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    //******************************************************************************
    //METODO PARA LEER EN CONSOLA EL JSON
    public void leerusuario() {
        for (int i = 0; i < contusuario; i++) {
            obuser[i].Mostrarusuarios();
        }
    }

    //******************************************************************************
    //METODO PARA CARGA MASIVA UTILIZANDO LIBRERIA gson-2.2.2.jar
    public void cargamasusuario(String content) {
        JsonParser parser = new JsonParser();
        Object contenido = parser.parse(content);
        JsonObject objetito = (JsonObject) contenido;
        Object obj = objetito.get("Usuarios");
        JsonArray arreglo1 = (JsonArray) obj;
        System.out.println("Cantidad de Objetos: " + arreglo1.size());
        for (int i = 0; i < arreglo1.size(); i++) {
            JsonObject obj1 = arreglo1.get(i).getAsJsonObject();
            int ID = obj1.get("ID").getAsInt();
            String Usuario = obj1.get("Usuario").getAsString();
            String Password = obj1.get("Password").getAsString();
            String Facultad = obj1.get("Facultad").getAsString();
            String Carrera = obj1.get("Carrera").getAsString();
            int Tipo = obj1.get("Tipo").getAsInt();
            ObUsuarios nuevo = new ObUsuarios(ID, Usuario, Password, Facultad, Carrera, Tipo);
            crearusu(nuevo);
        }
        leerusuario();
    }

    //******************************************************************************
    //MÉTODO PARA PODER INSERTAR BUALQUIER IMAGEN EN ESTA CLASE
    private Icon setIcono(String path, JLabel logomsc) {
        ImageIcon icon = new ImageIcon(path);
        int ancho = logomsc.getWidth();
        int alto = logomsc.getHeight();
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    //*****************************************************************************
    //FUNCION PARA RETONAR UN USUARIO CON EL ID
    public static String retornarusu(int ID) {
        for (int i = 0; i < contusuario; i++) {
            if (obuser[i].getID() == ID) {
                return obuser[i].getUsuario();
            }
        }
        return null;
    }

    

    //*****************************************************************************
    public  boolean verificarusu(String user) {
        for (int i = 0; i < contusuario; i++) {
            if (obuser[i].getUsuario().equals(user)) {
                return true;
            }
        }
        return false;
    }

    //*****************************************************************************
    public boolean verificarcontra(String user, String contra) {
        for (int i = 0; i < contusuario; i++) {
            if (obuser[i].getUsuario().equals(user)) {
                if (obuser[i].getPassword().equals(contra)) {
                    return true;
                }
            }

        }
        return false;
    }

    //*****************************************************************************
    public ObUsuarios retornarusuario(String user) {
        for (int i = 0; i < contusuario; i++) {
            if (obuser[i].getUsuario().equals(user)) {
                return obuser[i];
            }

        }
        return null;
    }
    
    public static String ReporteU = "";
    
            
            
            
            
    public void ingresar() {
        String usu1, pass;
        System.out.println(contusuario);
        usu1 = inusuario.getText();
        pass = incontra.getText();
        ReporteU = usu1;
        System.out.println(usu1);
        System.out.println(pass);
        if (verificarusu(usu1) == true) {
            if (verificarcontra(usu1, pass) == true) {
                if (retornarusuario(usu1).getTipo() == 1) {
                    JOptionPane.showMessageDialog(this, "Bienvenido Jefe");
                    this.setVisible(false);
                    VentanaPrincipal vp = new VentanaPrincipal();
                } else if (retornarusuario(usu1).getTipo() == 2){
                    JOptionPane.showMessageDialog(this, "Usted no cuenta con los permisos para acceder al sistema");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Contraseña Invalida");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario Invalido");
        }

    }
    //******************************************************************************
    //ACCION PARA DARLE VIDA A LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == masiva) {
            System.out.println("Carga de archivo Json");
            leerarchivos();
            System.out.println(contenido);

        }
        if (e.getSource() == login) {
            ingresar();

        }if (e.getSource() == actualizar){
            Pantalla_login pl = new Pantalla_login();
            this.dispose();
        }
    }
}
