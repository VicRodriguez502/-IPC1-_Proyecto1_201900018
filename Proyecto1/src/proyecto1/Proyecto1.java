package proyecto1;
import Interfaz.Pantalla_login;
import Interfaz.Pestana_Libro;
import Interfaz.VentanaPrincipal;
import Clases.*;
import javax.swing.JOptionPane;

public class Proyecto1 {
    
    //Creando los arreglos para las consideraciones que nos indicaron en el enunciado
    public static ObLibros[] oblibros = new ObLibros[100];
    public static ObUsuarios[] obuser = new ObUsuarios[50];
    public static ObPrestamos[] obpres = new ObPrestamos[200];
    public static ObRegistros[] obreg = new ObRegistros[100];
    
    public static void main(String[] args) {
        //Pantalla_login pl = new Pantalla_login();
        VentanaPrincipal vp = new VentanaPrincipal();
    }
    
}
