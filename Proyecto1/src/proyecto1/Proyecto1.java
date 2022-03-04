package proyecto1;

import Interfaz.Pantalla_login;
import Interfaz.VentanaPrincipal;
import Clases.*;
import javax.swing.JOptionPane;

public class Proyecto1 {

    //Creando los arreglos para las consideraciones que nos indicaron en el enunciado
    public static ObLibros[] oblibros = new ObLibros[100];
    public static ObUsuarios[] obuser = new ObUsuarios[50];
    public static ObPrestamos[] obpres = new ObPrestamos[200];
    public static ObRegistros[] obreg = new ObRegistros[100];
    //CONTADORES PARA CARGA MASIVA
    public static int contusuario = 0, contlibros = 0, contprestamos = 0; //Inicializando contador

    public static void main(String[] args) {
        //Pantalla_login pl = new Pantalla_login();
        VentanaPrincipal vp = new VentanaPrincipal();
    }
//Metodo para añadir al arreglo de libros

    public static void crearlib(ObLibros nuevoL) {
        if (contlibros < oblibros.length) {
            oblibros[contlibros] = nuevoL;
            contlibros++;
        }
    }
    //Funcion para la tabla

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
}
