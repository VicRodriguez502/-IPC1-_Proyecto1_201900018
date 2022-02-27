package Clases;

public class ObLibros {
    //Creamos el objeto Libros
    //Atributos
    private int IDlibro;
    private String Titulo;
    private String Autor;
    private int Tipos;
    private int Copias;
    
    //Constructor

    public ObLibros(int IDlibro, String Titulo, String Autor, int Tipos, int Copias) {
        this.IDlibro = IDlibro;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Tipos = Tipos;
        this.Copias = Copias;
    }
    //Metodo para mostrar el objeto de libros
    public void MostrarIngresoLib(){
        System.out.println("*************************************");
        System.out.println("**       INGRESO DE LIBROS         **");
        System.out.println("ID Libro: " + IDlibro);
        System.out.println("Titulo: " + Titulo);
        System.out.println("Autor: " + Autor);
        System.out.println("Tipos: " + Tipos);
        System.out.println("Copias: " + Copias);
    }
    
    
   //Encapsulamiento
  /**
     * @return the IDlibro
     */
    public int getIDlibro() {
        return IDlibro;
    }

    /**
     * @param IDlibro the IDlibro to set
     */
    public void setIDlibro(int IDlibro) {
        this.IDlibro = IDlibro;
    }

    /**
     * @return the Titulo
     */
    public String getTitulo() {
        return Titulo;
    }

    /**
     * @param Titulo the Titulo to set
     */
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    /**
     * @return the Autor
     */
    public String getAutor() {
        return Autor;
    }

    /**
     * @param Autor the Autor to set
     */
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    /**
     * @return the Tipos
     */
    public int getTipos() {
        return Tipos;
    }

    /**
     * @param Tipos the Tipos to set
     */
    public void setTipos(int Tipos) {
        this.Tipos = Tipos;
    }

    /**
     * @return the Copias
     */
    public int getCopias() {
        return Copias;
    }

    /**
     * @param Copias the Copias to set
     */
    public void setCopias(int Copias) {
        this.Copias = Copias;
    }
    
    
}
