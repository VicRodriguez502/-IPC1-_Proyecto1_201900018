
package Clases;

public class ObRegistros {
    //Atributos para el objeto registros
    private String ReporteUsuarios;
    private String ReporteLibrosReg;
    private String ReportesPrestrealizados;
    
    //Generamos constructor para este objeto de registros

    public ObRegistros(String ReporteUsuarios, String ReporteLibrosReg, String ReportesPrestrealizados) {
        this.ReporteUsuarios = ReporteUsuarios;
        this.ReporteLibrosReg = ReporteLibrosReg;
        this.ReportesPrestrealizados = ReportesPrestrealizados;
    }
    //Encapsulamos con get y set los parametros

    /**
     * @return the ReporteUsuarios
     */
    public String getReporteUsuarios() {
        return ReporteUsuarios;
    }

    /**
     * @param ReporteUsuarios the ReporteUsuarios to set
     */
    public void setReporteUsuarios(String ReporteUsuarios) {
        this.ReporteUsuarios = ReporteUsuarios;
    }

    /**
     * @return the ReporteLibrosReg
     */
    public String getReporteLibrosReg() {
        return ReporteLibrosReg;
    }

    /**
     * @param ReporteLibrosReg the ReporteLibrosReg to set
     */
    public void setReporteLibrosReg(String ReporteLibrosReg) {
        this.ReporteLibrosReg = ReporteLibrosReg;
    }

    /**
     * @return the ReportesPrestrealizados
     */
    public String getReportesPrestrealizados() {
        return ReportesPrestrealizados;
    }

    /**
     * @param ReportesPrestrealizados the ReportesPrestrealizados to set
     */
    public void setReportesPrestrealizados(String ReportesPrestrealizados) {
        this.ReportesPrestrealizados = ReportesPrestrealizados;
    }
    
}
