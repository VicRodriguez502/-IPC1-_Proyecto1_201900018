package Clases;

public class ObUsuarios {
    //tributos para el objeto usuarios
    private int ID;
    private String nameusuario;
    private String contrasena;
    private String facultad;
    private String carrera;
    private int tipouser;
    
    //Generamos constructor para el objeto usuarios

    public ObUsuarios(int ID, String nameusuario, String contrasena, String facultad, String carrera, int tipouser) {
        this.ID = ID;
        this.nameusuario = nameusuario;
        this.contrasena = contrasena;
        this.facultad = facultad;
        this.carrera = carrera;
        this.tipouser = tipouser;
    }
    //Genaramos encapsulamiento con get y set para lso parametros

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
     * @return the nameusuario
     */
    public String getNameusuario() {
        return nameusuario;
    }

    /**
     * @param nameusuario the nameusuario to set
     */
    public void setNameusuario(String nameusuario) {
        this.nameusuario = nameusuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the facultad
     */
    public String getFacultad() {
        return facultad;
    }

    /**
     * @param facultad the facultad to set
     */
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the tipouser
     */
    public int getTipouser() {
        return tipouser;
    }

    /**
     * @param tipouser the tipouser to set
     */
    public void setTipouser(int tipouser) {
        this.tipouser = tipouser;
    }
    
    
}
