
package Estructura;

import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CargaMasiva {
    private File path;
    private FileReader entrada;
    private boolean abierto;
    
    public void CargaMasiva()
    {
        JFileChooser choose = new JFileChooser();
        choose.setCurrentDirectory(new java.io.File("."));
        choose.setDialogTitle("Carga de Archivo");
        FileNameExtensionFilter filtro=new FileNameExtensionFilter(".json","json");
        choose.addChoosableFileFilter(filtro);
        choose.setAcceptAllFileFilterUsed(true);
        
        if(choose.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            System.out.println("Archivo Abierto");
            path =choose.getSelectedFile();
//            System.out.println(path);
            abierto=true;
        }
        else
        {
            System.out.println("Archivo No Abierto");
            abierto=false;
        }
    }
    
    }
    

