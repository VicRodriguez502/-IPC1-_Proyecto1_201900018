package Clases;

public class ObLibros {
    //Creamos los Atributos del objeto de libros
    private int IDlibro;
    private String Titulo;
    private String Autor;
    private int Tipos;
    private int Copias;
    private int Disponibles;
    private int ocupados;
    
    //Realizamos el constructor para este objeto 
    public ObLibros(int IDlibro, String Titulo, String Autor, int Tipos, int Copias, int Disponibles, int ocupados) {
        this.IDlibro = IDlibro;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Tipos = Tipos;
        this.Copias = Copias;
        this.Disponibles = Disponibles;
        this.ocupados = ocupados;
    }
    //Encapsulamos con get y set todos los parametros
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

    /**
     * @return the Disponibles
     */
    public int getDisponibles() {
        return Disponibles;
    }

    /**
     * @param Disponibles the Disponibles to set
     */
    public void setDisponibles(int Disponibles) {
        this.Disponibles = Disponibles;
    }

    /**
     * @return the ocupados
     */
    public int getOcupados() {
        return ocupados;
    }

    /**
     * @param ocupados the ocupados to set
     */
    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
    }
    
    
    
}
