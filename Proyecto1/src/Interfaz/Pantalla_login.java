
package Interfaz;
//importamos las librerías que nos ayudaran con la interfaz
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Pantalla_login extends JFrame implements ActionListener{
    static JLabel usuario, logo;
    JLabel contra;
    JTextField inusuario;
    JPasswordField incontra;
    static JButton login;
    static JButton masiva;
    //Colores
    Color plateado = new Color(113, 125, 126);
    Color verdeclaro = new Color(130, 224, 170);
    Color azulejo = new Color(39, 55, 70);
    
    public Pantalla_login(){
     //*********************************************************************************
     //PARTE GRÁFICA DEL Login
     
        //ICONO DE LA APLICACION
        setIconImage(new ImageIcon(getClass().getResource("Logo png msc.png")).getImage());
        
    //*********************************************************************************
    //CREACIÓN DE TODOS LOS BOTONES
    
    
        //Creamos el boton de carga masiva
        masiva = new JButton("Carga Masiva");
        masiva.setBounds(10,500,180,35);
        masiva.setFont(new Font("Franklin Gothic Medium", Font.BOLD,14));
        masiva.setBackground(azulejo);
        masiva.setForeground(Color.white);
        masiva.setVisible(true);
        masiva.addActionListener(this);
        this.add(masiva);
        
        
        //Creando boton para iniciar sesión
        login = new JButton("Iniciar Sesión");
        login.setBounds(340,220,180,35);
        login.setFont(new Font("Franklin Gothic Medium", Font.BOLD,14));
        login.setBackground(verdeclaro);
        login.setForeground(Color.black);
        login.setVisible(true);
        login.addActionListener(this);
        this.add(login);
        
    //*****************************************************************************
    //CREACIÓN TODOS LOS CUADROS DE TEXTO    
       
        //Creando cuadro de texto para ingresar usuario
        inusuario = new JTextField();
        inusuario.setBounds(300,110,250,35);
        inusuario.setFont(new Font("Verdana", Font.BOLD,14));
        inusuario.setVisible(true);
        this.add(inusuario);
        
        //creando cuadro de texto para ingresar contraseña
        incontra = new JPasswordField();
        incontra.setBounds(300,180,250,35);
        incontra.setFont(new Font("Verdana", Font.BOLD,14));
        incontra.setVisible(true);
        this.add(incontra);
        
    //**************************************************************************
    //CREACIÓN TODOS LOS TITULOS    
        
        //vamos a crear el titulo contraseña
        contra = new JLabel("Contraseña:");
        contra.setBounds(390,150,100,20);
        contra.setFont(new Font("Arial Narrow", Font.BOLD,18));
        contra.setForeground(plateado);
        contra.setVisible(true);
        this.add(contra);
        
        //vamos a crear el titulo usuario
        usuario = new JLabel("Usuario:");
        //POSICION X, POSICION Y, TAMAÑO X, TAMAÑO Y
        usuario.setBounds(400,80,100,20);
        //TIPOGRAFIA
        usuario.setFont(new Font("Arial Narrow", Font.BOLD,18));
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
        logo.setBounds(10,30, 350, 400);
        logo.setIcon(setIcono("src\\Interfaz\\MSC ROSTER MAIN.png",logo));
        logo.setVisible(true); //(500, 150, 600, 600);
        this.add(logo);
        
    //*********************************************************************
    //CREACIÓN DEL DISEÑO DE LA VENTANA
    
        //diseño de la ventana 
        this.setTitle("Proyecto 1");
        //QUITAR MARGENES
        this.setLayout(null);
        //TAMAÑO DE MI VENTANA
        //POSICION X, POSICION Y, TAMAÑO X, TAMAÑO Y
        this.setBounds(500, 150, 600, 600);
        //QUITAR EL CAMBIO DE TAMAÑO
        this.setResizable(false);
        //CERRAR Y TERMINAR EL PROCESO
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //HACER VISIBLE LA VENTANA
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== login) {
            login();
            
        }
    }
    
  public void login(){
      JOptionPane.showMessageDialog(this,"Hola mundo");
  }
  //MÉTODO PARA PODER INSERTAR BUALQUIER IMAGEN EN ESTA CLASE
  private Icon setIcono(String path, JLabel logomsc)
    {
        ImageIcon icon = new ImageIcon(path);
        int ancho=logomsc.getWidth();
        int alto=logomsc.getHeight();
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
}

    

