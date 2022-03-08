package Clases;

public class ObUsuarios {

    //******************************************************************************
    //ATRIBUTOS PARA EL OBJETO USUARIOS
    private int ID;
    private String Usuario;
    private String Password;
    private String Facultad;
    private String Carrera;
    private int Tipo;

    //******************************************************************************
    //CONSTRUCTOR PARA EL OBJETO USUARIOS
    public ObUsuarios(int ID, String Usuario, String Password, String Facultad, String Carrera, int Tipo) {
        this.ID = ID;
        this.Usuario = Usuario;
        this.Password = Password;
        this.Facultad = Facultad;
        this.Carrera = Carrera;
        this.Tipo = Tipo;
    }
    
    //******************************************************************************
    //METODO PARA LEER EL JSON EN CONSOLA
    //METODO PARA MOSTRAR LOS OBJETOS
    public void Mostrarusuarios(){
        System.out.println("******************************");
        System.out.println("**          USUARIO         **");
        System.out.println("ID: " + ID);
        System.out.println("Usuario: " + Usuario);
        System.out.println("Password: " + Password);
        System.out.println("Facultad: " + Facultad);
        System.out.println("Carrera: "+ Carrera);
        System.out.println("Tipo: "+ Tipo);
    }
    //******************************************************************************
    //ENCAPSULAMIENTO GET Y SET, PARA LOS PARAMETROS DEL OBJETO 
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Facultad
     */
    public String getFacultad() {
        return Facultad;
    }

    /**
     * @param Facultad the Facultad to set
     */
    public void setFacultad(String Facultad) {
        this.Facultad = Facultad;
    }

    /**
     * @return the Carrera
     */
    public String getCarrera() {
        return Carrera;
    }

    /**
     * @param Carrera the Carrera to set
     */
    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    /**
     * @return the Tipo
     */
    public int getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

}
