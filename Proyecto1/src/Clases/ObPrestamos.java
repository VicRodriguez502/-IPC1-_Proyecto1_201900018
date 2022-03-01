package Clases;

public class ObPrestamos {
    //Creamos los Atributos del objeto Prestamos
    private int IDlibro;
    private int IDusuario;
    private String fechasinda;
    
    //Generamos el constructor para el objeto de prestamos
    public ObPrestamos(int IDlibro, int IDusuario, String fechasinda) {
        this.IDlibro = IDlibro;
        this.IDusuario = IDusuario;
        this.fechasinda = fechasinda;
    }
    //Generamso encapsulamiento con get y Set para los parametros

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
     * @return the IDusuario
     */
    public int getIDusuario() {
        return IDusuario;
    }

    /**
     * @param IDusuario the IDusuario to set
     */
    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }

    /**
     * @return the fechasinda
     */
    public String getFechasinda() {
        return fechasinda;
    }

    /**
     * @param fechasinda the fechasinda to set
     */
    public void setFechasinda(String fechasinda) {
        this.fechasinda = fechasinda;
    }
    
}
